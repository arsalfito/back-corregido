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

import co.org.dane.persistencia.entidades.tipos.TiposCombustibles;
import co.org.dane.persistencia.entidades.tipos.TiposVehiculos;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_VEHICULOS_COMERCIALIZADOS")
@Setter
@Getter
public class VehiculosComercializados implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqVehiculosComercializados" )
	@SequenceGenerator( name = "SeqVehiculosComercializados", sequenceName = "SEQ_VEHICULOS_COMERCIALIZADOS", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_VEHICULOS_COM_PK", nullable = false )
	private long id;
	
	@Column( name = "CANTIDAD", nullable = false, updatable = true, length = 7 )
	private int cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_VEHICULOS_FK", nullable = false, updatable = true)
	private TiposVehiculos tiposVehiculos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_COMBUSTIBLES_FK", nullable = false, updatable = true)
	private TiposCombustibles tiposCombustibles;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;

}
