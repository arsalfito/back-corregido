package co.org.dane.persistencia.repositorios.genericos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.tipos.TiposGenericos;


@Repository
public interface TiposGenericosGenericsRepositorio<T extends TiposGenericos> 
extends JpaRepository<T, Integer>{
	
	 @Query("from #{#entityName}")
	 List<T> TraerTipos();

}
