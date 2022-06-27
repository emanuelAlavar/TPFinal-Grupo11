package ar.edu.unju.fi.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.repository.IEmpleadorRepository;
import ar.edu.unju.fi.service.IEmpleadorService;
@Service
public class EmpleadorServiceImp implements IEmpleadorService {
	@Autowired
	private IEmpleadorRepository empleadorImp;
	
	@Override
	public Empleador getEmpleador() {
		// TODO Auto-generated method stub
		return new Empleador();
	}

	@Override
	public boolean guardarEmpleador(Empleador empleador) {
		empleador.setEstado(true);
		if(empleadorImp.save(empleador)!=null) {
			return true;
		}
		return false;
	}

}
