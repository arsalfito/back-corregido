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

import lombok.Getter;
import lombok.Setter;

/**
 * 
 */

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_NOVEDADES_ENCUESTA")
@Setter
@Getter
public class NovedadEncuesta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqNovedadEncuesta" )
	@SequenceGenerator( name = "SeqNovedadEncuesta", sequenceName = "SEQ_NOVEDADES_ENCUESTA", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_NOVEDAD_ENCUESTA_PK", nullable = false )
	private long id;
	
	@Column( name = "CODIGO", nullable = false, updatable = true, length = 2 )
	private int codigo;
	
	@Column( name = "NOMBRE", nullable = false, updatable = true, length = 100 )
	private String nombre;
	
	@Column( name = "FECHA_INICIO", nullable = false, updatable = true)
	private Date fechaInicio;
	
	@Column( name = "FECHA_FIN", nullable = false, updatable = true)
	private Date fechaFin;
	
	@Column( name = "ACTIVO", nullable = false, updatable = true, length = 1)
	private String activo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;
	
}
