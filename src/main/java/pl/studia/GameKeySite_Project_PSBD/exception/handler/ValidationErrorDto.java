package pl.studia.GameKeySite_Project_PSBD.exception.handler;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationErrorDto extends ExceptionDto {

    private static final String MESSAGE = "Validation error";

    private final List<ViolationInfo> violations = new ArrayList<>();

    public ValidationErrorDto() {
        super(MESSAGE);
    }

    public void addViolation(String field, String message) {
        violations.add(new ViolationInfo(field, message));
    }

    public record ViolationInfo(String field, String message) {
    }
}
