package pl.studia.GameKeySite_Project_PSBD.model.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateGameCommand {

    @NotNull
    private int publisherId;

    @NotNull
    @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻ][0-9A-Za-z\\sĄąĆćĘęŁłŃńÓóŚśŹźŻż]{1,30}|^\\d*[A-Z][0-9A-Za-z\\sĄąĆćĘęŁłŃńÓóŚśŹźŻż]{1,30}", message = "PATTERN_MISMATCH_{regexp}")
    private String name;

    @NotNull
    @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻ][0-9A-Za-z\\sĄąĆćĘęŁłŃńÓóŚśŹźŻż]{1,255}|^\\d*[0-9A-Za-z\\sĄąĆćĘęŁłŃńÓóŚśŹźŻż]{1,255}", message = "PATTERN_MISMATCH_{regexp}")
    private String shortDescription;

    @NotNull
    @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻ][0-9A-Za-z\\sĄąĆćĘęŁłŃńÓóŚśŹźŻż]{1,16382}|^\\d*[0-9A-Za-z\\sĄąĆćĘęŁłŃńÓóŚśŹźŻż]{1,16382}", message = "PATTERN_MISMATCH_{regexp}")
    private String description;

    @NotNull
    @Min(value = 0, message = "INVALID_PRICE_VALUE")
    private double price;

    @NotNull
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}", message = "PATTERN_MISMATCH_{regexp}")
    private String releaseDate;

    @NotNull(message = "GAME_GENRE_NULL")
    private String genre;

    @NotNull(message = "GAME_PLATFORM_NULL")
    private String platform;


}
