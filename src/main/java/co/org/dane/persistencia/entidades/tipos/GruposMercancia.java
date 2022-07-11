/**
 * 
 */
package co.org.dane.persistencia.entidades.tipos;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import co.org.dane.persistencia.entidades.CodigoCIIU;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Setter
@Getter
public class GruposMercancia extends TiposGenericos{
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoMercancia")
	private Collection<CodigoCIIU> codigosCIIU;

}