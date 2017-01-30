package ioda.example.converter.contract;

import com.jnape.palatable.lambda.adt.Either;

/**
 * Body: This class represents the overall functionality - but without the interaction with
 * the user. It's like an internal API to what the program is supposed to do.
 */
public interface ConverterBody {

    Either<Error, String> convert(String number);

}
