package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.entity.Oferta;


public class ListaOferta {
private ArrayList<Oferta> ofertas;
	
	public ListaOferta() {
		// crear el arrayList		ofertas = new ArrayList<oferta>();		
	}
	
	/*métodos accesores*/
	public ArrayList<Oferta> getOferta() {
		return ofertas;
	}

	public void setCursos(ArrayList<Oferta> cursos) {
		this.ofertas = ofertas;
	}

}
