/**
 * 
 */
package co.org.dane.persistencia.entidades.tipos;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Setter
@Getter
public class TipoOrganizacion extends TiposGenericos{

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoOrganizacion")
	private Collection<SubTipoOrganizacion> subTipoOrganizacion;
	
}
