package pl.studia.GameKeySite_Project_PSBD.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.studia.GameKeySite_Project_PSBD.model.command.CreatePublisherCommand;
import pl.studia.GameKeySite_Project_PSBD.service.PublisherService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping
    public String getCreate() {
        return "create-publisher-page";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid CreatePublisherCommand command) {
        publisherService.create(command);
        return "redirect:/api/v1/games";
    }
}
