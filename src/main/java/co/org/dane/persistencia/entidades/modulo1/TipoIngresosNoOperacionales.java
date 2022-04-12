/**
 * 
 */
package co.org.dane.persistencia.entidades.modulo1;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "EAC_TIPO_ING_NO_OPE")
@Setter
@Getter
public class TipoIngresosNoOperacionales implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqTipoIngresosNoOperacionales" )
	@SequenceGenerator( name = "SeqTipoIngresosNoOperacionales", sequenceName = "SEQ_INGRESOS_NO_OPERACIONALES", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_TIP_ING_NO_OPE_PK", nullable = false )
	private int id;
	
	@Column( name = "ORDEN", nullable = false, updatable = true, length = 2 )
	private int orden;
	
	@Column( name = "CODIGO", nullable = false, updatable = true, length = 1 )
	private int codigo;
	
	@Column( name = "NOMBRE", nullable = false, updatable = true, length = 150 )
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
}
