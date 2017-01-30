package ioda.example.converter.flow;

import ioda.example.converter.contract.ConverterBody;
import ioda.example.converter.contract.InputProvider;
import ioda.example.converter.contract.OutputProvider;

/**
 * Head: The head is responsible for triggering body behavior.
 * It integrates the body with input from and output to the user.
 */
public class Head {

    private InputProvider inputProvider;
    private ConverterBody converterBody;
    private OutputProvider outputProvider;

    public Head(InputProvider inputProvider, ConverterBody converterBody, OutputProvider outputProvider) {
        this.inputProvider = inputProvider;
        this.converterBody = converterBody;
        this.outputProvider = outputProvider;
    }

    public void execute() {
        String input = inputProvider.readNumberToConvert();
        this.converterBody.convert(input).peek(
                outputProvider::displayError,
                outputProvider::displayResult);
    }

}
