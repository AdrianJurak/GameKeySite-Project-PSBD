package pl.studia.GameKeySite_Project_PSBD.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.GameKeySite_Project_PSBD.model.Publisher;
import pl.studia.GameKeySite_Project_PSBD.model.command.CreateGameCommand;
import pl.studia.GameKeySite_Project_PSBD.model.dto.GameDto;
import pl.studia.GameKeySite_Project_PSBD.repository.GameRepository;
import pl.studia.GameKeySite_Project_PSBD.repository.PublisherRepository;

import static pl.studia.GameKeySite_Project_PSBD.mapper.GameMapper.mapFromCommand;
import static pl.studia.GameKeySite_Project_PSBD.mapper.GameMapper.mapToDto;


@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final PublisherRepository publisherRepository;

    @Transactional
    public GameDto create(CreateGameCommand command) {
        Integer publisherId = command.getPublisherId();
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(RuntimeException::new);
        //TODO add invalid enums exception and validation


        return mapToDto(gameRepository.save(mapFromCommand(command, publisher)));
    }
}