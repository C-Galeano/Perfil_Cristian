package com.example.demo.Service;

import com.example.demo.Model.Estudiante;
import com.example.demo.Repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EstudianteServiceIMP implements EstudianteService{

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceIMP(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<Estudiante> listar() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
        return null;
    }



}