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
public class IngresosNoOperacionalesDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private long valor;
	private int idTipoIngresosNoOperacionales;
	private long idCaratulaUnica;

}
