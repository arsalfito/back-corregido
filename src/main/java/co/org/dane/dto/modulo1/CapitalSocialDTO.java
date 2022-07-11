/**
 * 
 */
package co.org.dane.dto.modulo1;

import java.io.Serializable;

import co.org.dane.persistencia.entidades.enumeraciones.ETipoCapitalSocial;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Setter
@Getter
public class CapitalSocialDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private int publico;
	private int privado;
	private int total;
	private ETipoCapitalSocial tipoCapitalSocial;
}
