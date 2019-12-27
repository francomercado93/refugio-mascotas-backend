package com.refugiomascotas.controllers;


import com.refugiomascotas.models.Mascota;
import com.refugiomascotas.repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class MascotaController {

    @Autowired
    private MascotaRepository mascotaRepository;

    private Map<String, Object> makeMap(String key, Object value) {
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put(key, value);
        return dto;
    }

    @RequestMapping("/mascotas")
    //List<Map<String, Object>>
    public List<Object> getAllMascotas() {
        return mascotaRepository.findAll()
                .stream()
                .map(mascota -> mascota.makeDTO())
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "/mascotas/{id}")
    public ResponseEntity<Map<String, Object>> findMascotaById(@PathVariable Long id) {
        ResponseEntity<Map<String, Object>> responseEntity;
        Mascota mascotaBuscada = mascotaRepository.findById(id).orElse(null);
        if (mascotaBuscada == null) {
            responseEntity = new ResponseEntity<>(this.makeMap("error", "No existe mascota con id " + id), HttpStatus.FORBIDDEN);
        } else {
            responseEntity = new ResponseEntity<>(mascotaBuscada.makeDTO(), HttpStatus.ACCEPTED);
        }
        return responseEntity;
    }

    @RequestMapping(path = "/mascotas", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createMascota(@RequestBody Mascota nuevaMascota) {
        ResponseEntity<Map<String, Object>> responseEntity;
        System.out.println(nuevaMascota);
        mascotaRepository.save(nuevaMascota);
        responseEntity = new ResponseEntity<>(this.makeMap("id", nuevaMascota.getId()), HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(path = "/mascotas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteMascota(@PathVariable Long id) {
        ResponseEntity<Map<String, Object>> responseEntity;
        Mascota mascotaBuscada = mascotaRepository.findById(id).orElse(null);
        if (mascotaBuscada == null) {
            responseEntity = getResponseEntity("error", "No se pudo encontrar la mascota con el id " + id, HttpStatus.BAD_REQUEST);
        } else {
            mascotaRepository.delete(mascotaBuscada);
            responseEntity = getResponseEntity("error", "Mascota " + mascotaBuscada.getNombre() + " eliminada de la base de datos", HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(path = "/mascotas", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateMascota(@RequestBody Mascota mascotaActualizada) {
        ResponseEntity<Map<String, Object>> responseEntity;
        mascotaRepository.save(mascotaActualizada);
        responseEntity = new ResponseEntity<>(HttpStatus.OK);
        return responseEntity;
    }

    private ResponseEntity<Map<String, Object>> getResponseEntity(String error, String message, HttpStatus httpStatus) {
        return new ResponseEntity<>(this.makeMap(error, message), httpStatus);
    }
}