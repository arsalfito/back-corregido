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
@Table(name = "EAC_PERIODOS_RECOLECCION")
@Setter
@Getter
public class PeriodoRecoleccion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqPeriodoRecoleccion" )
	@SequenceGenerator( name = "SeqPeriodoRecoleccion", sequenceName = "SEQ_PERIODOS_RECOLECCION", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_PERIODO_RECOLECCION_PK", nullable = false )
	private int id;
	
	@Column( name = "FECHA_DESDE", nullable = false )
	private Date fechaDesde;
	
	@Column( name = "FECHA_HASTA", nullable = false )
	private Date fechaHasta;
	
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
