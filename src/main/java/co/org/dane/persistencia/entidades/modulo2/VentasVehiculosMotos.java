/**
 * 
 */
package co.org.dane.persistencia.entidades.modulo2;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.org.dane.persistencia.entidades.modulo1.CaratulaUnica;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_VENTAS_VEHICULOS_MOTOS")
@Setter
@Getter
public class VentasVehiculosMotos implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqVentasVehiculosMotos" )
	@SequenceGenerator( name = "SeqVentasVehiculosMotos", sequenceName = "SEQ_VENTAS_VEHICULOS_MOTOS", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_VENTAS_VEHICULOS_MOTOS_PK", nullable = false )
	private long id;
	
	@Column( name = "VALOR", nullable = false, updatable = true, length =  12)
	private double valor;
	
	@Column( name = "USUARIO_CREACION", nullable = true, updatable = true, length = 30 )
	private String usuarioCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column( name = "FECHA_CREACION", nullable = true, updatable = true )
	private Date fechaCreacion;
	
	@Column( name = "USUARIO_MODIFICACION", nullable = true, updatable = true, length = 30 )
	private String usuarioModificacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column( name = "FECHA_MODIFICACION", nullable = true, updatable = true)
	private Date fechaModificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_VENTAS_VEHICULOS_FK", nullable = false, updatable = true)
	private TiposVentasVehiculos tiposVentasVehiculos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_VEHICULOS_MOTOS_FK", nullable = false, updatable = true)
	private TiposVehiculosMotos tiposVehiculosMotos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;
	
}
