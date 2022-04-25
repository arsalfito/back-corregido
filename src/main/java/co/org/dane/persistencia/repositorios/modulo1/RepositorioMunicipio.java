/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.Municipio;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioMunicipio extends JpaRepository<Municipio, Integer>{
	
	@Query("SELECT m FROM Municipio m WHERE m.departamento.id = :idDepartamento ORDER BY m.nombre ASC")
	List<Municipio> findMunicipioByIdDepartamento(int idDepartamento);

}
