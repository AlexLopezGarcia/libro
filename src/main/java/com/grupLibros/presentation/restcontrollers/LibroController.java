package com.grupLibros.libro;

import com.grupLibros.bussiness.Libro;
import com.grupLibros.bussiness.LibroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libro")

public class LibroController {
    @Autowired
    private com.grupLibros.bussiness.LibroServices libroServices;

    // mètode GET per obtenir tots els usuaris
    @GetMapping
    public List<Libro> obtenirTotsElsUsuaris() {
        return libroServices.getAll();
    }

    // mètode GET per obtenir un usuari per ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenirUsuariPerId(@PathVariable Long id) {
        Optional<Libro> libro = libroServices.read(id);
        return libro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

        // mètode POST per crear un nou usuari
        @PostMapping
        public ResponseEntity<Libro> crearUsuari(@RequestBody Libro libro) {
            Libro usuariCreat = libroServices.create(libro);
            return new ResponseEntity<>(usuariCreat, HttpStatus.CREATED);
        }

        // mètode PUT per actualitzar un usuari existent
        @PutMapping("/{id}")
        public ResponseEntity<Libro> actualitzarUsuari(@PathVariable Long id, @RequestBody Libro libro) {
            Optional<Libro> usuariActualitzat = libroServices.update(libro);
            return usuariActualitzat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        // mètode DELETE per eliminar un usuari per ID
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminarUsuari(@PathVariable Long id) {
            if (libroServices.delete(id)) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
}
}
