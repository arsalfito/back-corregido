package co.org.dane.dto.modulo1;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CodigoCIIUDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String codigo;
	private int orden;
	private String nombre;

}
