package pl.studia.GameKeySite_Project_PSBD.exception;

import java.text.MessageFormat;

public class InvalidEnumException extends RuntimeException {
    private static final String MESSAGE = "Invalid enum for {0}: {1}";

    public InvalidEnumException(Class<?> clazz, String enumType) {
        super(MessageFormat
                .format(MESSAGE, clazz.getSimpleName(), enumType));
    }
}
