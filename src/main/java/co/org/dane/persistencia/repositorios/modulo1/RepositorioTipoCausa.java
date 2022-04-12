/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.modulo1.TipoCausa;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioTipoCausa extends JpaRepository<TipoCausa, Integer>{
	
	@Query("SELECT t FROM TipoCausa t ORDER BY t.orden ASC")
	List<TipoCausa> findAllTipoCausa();

}
