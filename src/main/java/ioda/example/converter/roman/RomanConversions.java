package ioda.example.converter.roman;
import static com.jnape.palatable.lambda.adt.Either.left;
import static com.jnape.palatable.lambda.adt.Either.right;
import static ioda.example.converter.NumberParser.tryParse;

import com.jnape.palatable.lambda.adt.Either;

import ioda.example.converter.NumberParser;
import ioda.example.converter.contract.Error;

/**
 * RomanConversions: This class belongs to the coarse grained domain aspect of the application.
 * It contains "helper functions" not actually concerned with the transformations.
 */
public class RomanConversions {

    public static Either<Integer, String> determineNumberType(String number) {
        NumberParser tryParse = tryParse(number);
        if (tryParse.isNumber) {
            return left(tryParse.number);
        } else {
            return right(number);
        }
    }

    public static Either<Error, String> validateRomanNumber(String romanNumber) {
        if (romanNumber.toUpperCase().matches("^[IVXLCDM]+$")) {
            return right(romanNumber);
        } else {
            return left(new Error("Es handelt sich nicht um eine römische Zahl! " + romanNumber));
        }
    }


    public static Either<Error, Integer> validateArabicNumber(Integer arabicNumber) {
        if (arabicNumber > 0 && arabicNumber <= 3000) {
            return right(arabicNumber);
        } else {
            return left(new Error("Ungültiger Wertebereich, Wert muss zwischen 0 und 3001 liegen: " + arabicNumber));
        }
    }

}
