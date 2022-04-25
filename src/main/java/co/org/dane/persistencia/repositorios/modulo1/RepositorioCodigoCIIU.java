/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.CodigoCIIU;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioCodigoCIIU extends JpaRepository<CodigoCIIU, Integer>{
	
	@Query("SELECT c FROM CodigoCIIU c WHERE c.tipoVariable.id = :idTipoVariable ORDER BY c.orden ASC")
	List<CodigoCIIU> findCodigoCIIUByIdTipoVariable(int idTipoVariable);

}
