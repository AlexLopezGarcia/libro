package com.grupLibros.bussiness.repository;

import com.grupLibros.bussiness.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    // Spring method signature method
    List<Libro> findByAutor(String autor);

    // Custom query method
    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:keyword%")
    List<Libro> findByTitleContaining(@Param("keyword") String keyword);
}