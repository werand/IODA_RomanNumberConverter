package ioda.example.converter.roman;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FromRomanConversion {

    private static final Map<String, Integer> romanToInt = new HashMap<String, Integer>();

    static {
        romanToInt.put("I", new Integer(1));
        romanToInt.put("V", new Integer(5));
        romanToInt.put("X", new Integer(10));
        romanToInt.put("L", new Integer(50));
        romanToInt.put("C", new Integer(100));
        romanToInt.put("D", new Integer(500));
        romanToInt.put("M", new Integer(1000));
    }

    public static String convert(String romanNumber) {
        List<Integer> values = romanNumber.chars()
                   .map((ch) -> romanToInt.get(String.valueOf((char) ch)))
                   .mapToObj((value) -> Integer.valueOf(value))
                   .collect(Collectors.toList());
        int sum = 0;
        Integer lastValue = new Integer(0);
        int negate = 1;
        for (Integer value : values)
        {
            negate = lastValue.compareTo(value) < 0 ? -1 : 1;
            sum += lastValue * negate;
            lastValue = value;
        }
        sum += lastValue;
        return "" + sum;
    }

}
