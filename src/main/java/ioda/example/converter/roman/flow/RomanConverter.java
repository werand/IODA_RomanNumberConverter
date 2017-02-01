package ioda.example.converter.roman.flow;
import static com.jnape.palatable.lambda.adt.Either.left;
import static com.jnape.palatable.lambda.adt.Either.right;

import com.jnape.palatable.lambda.adt.Either;

import ioda.example.converter.contract.Error;
import ioda.example.converter.roman.FromRomanConversion;
import ioda.example.converter.roman.RomanConversions;
import ioda.example.converter.roman.ToRomanConversion;

public class RomanConverter {

    public static Either<Error, String> convert(String number) {
        return RomanConversions.determineNumberType(number)
                .match(romanNumber -> validateAndConvertRomanNumber(romanNumber),
                       arabicNumber -> validateAndConvertArabicNumber(arabicNumber));
    }

    private static Either<Error, String> validateAndConvertRomanNumber(String romanNumber) {
        return RomanConversions.validateRomanNumber(romanNumber)
                .match(error -> left(error),
                       number -> right(FromRomanConversion.convert(number)));
    }

    private static Either<Error, String> validateAndConvertArabicNumber(Integer arabicNumber) {
        return RomanConversions.validateArabicNumber(arabicNumber)
                .match(error -> left(error),
                       number -> right(ToRomanConversion.convert(number)));
    }
}