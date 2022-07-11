/**
 * 
 */
package co.org.dane.dto.modulo1;

import java.io.Serializable;

import co.org.dane.persistencia.entidades.enumeraciones.ETipoOperacion;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Setter
@Getter
public class OperacionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private int bienes;
	private int servicios;
	private int ninguna;
	private ETipoOperacion tipoOperacion;
	private long idCaratulaUnica;
}
