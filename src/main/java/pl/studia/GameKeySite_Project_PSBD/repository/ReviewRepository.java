package pl.studia.GameKeySite_Project_PSBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.GameKeySite_Project_PSBD.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
