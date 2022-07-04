package ar.edu.unju.fi.service;



import org.springframework.stereotype.Service;


import ar.edu.unju.fi.entity.Oferta;
@Service
public interface IOfertaService {
	public Oferta getOferta();
	public boolean guardarOferta(Oferta oferta);
	
	public Oferta buscarOferta(int codigo);
	public void modificarOferta(Oferta oferta);
	public void eliminarOferta(int codigo);
}
