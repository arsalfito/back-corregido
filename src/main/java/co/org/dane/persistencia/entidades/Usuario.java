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
@Table(name = "EAC_USUARIOS")
@Setter
@Getter
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqUsuario" )
	@SequenceGenerator( name = "SeqUsuario", sequenceName = "SEQ_USUARIOS", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_USUARIO_PK", nullable = false )
	private int id;
	
	@Column( name = "NOMBRE", nullable = false, updatable = true, length = 30 )
	private String nombre;
	
	@Column( name = "CONTRASENA", nullable = false, updatable = true, length = 20 )
	private String contrasena;
	
}
