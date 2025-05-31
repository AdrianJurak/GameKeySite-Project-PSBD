package pl.studia.GameKeySite_Project_PSBD.mapper;

import lombok.experimental.UtilityClass;
import pl.studia.GameKeySite_Project_PSBD.model.Game;
import pl.studia.GameKeySite_Project_PSBD.model.Review;
import pl.studia.GameKeySite_Project_PSBD.model.command.CreateReviewCommand;
import pl.studia.GameKeySite_Project_PSBD.model.dto.ReviewDto;

@UtilityClass
public class ReviewMapper {
    public static Review mapFromCommand(CreateReviewCommand command, Game game) {
        return Review.builder()
                .userName(command.getUserName())
                .stars(command.getStars())
                .opinion(command.getOpinion())
                .game(game)
                .build();
    }

    public static ReviewDto mapToDto(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .userName(review.getUserName())
                .stars(review.getStars())
                .opinion(review.getOpinion())
                .gameId(review.getGame().getId())
                .build();
    }
}
