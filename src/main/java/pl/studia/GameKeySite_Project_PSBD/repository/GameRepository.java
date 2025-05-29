package pl.studia.GameKeySite_Project_PSBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.studia.GameKeySite_Project_PSBD.model.Game;

public interface GameRepository extends JpaRepository<Game, Integer>, JpaSpecificationExecutor<Game> {
}

