package com.grupLibros.presentation.restcontrollers;

import com.grupLibros.bussiness.model.Libro;
import com.grupLibros.bussiness.services.LibroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroServices libroServices;

    @GetMapping
    public List<Libro> getAll() {
        return libroServices.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<Libro> optional = libroServices.read(id);
        if (!optional.isPresent()) {
            return new ResponseEntity<>("No se encuentra el libro con ID " + id, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(optional.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Libro libro, UriComponentsBuilder ucb) {
        Long id = libroServices.create(libro);
        URI uri = ucb.path("/libros/{id}").build(id);
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        libroServices.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Libro libro) {
        libroServices.update(libro);
    }
}
