/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.tipos.TipoIngresosNoOperacionales;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioTipoIngresosNoOperacionales extends JpaRepository<TipoIngresosNoOperacionales, Integer> {

	@Query("SELECT t FROM TipoIngresosNoOperacionales t ORDER BY t.orden ASC")
	List<TipoIngresosNoOperacionales> findAllTipoIngresosNoOperacionales();
}
