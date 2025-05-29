package pl.studia.GameKeySite_Project_PSBD.model.command;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateReviewCommand {

    private static final String POLISH_PATTERN = "[0-9A-Za-z\\sĄąĆćĘęŁłŃńÓóŚśŹźŻż]";

    @NotNull
    private int gameId;

    @NotNull
    @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻ]" + POLISH_PATTERN + "{1,30}|^\\d*" + POLISH_PATTERN + "{1,30}", message = "PATTERN_MISMATCH_{regexp}")
    private String userName;

    @NotNull
    @Min(value = 0, message = "INVALID_REVIEW_VALUE")
    @Max(value = 5, message = "INVALID_REVIEW_VALUE")
    private int stars;

    @NotNull
    @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻ]" + POLISH_PATTERN + "{1,16382}|^\\d*" + POLISH_PATTERN + "{1,16382}", message = "PATTERN_MISMATCH_{regexp}")
    private String opinion;

}