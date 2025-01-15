package com.grupLibros.presentation.restcontrollers;

import com.grupLibros.bussiness.model.Libro;
import com.grupLibros.bussiness.services.LibroServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
@Tag(name = "Libros", description = "Gestión de libros")
public class LibroController {

    @Autowired
    private LibroServices libroServices;

    @Operation(summary = "Obtener todos los libros", description = "Devuelve una lista de todos los libros.")
    @GetMapping
    public ResponseEntity<List<Libro>> getAll() {
        return ResponseEntity.ok(libroServices.getAll());
    }

    @Operation(summary = "Obtener un libro por ID", description = "Devuelve un libro específico según el ID.")
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<Libro> optional = libroServices.read(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @Operation(summary = "Crear un libro", description = "Agrega un nuevo libro al sistema.")
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Libro libro) {
        Long id = libroServices.create(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body("Libro creado con ID: " + id);
    }

    @Operation(summary = "Actualizar un libro", description = "Actualiza los datos de un libro existente.")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Libro libro) {
        Optional<Libro> optional = libroServices.read(id);
        if (optional.isPresent()) {
            libro.setId(id);
            libroServices.update(libro);
            return ResponseEntity.ok("Libro actualizado");
        }
        return new ResponseEntity<>("Libro no encontrado", HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Eliminar un libro", description = "Elimina un libro específico del sistema.")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<Libro> optional = libroServices.read(id);
        if (optional.isPresent()) {
            libroServices.delete(id);
            return ResponseEntity.ok("Libro eliminado");
        }
        return new ResponseEntity<>("Libro no encontrado", HttpStatus.NOT_FOUND);
    }
}
