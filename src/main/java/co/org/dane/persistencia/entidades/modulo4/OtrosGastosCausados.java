/**
 * 
 */
package co.org.dane.persistencia.entidades.modulo4;

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

import co.org.dane.persistencia.entidades.modulo1.CaratulaUnica;
import co.org.dane.persistencia.entidades.modulo2.ConceptosOtrosGastos;
import co.org.dane.persistencia.entidades.modulo3.TipoGastos;//TODO Validar si es la misma clase.
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_OTROS_GASTOS_CAUSADOS")
@Setter
@Getter
public class OtrosGastosCausados implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqOtrosGastosCausados" )
	@SequenceGenerator( name = "SeqOtrosGastosCausados", sequenceName = "SEQ_OTROS_GASTOS_CAUSADOS", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_OTRO_GASTO_CAUSADO_PK", nullable = false )
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
	@JoinColumn(name = "ID_TIPO_GASTO_FK", nullable = false, updatable = true)
	private TipoGastos tipoGastos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "otrosGastosCausados")
	private Collection<ConceptosOtrosGastos> conceptosOtrosGastos;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;
}
