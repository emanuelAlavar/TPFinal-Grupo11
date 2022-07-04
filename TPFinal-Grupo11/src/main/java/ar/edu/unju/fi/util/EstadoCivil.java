package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class EstadoCivil {
	private ArrayList<String> estadoCivil = new ArrayList<String>();
	
	public EstadoCivil() {
		estadoCivil.add("Soltero");
		estadoCivil.add("Casado");
		estadoCivil.add("Divorciado");
		estadoCivil.add("Viudo");
	}

	public ArrayList<String> getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(ArrayList<String> estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
}