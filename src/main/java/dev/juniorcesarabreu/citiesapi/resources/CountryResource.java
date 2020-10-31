package dev.juniorcesarabreu.citiesapi.resources;

import dev.juniorcesarabreu.citiesapi.entities.Country;
import dev.juniorcesarabreu.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    // injeção de dependencia. outra alternativa é criar um construtor recebendo o repository como parametro (spring entende)
    private CountryRepository repository;

//    @GetMapping
//    public List<Country> countries() {
//        return repository.findAll();
//    }

    @GetMapping
    public Page<Country> countries(Pageable page) {
        // Pageable permite paginar, para não buscar todos os registros de uma vez
        // http://localhost:8080/countries?page=0&size=10&sort=name,asc

        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id) {
        // http://localhost:8080/countries/1

        Optional<Country> optional = repository.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
