package pl.studia.GameKeySite_Project_PSBD.model;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private String userName;
    private int stars;
    private String opinion;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}