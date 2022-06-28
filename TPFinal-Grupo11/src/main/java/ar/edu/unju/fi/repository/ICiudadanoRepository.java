package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.entity.Ciudadano;

public interface ICiudadanoRepository extends JpaRepository<Ciudadano, Long> {

}
