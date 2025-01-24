package com.grupLibros.bussiness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libro {
    private Long id;
    private String titulo;
    private String autor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libroId;

    public Libro(Long id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Libro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public Long getLibroId() {
        return libroId;
    }

    @Override
    public String toString() {
        return "libro: isbn " + id + ", titulo " + titulo + ", autor " + autor;
    }
}
