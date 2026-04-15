package com.example.demo.Controller;

import com.example.demo.Model.Estudiante;
import com.example.demo.Service.EstudianteServiceIMP;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstudianteController {
    private final EstudianteServiceIMP estudianteService;

    public EstudianteController(EstudianteServiceIMP estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.listar();

        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Estudiante> guardar  (@RequestBody Estudiante estudiante){
        Estudiante estudianteguardar = estudianteService.guardar(estudiante);
        return ResponseEntity.status(201).body(estudianteguardar);
    }

}