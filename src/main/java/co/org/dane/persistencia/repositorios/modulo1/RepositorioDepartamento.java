/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.modulo1.Departamento;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioDepartamento  extends JpaRepository<Departamento, Integer>{

	@Query("SELECT d FROM Departamento d ORDER BY d.nombre ASC")
	List<Departamento> findAllDepartamento();
	
	
}
