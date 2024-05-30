package com.example.examen2.materia.service;

import com.example.examen2.materia.model.Materia;
import com.example.examen2.materia.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    public Materia createMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    public Materia getMateriaById(Long id) {
        return materiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Materia no encontrada"));
    }

    public Materia updateMateria(Long id, Materia materiaDetails) {
        Materia materia = materiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        materia.setNombre(materiaDetails.getNombre());
        materia.setCreditos(materiaDetails.getCreditos());
        materia.setCarrera(materiaDetails.getCarrera());

        return materiaRepository.save(materia);
    }

    public void deleteMateria(Long id) {
        Materia materia = materiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Materia no encontrada"));
        materiaRepository.delete(materia);
    }
}
