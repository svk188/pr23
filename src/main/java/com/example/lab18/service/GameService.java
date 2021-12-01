package com.example.lab18.service;

import com.example.lab18.entities.Game;
import com.example.lab18.repos.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameService implements GameServiceInterface{

    @Autowired
    GameRepository gameRepository;
    @Autowired
    EmailService emailService;
    @Transactional
    @Override
    public List<Game> getAllGames() {
        log.info("Find all games");
        return gameRepository.findAll(); }
    @Transactional
    @Override
    public List<Game> getAllGamesByDate() {
        log.info("Sort Games by Date");
        return gameRepository.findAll(Sort.by(Sort.Direction.ASC, "creationDate"));
    }
    @Transactional
    @Override
    public List<Game> getAllGamesByName() {
        log.info("Sort Games by Name");
        return gameRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
    @Transactional
    @Override
    public void addGame(Game game) {
        log.info("Starting the service addGame");
        emailService.sendMessage(game.toString());
        gameRepository.save(game);
    }
}
