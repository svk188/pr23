package com.example.lab18.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "levels")
@NoArgsConstructor
public class Level {
    @Id
    @SequenceGenerator(name = "game_seq", sequenceName = "game_seq", allocationSize = 1)
    @GeneratedValue(generator = "game_seq", strategy = GenerationType.SEQUENCE)

    private Long id;

    @Column(name = "complexity")
    private int complexity;

    @Column(name = "levelname")
    private String levelName;

    public Level(int complexity, String levelName){
        this.complexity = complexity;
        this.levelName = levelName;

    }
    @ManyToOne(targetEntity = Game.class)
    @JoinColumn(name = "game_id", insertable = false,updatable = false)
    @JsonIgnore
    public Game game;

    @Override
    public String toString() {
        return "Level{" +
                "name='" + levelName + '\'' +
                ", complexity='" + complexity + '\'' +
                '}';
    }

}
