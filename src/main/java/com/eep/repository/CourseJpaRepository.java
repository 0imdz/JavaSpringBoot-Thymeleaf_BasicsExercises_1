package com.eep.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eep.entity.Course;

@Repository ("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository <Course,Serializable>{

    public abstract Course findById(int id);

    public abstract Course findByPrecio(int precio);
    // Query automática que consulta por precio sin ninguna implementación

    public abstract Course findByPrecioAndNombre( int precio, String nombre);
    // Consulta con AND

    public abstract List<Course> findByNombreOrderByHoras (String name);
    // Consulta Ordenada

    public abstract Course findByNombreOrPrecio(String nombre, int precio);
    // Consulta con OR
}
