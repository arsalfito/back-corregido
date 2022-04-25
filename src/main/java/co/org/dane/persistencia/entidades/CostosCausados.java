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
@Table(name = "EAC_COSTOS_CAUSADOS")
@Setter
@Getter
public class CostosCausados implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqCostosCausados" )
	@SequenceGenerator( name = "SeqCostosCausados", sequenceName = "SEQ_COSTOS_CAUSADOS", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_COSTO_CAUSADO_PK", nullable = false )
	private long id;
	
	@Column( name = "VALOR", nullable = false, updatable = true, length = 13 )
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
	@JoinColumn(name = "ID_TIPO_COSTO_FK", nullable = false, updatable = true)
	private TipoCostos tipoCostos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "otrosGastosCausados")
	private Collection<ConceptosOtrosGastos> conceptosOtrosGastos;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;
	
	
}
