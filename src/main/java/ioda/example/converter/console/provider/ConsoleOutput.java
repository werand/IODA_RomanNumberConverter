package ioda.example.converter.console.provider;

import ioda.example.converter.contract.Error;
import ioda.example.converter.contract.OutputProvider;

public class ConsoleOutput implements OutputProvider {

	@Override
	public void displayResult(String result) {
		System.out.println(result);
	}

	@Override
	public void displayError(Error error) {
		System.out.println(error.getErrorMessage());
	}
}