package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.entity.Ciudadano;

public interface ICiudadanoRepository extends JpaRepository<Ciudadano, Long> {
	public Optional<Ciudadano> findByDni(Long dni);
}
