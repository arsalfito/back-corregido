/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.Operacion;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioOperacion extends JpaRepository<Operacion, Long>{

	@Query("SELECT o FROM Operacion o WHERE o.caratulaUnica.id = :idCaratula")
	List<Operacion> findOperacionByIdCaratula(long idCaratula);
	
}
