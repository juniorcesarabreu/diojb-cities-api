package dev.juniorcesarabreu.citiesapi.resources;

import dev.juniorcesarabreu.citiesapi.entities.City;
import dev.juniorcesarabreu.citiesapi.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("cities")
public class CityResource {

    private final CityRepository repository;

    public CityResource(final CityRepository repository) {
        this.repository = repository;
    }

  /* 1st
  @GetMapping
  public List<City> cities() {
      return repository.findAll();
  }*/

    // 2nd - Pageable
    @GetMapping
    public Page<City> cities(final Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable Long id) {
        Optional<City> city = repository.findById(id);

        if (city.isPresent()) {
            return ResponseEntity.ok().body(city.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}