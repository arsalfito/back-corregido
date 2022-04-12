/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.modulo1.EstadoEncuesta;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioEstadoEncuesta extends JpaRepository<EstadoEncuesta, Long>{

	@Query("SELECT e FROM EstadoEncuesta e WHERE e.caratulaUnica.id = :idCaratula")
	List<EstadoEncuesta> findEstadoEncuestaByIdCaratula(long idCaratula);
}
