package com.refugiomascotas.repositories;

import com.refugiomascotas.models.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface TipoRepository extends JpaRepository<Tipo, Long> {
}
