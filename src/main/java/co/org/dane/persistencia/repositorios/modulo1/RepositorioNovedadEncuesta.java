/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.modulo1.NovedadEncuesta;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioNovedadEncuesta extends JpaRepository<NovedadEncuesta, Long>{
	
	@Query("SELECT n FROM NovedadEncuesta n WHERE n.caratulaUnica.id = :idCaratula")
	List<NovedadEncuesta> findNovedadEncuestaByIdCaratula(long idCaratula);

}
