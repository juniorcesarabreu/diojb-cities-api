package dev.juniorcesarabreu.citiesapi.repository;

import dev.juniorcesarabreu.citiesapi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends
        JpaRepository<Country, Long> { // passa o tipo de entidade, e o tipo do identidicador da entidade


}
