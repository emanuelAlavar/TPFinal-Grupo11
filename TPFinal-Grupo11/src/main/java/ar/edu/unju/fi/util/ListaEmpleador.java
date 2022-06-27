package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Empleador;

@Component
public class ListaEmpleador {
	private ArrayList<Empleador> empleadores;
	
	public void setEmpleador(ArrayList<Empleador> empleadores) {
		this.empleadores = empleadores;
	}
}
