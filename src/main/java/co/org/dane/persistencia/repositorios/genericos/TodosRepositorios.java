package co.org.dane.persistencia.repositorios.genericos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.tipos.TiposGenericos;

@Repository
public interface TodosRepositorios<T extends TiposGenericos> extends JpaRepository<T,Integer>{
	                                               
	//@Query("select p from #{#entityName} p where p.myDType = :myDType")
	@Query("select p from TiposGenericos p where p.myDType = :myDType")
	List<T> traerTipos(String myDType);

}
