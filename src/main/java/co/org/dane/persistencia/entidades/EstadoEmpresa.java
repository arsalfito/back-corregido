/**
 * 
 */
package co.org.dane.persistencia.entidades;

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
@Table(name = "EAC_ESTADO_EMPRESA")
@Setter
@Getter
public class EstadoEmpresa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqEstadoEmpresa" )
	@SequenceGenerator( name = "SeqEstadoEmpresa", sequenceName = "SEQ_ESTADO_EMPRESA", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_ESTADO_EMPRESA_PK", nullable = false )
	private int id;
	
	@Column( name = "ESTADO_EMPRESA", nullable = false, updatable = true, length = 40 )
	private String estadoEmpresa;
	
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
