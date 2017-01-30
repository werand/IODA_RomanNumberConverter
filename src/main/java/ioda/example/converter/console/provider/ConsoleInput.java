package ioda.example.converter.console.provider;

import java.util.Scanner;

import ioda.example.converter.contract.InputProvider;

public class ConsoleInput implements InputProvider {

    @Override
    public String readNumberToConvert() {
        System.out.print("Arabische oder römische Zahl eingeben: ");
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

}
