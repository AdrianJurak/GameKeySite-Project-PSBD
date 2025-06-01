package pl.studia.GameKeySite_Project_PSBD.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.GameKeySite_Project_PSBD.mapper.GameMapper;
import pl.studia.GameKeySite_Project_PSBD.model.Game;
import pl.studia.GameKeySite_Project_PSBD.model.Publisher;
import pl.studia.GameKeySite_Project_PSBD.model.command.CreateGameCommand;
import pl.studia.GameKeySite_Project_PSBD.model.data.GameSearchParam;
import pl.studia.GameKeySite_Project_PSBD.model.dto.GameDto;
import pl.studia.GameKeySite_Project_PSBD.model.enums.Genre;
import pl.studia.GameKeySite_Project_PSBD.model.enums.Platform;
import pl.studia.GameKeySite_Project_PSBD.repository.GameRepository;
import pl.studia.GameKeySite_Project_PSBD.repository.PublisherRepository;


import static pl.studia.GameKeySite_Project_PSBD.mapper.GameMapper.mapFromCommand;
import static pl.studia.GameKeySite_Project_PSBD.mapper.GameMapper.mapToDto;
import static pl.studia.GameKeySite_Project_PSBD.service.specification.GameSpecificationFilter.*;


@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final PublisherRepository publisherRepository;

    @Transactional
    public GameDto create(CreateGameCommand command) {
        Integer publisherId = command.getPublisherId();
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new RuntimeException());
        // TODO - obsługa wyjątków

        validateEnum(Genre.class, command.getGenre());
        validateEnum(Platform.class, command.getPlatform());

        return mapToDto(gameRepository.save(mapFromCommand(command, publisher)));
    }

    @Transactional
    public GameDto getById(Integer id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        // TODO - obsługa wyjątków

        return mapToDto(game);
    }

    @Transactional
    public Page<GameDto> getAll(GameSearchParam param, Pageable pageable) {
        Specification<Game> specification = Specification
                .where(nameInformation(param.getName()))
                .and(genreInformation(param.getGenre()))
                .and(platformInformation(param.getPlatform()))
                .and(publisherInformation(param.getPublisher()))
                .and(priceBetweenInformation(param.getLowerPrice(), param.getUpperPrice()));

        return gameRepository.findAll(specification, pageable)
                .map(GameMapper::mapToDto);
    }

    private <E extends Enum<E>> void validateEnum(Class<E> enumClass, String value) {
        try {
            Enum.valueOf(enumClass, value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException();
            // TODO - obsługa wyjątków
        }
    }
}
