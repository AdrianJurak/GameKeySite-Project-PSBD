package pl.studia.GameKeySite_Project_PSBD.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private String name;
    private String info;
    private LocalDate dateOfEstablishment;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private Set<Game> games;
}