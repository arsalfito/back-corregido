/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.modulo1.TipoDireccion;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioTipoDireccion extends JpaRepository<TipoDireccion, Integer>{

	@Query("SELECT t FROM TipoDireccion t ORDER BY t.orden ASC")
	List<TipoDireccion> findAllTipoDireccion();
}
