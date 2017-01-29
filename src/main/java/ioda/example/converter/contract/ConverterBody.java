package ioda.example.converter.contract;

import java.util.function.Consumer;

/**
 * Body: This class represents the overall functionality - but without the interaction with 
 * the user. It's like an internal API to what the program is supposed to do.
 */
public interface ConverterBody {

	void convert(String number, Consumer<String> onSuccess, Consumer<String> onError);

}
