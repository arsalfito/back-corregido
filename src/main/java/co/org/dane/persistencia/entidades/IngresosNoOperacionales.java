/**
 * 
 */
package co.org.dane.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.org.dane.persistencia.entidades.tipos.TipoIngresosNoOperacionales;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_INGRESOS_NO_OPERA")
@Setter
@Getter
public class IngresosNoOperacionales implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqIngresosNoOperacionales" )
	@SequenceGenerator( name = "SeqIngresosNoOperacionales", sequenceName = "SEQ_INGRESOS_NO_OPERACIONALES", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_ING_NO_OPERA_PK", nullable = false )
	private long id;
	
	@Column( name = "VALOR", nullable = false, updatable = true, length = 12 )
	private long valor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_TIPO_ING_NO_OPE_FK")
	private TipoIngresosNoOperacionales tipoIngresosNoOperacionales;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CARATULA_UNICA_FK")
	private CaratulaUnica caratulaUnica;

}
