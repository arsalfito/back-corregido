/**
 * 
 */
package co.org.dane.persistencia.entidades.modulo4;

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
@Table(name = "EAC_TIPO_OTROS_GASTOS")
@Setter
@Getter
public class TipoOtrosGastos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqTipoOtrosGastos" )
	@SequenceGenerator( name = "SeqTipoOtrosGastos", sequenceName = "SEQ_TIPO_OTROS_GASTOS", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_TIPO_OTRO_GASTO_PK", nullable = false )
	private int id;
	
	@Column( name = "CODIGO", nullable = false, updatable = true, length = 2 )
	private int codigo;
	
	@Column( name = "ORDEN", nullable = false, updatable = true, length = 3 )
	private int orden;
	
	@Column( name = "NOMBRE", nullable = false, updatable = true, length = 200 )
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
