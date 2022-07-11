/**
 * 
 */
package co.org.dane.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;

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

import co.org.dane.persistencia.entidades.tipos.TipoOtrosGastos;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_OTRO_GASTO_FK", nullable = false, updatable = true)
	private TipoOtrosGastos tipoOtrosGastos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "otrosGastosCausados")
	private Collection<ConceptosOtrosGastos> conceptosOtrosGastos;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;
}
