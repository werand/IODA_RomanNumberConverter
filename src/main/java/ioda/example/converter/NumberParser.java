package ioda.example.converter;

public class NumberParser {

    public int number;
    public boolean isNumber = false;

    public static NumberParser tryParse(String number)
    {
        NumberParser parse = new NumberParser();
        try {
            parse.number = Integer.parseInt(number);
            parse.isNumber = true;
        } catch (NumberFormatException e) {
            parse.isNumber = false;
        }
        return parse;
    }

}
