package pl.studia.GameKeySite_Project_PSBD.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.GameKeySite_Project_PSBD.model.command.CreatePublisherCommand;
import pl.studia.GameKeySite_Project_PSBD.model.dto.PublisherDto;
import pl.studia.GameKeySite_Project_PSBD.repository.PublisherRepository;

import static pl.studia.GameKeySite_Project_PSBD.mapper.PublisherMapper.mapFromCommand;
import static pl.studia.GameKeySite_Project_PSBD.mapper.PublisherMapper.mapToDto;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Transactional
    public PublisherDto create(CreatePublisherCommand command) {
        return mapToDto(publisherRepository.save(mapFromCommand(command)));
    }
}
