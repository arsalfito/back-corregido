/**
 * 
 */
package co.org.dane.persistencia.repositorios.modulo1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.modulo1.EstadoEmpresa;

/**
 * @author ALFONSO
 *
 */
@Repository
public interface RepositorioEstadoEmpresa extends JpaRepository<EstadoEmpresa, Integer>{

}
