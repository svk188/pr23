
package com.example.lab18.controller;


import com.example.lab18.entities.Game;
import com.example.lab18.entities.Level;
import com.example.lab18.service.GameService;
import com.example.lab18.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/home")
public class Controller {

    private static List<Level> levels1 = new ArrayList<>();
    private static List<Game> games1 = new ArrayList<>();

    @Autowired
    GameService gameService;

    @Autowired
    LevelService levelService;

    @Value("${home.name}")
    private String name;
    @Value("${home.group}")
    private String group;
    @Value("${home.variant}")
    private String var;
    private Boolean flag = true;
    @GetMapping
    public String home(Model model) {
        model.addAttribute("name", name);
        model.addAttribute("group", group);
        model.addAttribute("variant", var);
        return "home";
    }

    @GetMapping("/levelsList")
    public String levelList(Model model) {
        if(flag) {
            levels1 = levelService.getAllLevels();
            games1 = gameService.getAllGames();
        }
        Level level = new Level();
        Game game = new Game();
        model.addAttribute("level", level);
        model.addAttribute("game", game);
        model.addAttribute("levels", levels1);
        model.addAttribute("games", games1);
        return "levelsList";
    }

    @PostMapping("/sortLevelCompl")
    public String sortLevel(@ModelAttribute("Level") Level Level) {
        flag = false;
        levels1 = levelService.getAllLevelsByCompl();
        return "redirect:levelsList";
    }
    @PostMapping("/sortLevelName")
    public String sortLevelName(@ModelAttribute("Level") Level Level) {
        flag = false;
        levels1 = levelService.getAllLevelsByName();
        return "redirect:levelsList";
    }

    @PostMapping("/sortGameName")
    public String sortGameName(@ModelAttribute("Level") Game Game) {
        flag = false;
        games1 = gameService.getAllGamesByName();
        return "redirect:levelsList";
    }
    @PostMapping("/sortGameDate")
    public String sortGameDate(@ModelAttribute("Level") Game Game) {
        flag = false;
        games1 = gameService.getAllGamesByDate();
        return "redirect:levelsList";
    }
    @GetMapping("/addLevel")
    public String addedLevel(Model model) {
        Level newLevel = new Level();
        model.addAttribute("newLevel", newLevel);

        return "addLevel";
    }

    @PostMapping("/addLevel")
    public String addLevel(@ModelAttribute("newLevel") Level newLevel) {
        levelService.addLevel(newLevel);
        return "redirect:levelsList";
    }

    @GetMapping("/addGame")
    public String addedGame(Model model) {
        Game newGame = new Game();
        model.addAttribute("newGame", newGame);

        return "addGame";
    }

    @PostMapping("/addGame")
    public String addGame(@ModelAttribute("newGame") Game newGame) {
        gameService.addGame(newGame);

        return "redirect:levelsList";
    }

}
