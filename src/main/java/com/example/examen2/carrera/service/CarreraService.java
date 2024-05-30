package com.example.examen2.carrera.service;

import com.example.examen2.carrera.model.Carrera;
import com.example.examen2.carrera.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public List<Carrera> getAllCarreras() {
        return carreraRepository.findAll();
    }

    public Carrera createCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public Carrera getCarreraById(Long id) {
        return carreraRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
    }

    public Carrera updateCarrera(Long id, Carrera carreraDetails) {
        Carrera carrera = carreraRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        carrera.setNombre(carreraDetails.getNombre());
        carrera.setCodigo(carreraDetails.getCodigo());
        carrera.setFacultad(carreraDetails.getFacultad());
        carrera.setMaterias(carreraDetails.getMaterias());

        return carreraRepository.save(carrera);
    }

    public void deleteCarrera(Long id) {
        Carrera carrera = carreraRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
        carreraRepository.delete(carrera);
    }
}
