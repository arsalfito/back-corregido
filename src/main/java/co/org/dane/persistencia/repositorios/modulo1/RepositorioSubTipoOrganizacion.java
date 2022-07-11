/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.tipos.SubTipoOrganizacion;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioSubTipoOrganizacion extends JpaRepository<SubTipoOrganizacion, Integer>{

	@Query("SELECT s FROM SubTipoOrganizacion s WHERE s.tipoOrganizacion.id = :idTipoOrganizacion ORDER BY s.orden ASC")
	List<SubTipoOrganizacion> findSubTipoOrganizacionByIdTipoOrganizacion(int idTipoOrganizacion);
}
