package com.example.lab18.service;

import com.example.lab18.entities.Level;
import com.example.lab18.repos.LevelRepository;

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
public class LevelService implements LevelServiceInterface{
    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    EmailService emailService;
    @Transactional
    @Override
    public List<Level> getAllLevels() {
        log.info("Find all levels");
        return levelRepository.findAll();
    }
    @Transactional
    @Override
    public List<Level> getAllLevelsByName() {
        log.info("Sort Levels by Name");
        return levelRepository.findAll(Sort.by(Sort.Direction.ASC, "levelName"));
    }
    @Transactional
    @Override
    public List<Level> getAllLevelsByCompl() {
        log.info("Sort Levels by Complexity");
        return levelRepository.findAll(Sort.by(Sort.Direction.ASC, "complexity"));
    }

    @Transactional
    @Override
    public void addLevel(Level level) {
        log.info("Starting the service addLevel");
        emailService.sendMessage(level.toString());
        levelRepository.save(level);
    }


}
