package pl.studia.GameKeySite_Project_PSBD.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;


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

    //todo add genre and publisher
}
