/**
 * 
 */
package co.org.dane.dto.modulo1;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Setter
@Getter
public class NovedadEncuestaDTO {

	private long id;
	private int codigo;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private String activo;
	private long idCaratulaUnica;
}
