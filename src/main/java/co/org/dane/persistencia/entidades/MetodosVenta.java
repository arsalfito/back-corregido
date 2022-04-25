/**
 * 
 */
package co.org.dane.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "EAC_METODOS_VENTA")
@Setter
@Getter
public class MetodosVenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqMetodosVenta" )
	@SequenceGenerator( name = "SeqMetodosVenta", sequenceName = "SEQ_METODOS_VENTA", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_METODOS_VENTA_PK", nullable = false )
	private long id;
	
	@Column( name = "PORCENTAJE", nullable = false, updatable = true, length = 3 )
	private int porcentaje;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_METODOS_VENTA_FK", nullable = false, updatable = true)
	private TiposMetodosVenta tiposMetodosVenta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;
	
}
