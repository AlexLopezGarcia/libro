package com.grupLibros.bussiness.model;

public class LibroDTO {
    private Long id;
    private String titulo;
    private String autor;

    public LibroDTO(Long id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
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

    public class LibroMapper {
        public static LibroDTO toDTO(Libro libro) {
            return new LibroDTO(libro.getId(), libro.getTitulo(), libro.getAutor());
        }
    }
}
