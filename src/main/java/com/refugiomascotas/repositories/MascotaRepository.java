package com.refugiomascotas.repositories;

import com.refugiomascotas.models.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
