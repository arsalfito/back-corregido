/**
 * 
 */
package co.org.dane.persistencia.entidades.modulo2;

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

import co.org.dane.persistencia.entidades.modulo1.CodigoCIIU;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_GRUPOS_MERCANCIA")
@Setter
@Getter
public class GruposMercancia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqGruposMercancia" )
	@SequenceGenerator( name = "SeqGruposMercancia", sequenceName = "SEQ_GRUPOS_MERCANCIA", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_GRUPOS_MERCANCIA_PK", nullable = false )
	private int id;
	
	@Column( name = "ORDEN", nullable = false, updatable = true, length = 3 )
	private int orden;
	
	@Column( name = "CODIGO", nullable = false, updatable = true, length = 2 )
	private String codigo;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CODIGO_CIIU_FK", nullable = false, updatable = true)
	private CodigoCIIU codigoCIIU;

}
