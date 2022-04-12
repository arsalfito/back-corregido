/**
 * 
 */
package co.org.dane.persistencia.entidades.modulo1;

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
import javax.persistence.OneToOne;
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
@Table(name = "EAC_INFO_FUNCIONAMIENTO")
@Setter
@Getter
public class InformacionFuncionamiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqInformacionFuncionamiento" )
	@SequenceGenerator( name = "SeqInformacionFuncionamiento", sequenceName = "SEQ_INFORMACION_FUNCIONAMIENTO", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_INFO_FUNC_PK", nullable = false )
	private long id;
	
	@Column( name = "ANIO_INI_OPERA", nullable = false, updatable = true, length = 4 )
	private int anioInicioOperaciones;
	
	@Column( name = "MES_OPERACIONES", nullable = false, updatable = true, length = 2 )
	private int mesesOperacion;
	
	@Column( name = "CUAL_OTRA_CAUSA", nullable = true, updatable = true, length = 80 )
	private String cualOtraCausa;
	
	@Column( name = "NUMERO_DEPARTAMENTOS", nullable = true, updatable = true, length = 2 )
	private int numeroDepartamentos;
	
	@Column( name = "FECHA_DILIGENCIAMIENTO", nullable = false, updatable = true )
	private Date fechaDiligenciamiento;
	
	@Column( name = "REPRESENTANTE_LEGAL", nullable = false, updatable = true, length = 80 )
	private String representanteLegal;
	
	@Column( name = "EMAIL_REPRESENTANTE", nullable = false, updatable = true, length = 50 )
	private String emailRepresentante;
	
	@Column( name = "CELULAR_REPRESENTANTE", nullable = true, updatable = true, length = 12 )
	private long celularRepresentante;
	
	@Column( name = "PERSONA_DILIGENCIA", nullable = false, updatable = true, length = 80 )
	private String personaDiligencia;
	
	@Column( name = "CARGO_DILIGENCIA", nullable = true, updatable = true, length = 50 )
	private String cargoDiligencia;
	
	@Column( name = "EMAIL_DILIGENCIA", nullable = false, updatable = true, length = 50 )
	private String emailDiligencia;
	
	@Column( name = "TELEFONO_DILIGENCIA", nullable = false, updatable = true, length = 10 )
	private long telefonoDiligencia;
	
	@Column( name = "EXTENSION_DILIGENCIA", nullable = true, updatable = true, length = 8 )
	private long extensionDiligencia;
	
	@Column( name = "CELULAR_DILIGENCIA", nullable = true, updatable = true, length = 12 )
	private long celularDiligencia;
	
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
	@JoinColumn(name="ID_TIPO_CAUSA_FK", nullable = true, updatable = true)
	private TipoCausa tipoCausa;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_CARATULA_UNICA_FK", nullable = true, updatable = true)
	private CaratulaUnica caratulaUnica;

	
	
}
