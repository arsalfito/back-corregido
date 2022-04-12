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
public class InformacionFuncionamientoDTO {
	
	private long id;
	private int anioInicioOperaciones;
	private int mesesOperacion;
	private String cualOtraCausa;
	private int numeroDepartamentos;
	private Date fechaDiligenciamiento;
	private String representanteLegal;
	private String emailRepresentante;
	private long celularRepresentante;
	private String personaDiligencia;
	private String cargoDiligencia;
	private String emailDiligencia;
	private long telefonoDiligencia;
	private long extensionDiligencia;
	private long celularDiligencia;
	private int idTipoCausa;
	private long idCaratulaUnica;

}
