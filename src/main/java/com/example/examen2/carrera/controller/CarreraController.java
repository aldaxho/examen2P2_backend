package com.example.examen2.carrera.controller;

import com.example.examen2.carrera.model.Carrera;
import com.example.examen2.carrera.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carreras/")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<Carrera> getAllCarreras() {
        return carreraService.getAllCarreras();
    }

    @PostMapping
    public Carrera createCarrera(@RequestBody Carrera carrera) {
        return carreraService.createCarrera(carrera);
    }

    @GetMapping("/{id}")
    public Carrera getCarreraById(@PathVariable Long id) {
        return carreraService.getCarreraById(id);
    }

    @PutMapping("/{id}")
    public Carrera updateCarrera(@PathVariable Long id, @RequestBody Carrera carreraDetails) {
        return carreraService.updateCarrera(id, carreraDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCarrera(@PathVariable Long id) {
        carreraService.deleteCarrera(id);
    }
}
