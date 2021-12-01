package com.example.lab18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

@Service
public class SchedulerService {

    @Autowired
    GameService gameService;
    @Autowired
    LevelService levelService;

    @Scheduled(cron = "0 */30 * * * *")
    public void task() throws IOException {
        String path = "C:/Users/Ferma301/Desktop/pr23/src/main/java/com/example/lab18/files";
        System.out.println("Scheduled task");
        for (File myFile : Objects.requireNonNull(new File(path).listFiles())) {
            if (myFile.isFile()) myFile.delete();
        }

        File file = new File(path +"/Games.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(gameService.getAllGames().toString());
        fileWriter.close();

        file = new File(path +"/Levels.txt");
        file.createNewFile();
        fileWriter = new FileWriter(file);
        fileWriter.write(levelService.getAllLevels().toString());
        fileWriter.close();
    }
}