package com.example.lab18.repos;


import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<com.example.lab18.entities.Game, Long> {
}