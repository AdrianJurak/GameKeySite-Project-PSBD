package pl.studia.GameKeySite_Project_PSBD.model.command;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePublisherCommand {

    @NotNull
    @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻ][0-9A-Za-z\\sĄąĆćĘęŁłŃńÓóŚśŹźŻż]{1,30}|^\\d*[A-Z][0-9A-Za-z\\sĄąĆćĘęŁłŃńÓóŚśŹźŻż]{1,30}", message = "PATTERN_MISMATCH_{regexp}")
    private String name;

    @NotNull
    @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻ][0-9A-Za-z\\sĄąĆćĘęŁłŃńÓóŚśŹźŻż]{1,16382}|^\\d*[0-9A-Za-z\\sĄąĆćĘęŁłŃńÓóŚśŹźŻż]{1,16382}", message = "PATTERN_MISMATCH_{regexp}")
    private String info;

    @NotNull
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}", message = "PATTERN_MISMATCH_{regexp}")
    private String dateOfEstablishment;

}
