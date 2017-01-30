package ioda.example.converter.contract;

/**
 * Created by andreas on 30.01.17.
 */
public class Error {
    private String errorMessage;

    public Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}
