package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trainer.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

}
