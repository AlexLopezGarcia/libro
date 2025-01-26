package com.grupLibros.presentation.restcontrollers;

import com.grupLibros.bussiness.model.Libro;
import com.grupLibros.bussiness.model.LibroDTO;
import com.grupLibros.bussiness.services.LibroServicesImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/libros")
@Tag(name = "Libros", description = "Gestión de libros")
public class LibroController {
    @Autowired
    private LibroServicesImpl libroServices;

    @GetMapping
    public ResponseEntity<List<LibroDTO>> getAll() {
        List<LibroDTO> libroDTOs = libroServices.getAll().stream()
                .map(LibroDTO.LibroMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(libroDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        return libroServices.read(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Libro libro) {
        Long id = libroServices.create(libro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Libro creado con ID: " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Libro libro) {
        if (libroServices.read(id).isPresent()) {
            libro.setId(id);
            libroServices.update(libro);
            return ResponseEntity.ok("Libro actualizado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Libro no encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (libroServices.read(id).isPresent()) {
            libroServices.delete(id);
            return ResponseEntity.ok("Libro eliminado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Libro no encontrado");
    }
}