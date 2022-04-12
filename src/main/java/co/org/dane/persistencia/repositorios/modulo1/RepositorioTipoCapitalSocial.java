/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.modulo1.TipoCapitalSocial;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioTipoCapitalSocial extends JpaRepository<TipoCapitalSocial, Integer>{
	
	@Query("SELECT t FROM TipoCapitalSocial t ORDER BY t.orden ASC")
	List<TipoCapitalSocial> findAllTipoCapitalSocial();
}
