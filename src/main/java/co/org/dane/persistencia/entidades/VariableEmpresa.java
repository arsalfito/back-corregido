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

import co.org.dane.persistencia.entidades.tipos.TipoVariable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_VARIABLES_EMPRESA")
@Setter
@Getter
public class VariableEmpresa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqVariableEmpresa" )
	@SequenceGenerator( name = "SeqVariableEmpresa", sequenceName = "SEQ_VARIABLES_EMPRESA", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_VARIABLE_EMPRESA_PK", nullable = false )
	private long id;
	
	@Column( name = "NUMERO_ESTABLECIMIENTOS", nullable = false, updatable = true, length = 5)
	private int numeroEstablecimientos;
	
	@Column( name = "INGRESO", nullable = false, updatable = true, length = 12)
	private long ingreso;
	
	@Column( name = "PERSONAL_OCUPADO", nullable = false, updatable = true, length = 7)
	private int personalOcupado;
	
	@Column( name = "REMUNERACION", nullable = true, updatable = true, length = 12)
	private long remuneracion;
	
	@Column( name = "OTROS_COSTOS_GASTOS", nullable = false, updatable = true, length = 12)
	private long otrosCostosGastos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_VARIABLE_FK", nullable = false, updatable = true)
	private TipoVariable seccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CODIGO_CIIU_FK", nullable = false, updatable = true)
	private CodigoCIIU codigoCIIU;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;
}
