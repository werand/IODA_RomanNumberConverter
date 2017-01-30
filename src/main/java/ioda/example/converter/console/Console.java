package ioda.example.converter.console;

import ioda.example.converter.console.provider.ConsoleInput;
import ioda.example.converter.console.provider.ConsoleOutput;
import ioda.example.converter.flow.Head;
import ioda.example.converter.roman.flow.RomanConverter;

public class Console {

    public static void main(String[] args) {
        new Console().run();
    }

    private void run() {
        Head head = new Head(new ConsoleInput(), RomanConverter::convert, new ConsoleOutput());
        head.execute();
    }
}
