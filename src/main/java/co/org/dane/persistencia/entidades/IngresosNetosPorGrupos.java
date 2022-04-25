/**
 * 
 */
package co.org.dane.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_INGRESOS_NETOS_POR_GRUPO")
@Setter
@Getter
public class IngresosNetosPorGrupos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqIngresosNetosPorGrupos" )
	@SequenceGenerator( name = "SeqIngresosNetosPorGrupos", sequenceName = "SEQ_INGRESOS_NETOS_POR_GRUPO", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_INGRESOS_NETOS_POR_GRUPO_PK", nullable = false )
	private long id;
	
	@Column( name = "VALOR_VENTAS", nullable = true, length = 12 )
	private double valorVentas;
	
	@Column( name = "PORCENTAJE_VENTAS_MAYORITARIAS", nullable = true, length = 3 )
	private int porcentajeVentasMayoritarias;
	
	@Column( name = "PORCENTAJE_VENTAS_MINORITARIAS", nullable = true, length = 3 )
	private int porcentajeVentasMinoritarias;
	
	@Column( name = "PORCENTAJE_VENTAS_ELECTRONICAS", nullable = true, length = 6 )
	private double porcentajeVentasElectronicas;
	
	@Column( name = "VALOR_VENTAS_ELECTRONICAS", nullable = true, length = 12 )
	private double valorVentasElectronicas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GRUPO_MERCANCIA_FK", nullable = false, updatable = true)
	private GruposMercancia grupoMercancia;
	
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ingresosNetosPorGrupos")
	private Collection<GruposMercanciasMayoresVentas> gruposMercanciasMayoresVentas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ingresosNetosPorGrupos")
	private Collection<ConceptosOtrosGastos> conceptosOtrosGastos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;
}
