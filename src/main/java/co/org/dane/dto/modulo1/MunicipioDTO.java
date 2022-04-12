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
public class MunicipioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int codigo;
	private String nombre;

}
