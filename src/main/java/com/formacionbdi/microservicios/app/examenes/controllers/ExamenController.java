package com.formacionbdi.microservicios.app.examenes.controllers;

import com.formacionbdi.microservicios.app.examenes.services.ExamenService;
import com.formacionbdi.microservicios.commons.controllers.CommonController;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {
        Optional<Examen> o = service.findById(id);
        if (!o.isPresent()) {
            return ResponseEntity.notFound()
                                 .build();
        }
        Examen examenBD = o.get();
        examenBD.setNombre(examen.getNombre());
        examenBD.setPreguntas(examen.getPreguntas());
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(service.save(examenBD));
    }

}
