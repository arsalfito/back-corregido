/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.modulo1.InformacionFuncionamiento;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioInformacionFuncionamiento extends JpaRepository<InformacionFuncionamiento, Long>{
	
	@Query("SELECT i FROM InformacionFuncionamiento i WHERE i.caratulaUnica.id = :idCaratula")
	InformacionFuncionamiento findInformacionFuncionamientoByIdCaratula(long idCaratula);

}
