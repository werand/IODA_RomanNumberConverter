package ioda.example.converter.roman.flow;
import java.util.function.Consumer;

import ioda.example.converter.roman.FromRomanConversion;
import ioda.example.converter.roman.RomanConversions;
import ioda.example.converter.roman.ToRomanConversion;

public class RomanConverter {

	public static void convert(String number, Consumer<String> onSuccess, Consumer<String> onError) {
		RomanConversions.determineNumberType(
				number,
				(romanNumber) -> {
					RomanConversions.validateRomanNumber(
							romanNumber, 
							() -> {
								String result = FromRomanConversion.convert(romanNumber);
								onSuccess.accept(result);
							},
							onError);
				},
				(arabicNumber) -> {
					RomanConversions.validateArabicNumber(
							arabicNumber,
							() -> {
								String result = ToRomanConversion.convert(arabicNumber);
								onSuccess.accept(result);
							},
							onError);
				});
	}

}