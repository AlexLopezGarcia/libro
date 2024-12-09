package com.grupLibros.libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class LibroController {
    @Autowired
    private LibroServices libroServices;

    @GetMapping("/libro")
    public List<Libro> getAll(){
        return libroServices.getAll();
    }

    @GetMapping("/libros/{id}")
    public ResponseEntity<Libro> getById(@PathVariable Long id){
        Optional<Libro> optional = libroServices.read(id);

        if(optional.isPresent()==false){
            RespuestaError respuestaError = new RespuestaError("No se encuentra el libro");
            return new ResponseEntity<>(respuestaError, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(optional.get());
    }
    @PostMapping("/libros ")
    public ResponseEntity<Libro> create(@RequestBody Libro libro){

    }
}
