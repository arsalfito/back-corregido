/**
 * 
 */
package co.org.dane.persistencia.entidades.modulo1;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_TIPO_VARIABLE")
@Setter
@Getter
public class TipoVariable implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqTipoVariable" )
	@SequenceGenerator( name = "SeqTipoVariable", sequenceName = "SEQ_TIPO_VARIABLE", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_TIPO_VARIABLE_PK", nullable = false )
	private int id;
	
	@Column( name = "ORDEN", nullable = false, updatable = true, length = 2 )
	private int orden;
	
	@Column( name = "CODIGO", nullable = false, updatable = true, length = 2 )
	private int codigo;
	
	@Column( name = "NOMBRE", nullable = false, updatable = true, length = 100 )
	private String nombre;
	
	@Column( name = "USUARIO_CREACION", nullable = true, updatable = true, length = 30 )
	private String usuarioCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column( name = "FECHA_CREACION", nullable = true, updatable = true )
	private Date fechaCreacion;
	
	@Column( name = "USUARIO_MODIFICACION", nullable = true, updatable = true, length = 30 )
	private String usuarioModificacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column( name = "FECHA_MODIFICACION", nullable = true, updatable = true)
	private Date fechaModificacion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoVariable")
	private Collection<CodigoCIIU> codigosCIIU;
}
