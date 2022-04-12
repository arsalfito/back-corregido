/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.modulo1.IngresosNoOperacionales;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioIngresosNoOperacionales extends JpaRepository<IngresosNoOperacionales, Long> {
	
	@Query("SELECT i FROM IngresosNoOperacionales i WHERE i.caratulaUnica.id = :idCaratula")
	List<IngresosNoOperacionales> findIngresosNoOperacionalesByIdCaratula(long idCaratula);

}
