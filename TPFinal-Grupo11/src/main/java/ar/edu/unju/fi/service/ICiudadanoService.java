package ar.edu.unju.fi.service;



import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;

@Service
public interface ICiudadanoService {
	public Ciudadano getCiudadano();
	public boolean guardarCiudadano(Ciudadano ciudadano);

}
