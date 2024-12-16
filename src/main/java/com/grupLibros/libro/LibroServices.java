package com.grupLibros.libro;

import java.util.List;
import java.util.Optional;

public interface LibroServices {
    Long create(Libro libro);	    // C
    Optional<Libro> read(Long id);  // R
    void update(Libro libro);		// U
    boolean delete(Long id);		// D
    List<Libro> getAll();
}
