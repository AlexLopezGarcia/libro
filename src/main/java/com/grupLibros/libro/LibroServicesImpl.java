package com.grupLibros.libro;

import java.util.List;
import java.util.Optional;

public class LibroServicesImpl implements LibroServices {

    @Override
    public Long create(Libro libro) {
        return 0L;
    }

    @Override
    public Optional<Libro> read(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Libro libro) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Libro> getAll() {
        return List.of();
    }
}
