package com.grupLibros.bussiness.services;

import com.grupLibros.bussiness.model.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class LibroServicesImpl implements LibroServices {
    private final TreeMap<Long, Libro> libros = new TreeMap<>();
    private Long currentId = 1L;

    @Override
    public Optional<Libro> read(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        return Optional.ofNullable(libros.get(id));
    }

    @Override
    public Long create(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }
        libro.setId(currentId++);
        libros.put(libro.getId(), libro);
        return libro.getId();
    }

    @Override
    public void update(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }
        if (!libros.containsKey(libro.getId())) {
            throw new IllegalArgumentException("No se encontró un libro con el ID especificado: " + libro.getId());
        }
        libros.put(libro.getId(), libro);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        if (!libros.containsKey(id)) {
            throw new IllegalArgumentException("No se encontró un libro con el ID especificado: " + id);
        }
        libros.remove(id);
    }

    @Override
    public List<Libro> getAll() {
        return new ArrayList<>(libros.values());
    }

    @Override
    public String toString() {
        return "LibroServicesImpl libros " + libros + ", currentId " + currentId;
    }
}
