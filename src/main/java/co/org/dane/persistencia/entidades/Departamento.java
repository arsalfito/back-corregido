/**
 * 
 */
package co.org.dane.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_DEPARTAMENTOS")
@Setter
@Getter
public class Departamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqDepartamento" )
	@SequenceGenerator( name = "SeqDepartamento", sequenceName = "SEQ_DEPARTAMENTOS", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_DEPARTAMENTO_PK", nullable = false )
	private int id;
	
	@Column( name = "CODIGO", nullable = false, updatable = true, length = 3 )
	private String codigo;
	
	@Column( name = "DIVIPOLA", nullable = false, updatable = true, length = 3 )
	private String divipola;
	
	@Column( name = "NOMBRE", nullable = false, updatable = true, length = 100 )
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	private Collection<Municipio> municipios;

}
