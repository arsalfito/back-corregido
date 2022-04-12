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
public class DireccionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private double localizacionGeoreferenciada;
	private String direccion;
	private String telefono;
	private String redesSociales;
	private String correoElectronico;
	private String paginaWeb;
	private int idDepartamento;
	private int idMunicipio;
	private int idTipoDireccion;
	private long idCaratulaUnica;	

}
