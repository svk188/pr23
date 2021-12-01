package com.example.lab18.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "games")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "creationdate")
    private String creationDate;

    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private List<Level> levels;

    public Game(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }
    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}