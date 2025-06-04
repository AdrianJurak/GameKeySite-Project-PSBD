package pl.studia.GameKeySite_Project_PSBD.exception;

import java.text.MessageFormat;

public class NotFoundException extends RuntimeException {

    private static final String ID_MESSAGE = "{0} with id {1} not found";

    public NotFoundException(Class<?> clazz, Integer id) {
        super(MessageFormat
                .format(ID_MESSAGE, clazz.getSimpleName(), id));
    }
}
