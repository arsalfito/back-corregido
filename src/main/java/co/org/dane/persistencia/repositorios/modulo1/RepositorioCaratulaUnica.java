/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.CaratulaUnica;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioCaratulaUnica extends JpaRepository<CaratulaUnica, Long>{

	@Query("SELECT c FROM CaratulaUnica c WHERE c.directorio.usuario.nombre = :usuario AND c.periodoRecoleccion.fechaDesde <= :fechaInicio AND c.periodoRecoleccion.fechaHasta >= :fechaFin")
	CaratulaUnica findCaratulaUnicaByUsuarioFechaDesdeFechaHasta(@Param("usuario") String usuario, @Param("fechaInicio")  Date fechaInicio,@Param("fechaFin") Date fechaFin);
	
}
