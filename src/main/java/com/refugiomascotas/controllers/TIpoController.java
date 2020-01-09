package com.refugiomascotas.controllers;

import com.refugiomascotas.repositories.MascotaRepository;
import com.refugiomascotas.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class TIpoController {

    @Autowired
    private TipoRepository tipoRepository;

    private Map<String, Object> makeMap(String key, Object value) {
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put(key, value);
        return dto;
    }

    @RequestMapping("/tipos")
    //List<Map<String, Object>>
    public List<Object> getAllTipos() {
        return tipoRepository.findAll()
                .stream()
                .map(tipo -> tipo.makeDTO())
                .collect(Collectors.toList());
    }
}
