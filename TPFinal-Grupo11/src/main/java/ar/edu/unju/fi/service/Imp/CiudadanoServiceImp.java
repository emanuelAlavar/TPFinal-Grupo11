package ar.edu.unju.fi.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.repository.ICiudadanoRepository;
import ar.edu.unju.fi.service.ICiudadanoService;

@Service
public class CiudadanoServiceImp implements ICiudadanoService {
	@Autowired
	private ICiudadanoRepository ciudadanoImp;

	@Override
	public Ciudadano getCiudadano() {
		// TODO Auto-generated method stub
		return new Ciudadano();
	}

	@Override
	public boolean guardarCiudadano(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		ciudadano.setEstado(true);
		if(ciudadanoImp.save(ciudadano)!=null) {
			return true;
		}
		return false;
	}
}
