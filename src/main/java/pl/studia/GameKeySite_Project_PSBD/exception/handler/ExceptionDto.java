package pl.studia.GameKeySite_Project_PSBD.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExceptionDto {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final String message;

    public ExceptionDto(String message) {
        this.message = message;
    }
}
