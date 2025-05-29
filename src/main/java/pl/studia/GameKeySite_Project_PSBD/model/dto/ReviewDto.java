package pl.studia.GameKeySite_Project_PSBD.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReviewDto {

    private int id;
    private String userName;
    private int stars;
    private String opinion;
    private int gameId;
}
