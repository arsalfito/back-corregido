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
@Table(name = "EAC_GASTOS_CAUSADOS_PERSONAL")
@Setter
@Getter
public class GastosCausadosPersonal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqGastosCausadosPersonal" )
	@SequenceGenerator( name = "SeqGastosCausadosPersonal", sequenceName = "SEQ_GASTOS_CAUSADOS_PERSONAL", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_GASTO_CAUSADO_PERSONAL_PK", nullable = false )
	private long id;
	
	@Column( name = "VALOR", nullable = true, updatable = true, length = 13 )
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
	@JoinColumn(name="ID_TIPO_GASTO_FK", nullable = false, updatable = true)
	private TipoGastos tipoGastos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gastosCausadosPersonal")
	private Collection<ConceptosOtrosGastos> conceptoOtrosGastos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;

}
