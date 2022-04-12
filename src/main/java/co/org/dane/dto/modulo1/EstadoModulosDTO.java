/**
 * 
 */
package co.org.dane.dto.modulo1;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Setter
@Getter
public class EstadoModulosDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String estado;
	private int idModulo;
	private long idCaratulaUnica;

}
