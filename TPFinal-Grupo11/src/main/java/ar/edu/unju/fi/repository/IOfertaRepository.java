package ar.edu.unju.fi.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import ar.edu.unju.fi.entity.Oferta;

public interface IOfertaRepository extends JpaRepository<Oferta, Long> {

public Oferta findByCodigo(int codigo);
	
	public List<Oferta> findByStat(boolean Stat);
	
	
	@Modifying
	@Query
	public void deleteByCodigo(int codigo);
	
}
