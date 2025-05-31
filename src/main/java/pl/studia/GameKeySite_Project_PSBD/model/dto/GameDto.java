package pl.studia.GameKeySite_Project_PSBD.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import pl.studia.GameKeySite_Project_PSBD.model.enums.Genre;
import pl.studia.GameKeySite_Project_PSBD.model.enums.Platform;


@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameDto {

    private int id;
    private String name;
    private String shortDescription;
    private String description;
    private BigDecimal price;
    private LocalDate creationDate;
    private LocalDate releaseDate;
    private Genre genre;
    private Platform platform;

    private PublisherDto publisher;
    private Set<ReviewDto> reviews;

}
