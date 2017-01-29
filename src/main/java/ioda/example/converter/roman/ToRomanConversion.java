package ioda.example.converter.roman;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ToRomanConversion {

	private static TreeMap<Integer, String> numberToChar = new TreeMap<Integer, String>(Collections.reverseOrder());
	
	static {
		numberToChar.put(1000, "M");
		numberToChar.put(900, "CM");
		numberToChar.put(500, "D");
		numberToChar.put(400, "CD");
		numberToChar.put(100, "C");
		numberToChar.put(90, "XC");
		numberToChar.put(50, "L");
		numberToChar.put(40, "XL");
		numberToChar.put(10, "X");
		numberToChar.put(9, "IX");
		numberToChar.put(5, "V");
		numberToChar.put(4, "IV");
		numberToChar.put(1, "I");
	}
	
	private static List<String> toRomanNumber(Integer arabicNumber)
	{
		List<String> romanNumber = new ArrayList<String>();
		while (arabicNumber > 0) {
			for (Entry<Integer, String> entry : numberToChar.entrySet()) {
				while (arabicNumber >= entry.getKey()) {
					arabicNumber -= entry.getKey();
					romanNumber.add(entry.getValue());
				}
			}
		}
		return romanNumber;
	}

	public static String convert(Integer arabicNumber) {
		return toRomanNumber(arabicNumber).stream().collect(Collectors.joining());
	}

}