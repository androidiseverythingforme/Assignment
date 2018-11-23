package vikrant.wipro.com.assignment.base;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

public class AppException extends Exception {
    public enum AppExceptionType {
        NETWORK_NOT_AVAILABLE_ERROR,
        IO_EXCEPTION,
        SERVER_EXCEPTION,
        DB_EXCEPTION,
        VALIDATION_EXCEPTION,
        GENERAL;
    }

    private final AppExceptionType mExceptionType;
    private final String mErrorMessage;

    public AppException(AppExceptionType appExceptionType, String errorMessage) {
        super(errorMessage);
        this.mErrorMessage = errorMessage;
        this.mExceptionType = appExceptionType;
    }

    public AppExceptionType getExceptionType() {
        return mExceptionType;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }
}
