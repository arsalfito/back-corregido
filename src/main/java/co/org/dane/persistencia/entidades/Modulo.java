/**
 * 
 */
package co.org.dane.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_MODULOS")
@Setter
@Getter
public class Modulo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqModulo" )
	@SequenceGenerator( name = "SeqModulo", sequenceName = "SEQ_MODULOS", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_MODULO_PK", nullable = false )
	private int id;
	
	@Column( name = "NOMBRE", nullable = false, updatable = true, length = 50 )
	private String nombre;
	
	@Column( name = "ORDEN", nullable = false, updatable = true, length = 2 )
	private int orden;
	
}
