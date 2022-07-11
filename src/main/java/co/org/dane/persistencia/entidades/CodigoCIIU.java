/**
 * 
 */
package co.org.dane.persistencia.entidades;

import java.io.Serializable;

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

import co.org.dane.persistencia.entidades.tipos.GruposMercancia;
import co.org.dane.persistencia.entidades.tipos.TipoVariable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_CODIGOS_CIIU")
@Setter
@Getter
public class CodigoCIIU implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqCodigoCIIU" )
	@SequenceGenerator( name = "SeqCodigoCIIU", sequenceName = "SEQ_CODIGOS_CIIU", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_CODIGO_CIIU_PK", nullable = false )
	private int id;
	
	@Column( name = "CODIGO", nullable = false, updatable = true, length = 4 )
	private String codigo;
	
	@Column( name = "ORDEN", nullable = false, updatable = true, length = 2 )
	private int orden;
	
	@Column( name = "NOMBRE", nullable = false, updatable = true, length = 100 )
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_VARIABLE_FK", nullable = true, updatable = true)
	private TipoVariable tipoVariable;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GRUPO_MERCANCIA_FK", nullable = true, updatable = true)
	private GruposMercancia grupoMercancia;
}
