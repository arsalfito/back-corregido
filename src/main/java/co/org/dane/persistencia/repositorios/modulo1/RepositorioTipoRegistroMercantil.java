/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.modulo1.TipoRegistroMercantil;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioTipoRegistroMercantil extends JpaRepository<TipoRegistroMercantil, Integer>{

	@Query("SELECT t FROM TipoRegistroMercantil t ORDER BY t.orden ASC")
	List<TipoRegistroMercantil> findAllTipoRegistroMercantil();
}
