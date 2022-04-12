/**
 * 
 */
package co.org.dane.persistencia.entidades.modulo1;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_DIRECCIONES")
@Setter
@Getter
public class Direccion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqDireccion" )
	@SequenceGenerator( name = "SeqDireccion", sequenceName = "SEQ_DIRECCIONES", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_DIRECCION_PK", nullable = false )
	private long id;
	
	//IDIGG Localización georeferenciada de la gerencia (código asignado por georefenciación - LGGR) 
	@Column( name = "LOCALIZACION_GEOREFERENCIADA", nullable = true, updatable = true )
	private double localizacionGeoreferenciada;
	
	//IDDIRECC Domicilio principal o dirección de la gerencia
	@Column( name = "DIRECCION", nullable = false, updatable = true, length = 80 )
	private String direccion;
	
	//IDTEL Teléfono 
	@Column( name = "TELEFONO", nullable = false, updatable = true, length = 10 )
	private String telefono;
	
	//IDRED Redes sociales
	@Column( name = "REDES_SOCIALES", nullable = true, updatable = true, length = 80 )
	private String redesSociales;
		
	//IDMAIL Correo electrónico
	@Column( name = "CORREO_ELECTRONICO", nullable = true, updatable = true, length = 40 )
	private String correoElectronico;
	
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
		
	//IDWEB Página Web 
	@Column( name = "PAGINA_WEB", nullable = true, updatable = true, length = 40 )
	private String paginaWeb;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DEPARTAMENTO_FK", nullable = false, updatable = true)
	private Departamento departamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MUNICIPIO_FK", nullable = false, updatable = true)
	private Municipio municipio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_DIRECCION_FK", nullable = false, updatable = true)
	private TipoDireccion tipoDireccion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;	

}
