/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.modulo1.TipoDocumento;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioTipoDocumento extends JpaRepository<TipoDocumento, Integer>{
	
	@Query("SELECT t FROM TipoDocumento t ORDER BY t.orden ASC")
	List<TipoDocumento> findAllTipoDocumento();

}
