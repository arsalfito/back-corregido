/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.modulo1.VariableEmpresa;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioVariableEmpresa extends JpaRepository<VariableEmpresa, Long>{

	@Query("SELECT v FROM VariableEmpresa v WHERE v.caratulaUnica.id = :idCaratula")
	List<VariableEmpresa> findVariableEmpresaByIdCaratula(long idCaratula);

}
