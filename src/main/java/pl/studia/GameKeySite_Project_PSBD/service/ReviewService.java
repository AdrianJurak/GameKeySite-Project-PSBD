package pl.studia.GameKeySite_Project_PSBD.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.GameKeySite_Project_PSBD.model.Game;
import pl.studia.GameKeySite_Project_PSBD.model.command.CreateReviewCommand;
import pl.studia.GameKeySite_Project_PSBD.model.dto.ReviewDto;
import pl.studia.GameKeySite_Project_PSBD.repository.GameRepository;
import pl.studia.GameKeySite_Project_PSBD.repository.ReviewRepository;

import static pl.studia.GameKeySite_Project_PSBD.mapper.ReviewMapper.mapFromCommand;
import static pl.studia.GameKeySite_Project_PSBD.mapper.ReviewMapper.mapToDto;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final GameRepository gameRepository;

    @Transactional
    public ReviewDto create(CreateReviewCommand command) {
        Integer gameId = command.getGameId();
        Game game = gameRepository.findById(gameId)
                .orElseThrow(RuntimeException::new);

        return mapToDto(reviewRepository.save(mapFromCommand(command, game)));
    }
}