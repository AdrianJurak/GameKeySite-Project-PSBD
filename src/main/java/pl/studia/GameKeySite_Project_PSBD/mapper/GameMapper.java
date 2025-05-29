package pl.studia.GameKeySite_Project_PSBD.mapper;

import lombok.experimental.UtilityClass;
import pl.studia.GameKeySite_Project_PSBD.model.Game;
import pl.studia.GameKeySite_Project_PSBD.model.Publisher;
import pl.studia.GameKeySite_Project_PSBD.model.command.CreateGameCommand;
import pl.studia.GameKeySite_Project_PSBD.model.dto.GameDto;


import java.time.LocalDate;
import java.util.stream.Collectors;

import static java.math.BigDecimal.valueOf;

@UtilityClass
public class GameMapper {
    public static Game mapFromCommand(CreateGameCommand command, Publisher publisher) {
        return Game.builder()
                .name(command.getName())
                .shortDescription(command.getShortDescription())
                .description(command.getDescription())
                .price(valueOf(command.getPrice()))
                .creationDate(LocalDate.now())
                .releaseDate(LocalDate.parse(command.getReleaseDate()))
                .publisher(publisher)
                .build();
    }

    public static GameDto mapToDto(Game game) {
        return GameDto.builder()
                .id(game.getId())
                .name(game.getName())
                .shortDescription(game.getShortDescription())
                .description(game.getDescription())
                .price(game.getPrice())
                .creationDate(game.getCreationDate())
                .releaseDate(game.getReleaseDate())
                .publisher(PublisherMapper.mapToDto(game.getPublisher()))
                .reviews(game.getReviews() == null ? null : game.getReviews().stream()
                        .map(ReviewMapper::mapToDto)
                        .collect(Collectors.toSet()))
                .build();
    }
}