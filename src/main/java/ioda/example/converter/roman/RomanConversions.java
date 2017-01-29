package ioda.example.converter.roman;
import java.util.function.Consumer;

import ioda.example.converter.Conversion;
import ioda.example.converter.NumberParser;

/**
 * RomanConversions: This class belongs to the coarse grained domain aspect of the application. 
 * It contains "helper functions" not actually concerned with the transformations.
 */
public class RomanConversions {

	public static void determineNumberType(String number, Consumer<String> roman, Consumer<Integer> arabic) {
		NumberParser tryParse = NumberParser.tryParse(number);
		if (tryParse.isNumber) {
			arabic.accept(tryParse.number);
		} else {
			roman.accept(number);
		}
	}
	
	public static void validateRomanNumber(String romanNumber, Conversion onValid, Consumer<String> onError) {
		if (romanNumber.toUpperCase().matches("^[IVXLCDM]+$")) {
			onValid.convert();
		} else {
			onError.accept("Es handelt sich nicht um eine römische Zahl! " + romanNumber);
		}
	}

	public static void validateArabicNumber(Integer arabicNumber, Conversion onValid, Consumer<String> onError) {
		if (arabicNumber > 0 && arabicNumber <= 3000) {
			onValid.convert();
		} else {
			onError.accept("Ungültiger Wertebereich, Wert muss zwischen 0 und 3001 liegen: " + arabicNumber);
		}
	} 

}