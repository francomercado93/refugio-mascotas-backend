package com.refugiomascotas.controllers;

import com.refugiomascotas.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class TipoController {

    @Autowired
    private TipoRepository tipoRepository;

    @RequestMapping("/tipos")
    //List<Map<String, Object>>
    public List<Object> getAllTipos() {
        return tipoRepository.findAll()
                .stream()
                .map(tipo -> tipo.makeDTO())
                .collect(Collectors.toList());
    }
}
