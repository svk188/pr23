package com.example.lab18.service;

import com.example.lab18.entities.Game;


import java.util.List;

public interface GameServiceInterface {

    List<Game> getAllGames();

    List<Game> getAllGamesByDate();

    List<Game> getAllGamesByName();

    void addGame(Game game);
}
