/**
 * 
 */
package co.org.dane.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.org.dane.persistencia.entidades.enumeraciones.ETipoGrupo;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_GRUP_MERC_MAY_VEN")
@Setter
@Getter
public class GruposMercanciasMayoresVentas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqTipoGrupo" )
	@SequenceGenerator( name = "SeqTipoGrupo", sequenceName = "SEQ_GRUP_MERC_MAY_VEN", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_GRUP_MERC_MAY_VEN_PK", nullable = false )
	private long id;
	
	@Column( name = "NOMBRE", nullable = false, updatable = true, length = 150 )
	private String nombre;
	
	@Column( name = "PORCENTAJE_VENTAS", nullable = false, updatable = true, length = 3 )
	private double porcentajeVentas;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private ETipoGrupo tipoGrupo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CODIGO_CIIU_FK", nullable = false, updatable = true)
	private CodigoCIIU codigoCIIU;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_INGRESOS_NETOS_GRUPO_FK", nullable = false, updatable = true)
	private IngresosNetosPorGrupos ingresosNetosPorGrupos;

}
