package com.example.lab18.service;

import com.example.lab18.entities.Level;

import javax.transaction.Transactional;
import java.util.List;

public interface LevelServiceInterface {

    List<Level> getAllLevels();
    List<Level> getAllLevelsByName();
    List<Level> getAllLevelsByCompl();
    void addLevel(Level level);
}
