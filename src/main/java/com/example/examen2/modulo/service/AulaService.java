package com.example.examen2.modulo.service;

import com.example.examen2.modulo.model.Aula;
import com.example.examen2.modulo.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    public List<Aula> getAllAulas() {
        return aulaRepository.findAll();
    }

    public Aula createAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    public Aula getAulaById(Long id) {
        return aulaRepository.findById(id).orElseThrow(() -> new RuntimeException("Aula no encontrada"));
    }

    public Aula updateAula(Long id, Aula aulaDetails) {
        Aula aula = aulaRepository.findById(id).orElseThrow(() -> new RuntimeException("Aula no encontrada"));

        aula.setNombre(aulaDetails.getNombre());
        aula.setLatitud(aulaDetails.getLatitud());
        aula.setLongitud(aulaDetails.getLongitud());

        return aulaRepository.save(aula);
    }

    public void deleteAula(Long id) {
        Aula aula = aulaRepository.findById(id).orElseThrow(() -> new RuntimeException("Aula no encontrada"));
        aulaRepository.delete(aula);
    }
}
