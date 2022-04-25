/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.TipoOrganizacion;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioTipoOrganizacion extends JpaRepository<TipoOrganizacion, Integer>{
	
	@Query("SELECT t FROM TipoOrganizacion t ORDER BY t.orden ASC")
	List<TipoOrganizacion> findAllTipoOrganizacion();
}
