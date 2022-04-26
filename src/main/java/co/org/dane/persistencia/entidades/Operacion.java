/**
 * 
 */
package co.org.dane.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.org.dane.persistencia.entidades.enumeraciones.ETipoOperacion;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_OPERACIONES")
@Setter
@Getter
public class Operacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqOperacion" )
	@SequenceGenerator( name = "SeqOperacion", sequenceName = "SEQ_OPERACIONES", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_OPERACION_PK", nullable = false )
	private long id;
	
	@Column( name = "BIENES", nullable = false, updatable = true, length = 1 )
	private int bienes;
	
	@Column( name = "SERVICIOS", nullable = false, updatable = true, length = 2 )
	private int servicios;
	
	@Column( name = "NINGUNA", nullable = false, updatable = true, length = 3 )
	private int ninguna;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ETipoOperacion tipoOperacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;
}
