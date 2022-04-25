/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.TipoVariable;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioTipoVariable extends JpaRepository<TipoVariable, Integer>{

	@Query("SELECT t FROM TipoVariable t ORDER BY t.orden ASC")
	List<TipoVariable> findAllTipoVariable();
	
}
