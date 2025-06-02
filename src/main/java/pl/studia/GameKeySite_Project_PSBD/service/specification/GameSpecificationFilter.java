package pl.studia.GameKeySite_Project_PSBD.service.specification;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import pl.studia.GameKeySite_Project_PSBD.model.Game;

import java.math.BigDecimal;

@UtilityClass
public class GameSpecificationFilter {

    public static Specification<Game> nameInformation(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) {
                return null;
            }
            String pattern = "%" + name.toLowerCase() + "%";
            return criteriaBuilder.or(
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("name")), pattern));
        };
    }

    public static Specification<Game> priceBetweenInformation(String lowerPrice, String upperPrice) {
        String rootCriteria = "price";

        return (root, query, criteriaBuilder) -> {
            BigDecimal min = lowerPrice != null && !lowerPrice.isEmpty()
                    ? new BigDecimal(lowerPrice)
                    : null;
            BigDecimal max = upperPrice != null && !upperPrice.isEmpty()
                    ? new BigDecimal(upperPrice)
                    : null;
            if (min == null && max == null) {
                return null;
            }

            if (min != null && max != null) {
                return criteriaBuilder.between(root.get(rootCriteria), min, max);
            } else if (min != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(rootCriteria), min);
            } else {
                return criteriaBuilder.lessThanOrEqualTo(root.get(rootCriteria), max);
            }
        };
    }

    public static Specification<Game> genreInformation(String genre) {
        return (root, query, criteriaBuilder) -> {
            if (genre == null || genre.isEmpty()) {
                return null;
            }

            String pattern = "%" + genre.toUpperCase() + "%";
            return criteriaBuilder.or(
                    criteriaBuilder.like(
                            criteriaBuilder.upper(root.get("genre")), pattern));
        };
    }

    public static Specification<Game> platformInformation(String platform) {
        return (root, query, criteriaBuilder) -> {
            if (platform == null || platform.isEmpty()) {
                return null;
            }

            String pattern = "%" + platform.toUpperCase() + "%";
            return criteriaBuilder.or(
                    criteriaBuilder.like(
                            criteriaBuilder.upper(root.get("platform")), pattern));
        };
    }

    public static Specification<Game> publisherInformation(String publisherName) {
        return (root, query, criteriaBuilder) -> {
            if (publisherName == null || publisherName.isEmpty()) {
                return null;
            }

            String pattern = "%" + publisherName.toLowerCase() + "%";
            return criteriaBuilder.or(
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("publisher").get("name")), pattern));
        };
    }
}
