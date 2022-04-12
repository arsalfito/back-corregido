/**
 * 
 */
package co.org.dane.persistencia.entidades.modulo3;

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

import co.org.dane.persistencia.entidades.modulo1.CaratulaUnica;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_PERSONAL_OCUPADO")
@Setter
@Getter
public class PersonalOcupado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqPersonalOcupado" )
	@SequenceGenerator( name = "SeqPersonalOcupado", sequenceName = "SEQ_PERSONAL_OCUPADO", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_PERSONAL_OCUPADO_PK", nullable = false )
	private long id;

	@Column( name = "MUJERES", nullable = true, updatable = true, length = 7 )
	private int mujeres;
	
	@Column( name = "HOMBRES", nullable = true, updatable = true, length = 7 )
	private int hombres;
	
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
	@JoinColumn(name="ID_TIPO_CONTRATACION_FK", nullable = false, updatable = true)
	private TipoContratacion tipoContratacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;
}
