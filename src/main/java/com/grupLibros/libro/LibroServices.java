package com.grupLibros.libro;

import java.util.List;
import java.util.Optional;

public interface LibroServices {
    Long create(Libro libro);	    // C
    Optional<Libro> read(Long id);   // R

    /*Llança una IllegalStateException si el codi de la persona és null o no existeix al sistema*/
    void update(Libro libro);		// U

    /*Llança una IllegalStateException si no existeix la id en el sistema*/
    void delete(Long id);				// D

    List<Libro> getAll();

}
