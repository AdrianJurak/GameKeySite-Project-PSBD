package pl.studia.GameKeySite_Project_PSBD.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.studia.GameKeySite_Project_PSBD.model.command.CreateGameCommand;
import pl.studia.GameKeySite_Project_PSBD.service.GameService;
import pl.studia.GameKeySite_Project_PSBD.model.data.GameSearchParam;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/games")
public class GameController {

    private final GameService gameService;

    @GetMapping("/change-language")
    public String changeLanguage(@RequestParam("lang") String lang, HttpServletResponse response) {
        Cookie cookie = new Cookie("lang", lang);
        cookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/api/v1/games";
    }

    @GetMapping("/create")
    public String getCreate() {
        return "create-game-page";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid CreateGameCommand command) {
        gameService.create(command);
        return "redirect:/api/v1/games";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable int id) {
        model.addAttribute("game", gameService.getById(id));
        return "game-id-page";
    }

    @GetMapping
    public String getAll(Model model, GameSearchParam param,
                         @PageableDefault(sort = "releaseDate", direction = DESC, size = 2) Pageable pageable) {
        model.addAttribute("games", gameService.getAll(param, pageable));
        return "home-page";
    }
}