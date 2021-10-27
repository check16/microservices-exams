package com.formacionbdi.microservicios.app.examenes.models.repository;

import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExamenRepository extends CrudRepository<Examen, Long> {

    List<Examen> findByNombreContaining(String nombre);

}
