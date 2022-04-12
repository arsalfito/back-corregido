/**
 * 
 */
package co.org.dane.persistencia.entidades.modulo4;

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
@Table(name = "EAC_COMPRAS_INVENTARIO")
@Setter
@Getter
public class ComprasInventario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqComprasInventario" )
	@SequenceGenerator( name = "SeqComprasInventario", sequenceName = "SEQ_COMPRAS_INVENTARIO", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_COMPRA_INVENTARIO_PK", nullable = false )
	private long id;
	
	@Column( name = "VALOR_COMPRA", nullable = false, updatable = true, length = 13 )
	private double valorCompra;
	
	@Column( name = "VALOR_INICIAL", nullable = false, updatable = true, length = 13 )
	private double valorInicial;
	
	@Column( name = "VALOR_FINAL", nullable = false, updatable = true, length = 13 )
	private double valorFinal;
	
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;

}
