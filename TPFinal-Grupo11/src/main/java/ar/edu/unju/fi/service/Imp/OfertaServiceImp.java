package ar.edu.unju.fi.service.Imp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.repository.IOfertaRepository;
import ar.edu.unju.fi.service.IOfertaService;
@Service("OfertaServiceImp")
public class OfertaServiceImp implements IOfertaService {
	@Autowired
	private IOfertaRepository ofertaImp;
	
	@Override
	public Oferta getOferta() {
		// TODO Auto-generated method stub
		return new Oferta();
	}

	@Override
	public boolean guardarOferta(Oferta oferta) {
		oferta.setStat(true);
		if(ofertaImp.save(oferta)!=null) {
			return true;
		}
		return false;
	}
	
	//@Override
	//public List<Oferta> obtenerOferta() {
		// TODO Auto-generated method stub
		//return ofertaImp.findByStat(true);
	//}
	@Override
	public Oferta buscarOferta(int codigo) {
		// TODO Auto-generated method stub
		return ofertaImp.findByCodigo(codigo);
	}
	
	@Override
	public void modificarOferta(Oferta oferta) {
		Oferta ofer = ofertaImp.findByCodigo(oferta.getCodigo());
		ofer.setVacantes(oferta.getVacantes());
		ofer.setPuesto(oferta.getPuesto());
		ofer.setDisponibilidad(oferta.getDisponibilidad());
		ofer.setTareas(oferta.getTareas());
		ofer.setContacto(oferta.getContacto());
		ofer.setJornada(oferta.getJornada());	
		ofer.setRequisitos(oferta.getRequisitos());
		ofer.setSalario(oferta.getSalario());
		ofer.setBeneficios(oferta.getBeneficios());
		ofer.setDisponible(oferta.isDisponible());
		ofertaImp.save(ofer);
	}

	@Override
	public void eliminarOferta(int codigo) {
		// TODO Auto-generated method stub
		Oferta oferta = buscarOferta(codigo);
		oferta.setStat(false);
		ofertaImp.save(oferta);
	}
}

