/**
 * 
 */
package co.org.dane.dto.modulo1;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Setter
@Getter
public class EstadoEncuestaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private int codigo;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private String activo;
	private long idCaratulaUnica;

}
