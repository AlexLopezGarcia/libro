package com.grupLibros.bussiness.services;

import com.grupLibros.bussiness.model.Libro;
import com.grupLibros.bussiness.services.LibroServices;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class LibroServicesImpl implements LibroServices {
    private TreeMap<Long, Libro> libros = new TreeMap<>();
    private Long currentId =1L;

    @Override
    public Optional<Libro> read(Long id){
        return Optional.ofNullable(libros.get(id));
    };

    @Override
    public Long create(Libro libro) {
        if(libro == null){
            return -1L;
        } else {
            libros.put(libro.getId(), libro);
            return libro.getId();
        }
    }

    @Override
    public void update(Libro libro) {
        if(libro == null){
            throw new NullPointerException("Libro null");
        } else {
            libros.get(libro.getId()).setTitulo(libro.getTitulo());
        }
    }

    @Override
    @DeleteMapping
    public void delete(Long id) {
        boolean temp;
        if(libros.containsKey(id)){
            libros.remove(id);
            temp = true;
        }else {
            temp = false;
        }
    }

    @Override
    public List<Libro> getAll() {
        return libros.values().stream().collect(Collectors.toList());
    }
}
