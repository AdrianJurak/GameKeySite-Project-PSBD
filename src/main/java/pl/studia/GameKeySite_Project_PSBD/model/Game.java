package pl.studia.GameKeySite_Project_PSBD.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private String name;
    private String shortDescription;
    private String description;
    private BigDecimal price;

    @CreationTimestamp
    private LocalDate creationDate;
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private Set<Review> reviews;

    //Todo dodać platformę oraz gatunek
}