/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.EstadoModulos;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioEstadoModulos extends JpaRepository<EstadoModulos, Integer>{

	@Query("SELECT e FROM EstadoModulos e WHERE e.caratulaUnica.id = :idCaratula")
	List<EstadoModulos> findEstadoModulosByIdCaratula(long idCaratula);
}
