package pl.studia.GameKeySite_Project_PSBD.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.studia.GameKeySite_Project_PSBD.model.command.CreateReviewCommand;
import pl.studia.GameKeySite_Project_PSBD.service.ReviewService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public String getCreate() {
        return "create-review-page";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid CreateReviewCommand command) {
        reviewService.create(command);
        return "redirect:/api/v1/games";
    }
}