package pl.studia.GameKeySite_Project_PSBD.model.data;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameSearchParam {

    private String name;

    private String lowerPrice;
    private String upperPrice;

    private String genre;
    private String platform;
    private String publisher;

}
