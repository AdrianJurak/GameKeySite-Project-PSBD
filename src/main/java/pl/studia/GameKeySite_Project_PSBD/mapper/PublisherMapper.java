package pl.studia.GameKeySite_Project_PSBD.mapper;

import lombok.experimental.UtilityClass;
import pl.studia.GameKeySite_Project_PSBD.model.Publisher;
import pl.studia.GameKeySite_Project_PSBD.model.command.CreatePublisherCommand;
import pl.studia.GameKeySite_Project_PSBD.model.dto.PublisherDto;

import java.time.LocalDate;

@UtilityClass
public class PublisherMapper {
    public static Publisher mapFromCommand(CreatePublisherCommand command) {
        return Publisher.builder()
                .name(command.getName())
                .info(command.getInfo())
                .dateOfEstablishment(LocalDate.parse(command.getDateOfEstablishment()))
                .build();
    }

    public static PublisherDto mapToDto(Publisher publisher) {
        return PublisherDto.builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .info(publisher.getInfo())
                .dateOfEstablishment(publisher.getDateOfEstablishment())
                .build();
    }
}
