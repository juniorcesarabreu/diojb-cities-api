package dev.juniorcesarabreu.citiesapi.repository;

import dev.juniorcesarabreu.citiesapi.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}