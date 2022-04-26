package co.org.dane.persistencia.repositorios.genericos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.tipos.TiposGenericos;

@Repository
public interface TiposGenericosRepositorio extends JpaRepository<TiposGenericos, Integer> {
	
	
	//@Query("SELECT m FROM TiposGenericos m WHERE m.nombre = :nombretipo")
	@Query("SELECT t FROM TiposGenericos t where TYPE(t)=:nombreTipo ORDER BY t.orden ASC")
	List<TiposGenericos> findTiposGenericos(@Param("nombreTipo") String nombreTipo);
	
	@Query("SELECT t FROM TiposGenericos t WHERE t.nombre = :nombreTipo")
	List<TiposGenericos> findTiposOrganizacionn(String nombreTipo);
	
	
	//@Query("SELECT t FROM TiposGenericos t WHERE t.TYPE = :nombreTipo")
	//List<TiposGenericos> findTiposOrganizacion(String nombreTipo);


}