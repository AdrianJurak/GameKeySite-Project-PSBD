package pl.studia.GameKeySite_Project_PSBD.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PublisherDto {

    private int id;
    private String name;
    private String info;
    private LocalDate dateOfEstablishment;

}
