package com.grupLibros.bussiness;

import com.grupLibros.bussiness.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroServices {
    Long create(Libro libro);	    // C
    Optional<Libro> read(Long id);  // R
    void update(Libro libro);		// U
    void delete(Long id);		// D
    List<Libro> getAll();
}
