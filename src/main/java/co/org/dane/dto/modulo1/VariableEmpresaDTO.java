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
public class VariableEmpresaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private int numeroEstablecimientos;
	private long ingreso;
	private int personalOcupado;
	private long remuneracion;
	private long otrosCostosGastos;
	private int idSeccion;
	private int idCodigoCIIU;
	private long idCaratulaUnica;

}
