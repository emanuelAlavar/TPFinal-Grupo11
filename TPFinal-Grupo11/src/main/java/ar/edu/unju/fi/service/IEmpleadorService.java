package ar.edu.unju.fi.service;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleador;
@Service
public interface IEmpleadorService {
	public Empleador getEmpleador();
	public boolean guardarEmpleador(Empleador empleador);
}
