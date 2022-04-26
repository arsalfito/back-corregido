/**
 * 
 */
package co.org.dane.persistencia.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import co.org.dane.persistencia.entidades.tipos.TipoOrganizacion;
import co.org.dane.persistencia.entidades.tipos.TiposGenericos;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Setter
@Getter
public class SubTipoOrganizacion extends TiposGenericos{
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_ORGANIZACION_FK", nullable = true, updatable = true)
	private TipoOrganizacion tipoOrganizacion;

}

