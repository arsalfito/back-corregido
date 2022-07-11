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

import co.org.dane.persistencia.entidades.enumeraciones.ETiposActivos;
import co.org.dane.persistencia.entidades.tipos.TiposDerechosUso;
import co.org.dane.persistencia.entidades.tipos.TiposInversion;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_VALOR_ACTIVOS")
@Setter
@Getter
public class ValorActivos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqValorActivos" )
	@SequenceGenerator( name = "SeqValorActivos", sequenceName = "SEQ_VALOR_ACTIVOS", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_VALOR_ACTIVO_PK", nullable = false )
	private long id;
	
	@Column( name = "TERRENOS", nullable = true, updatable = true, length = 13 )
	private double terrenos;
	
	@Column( name = "CONSTRUCCIONES", nullable = true, updatable = true, length = 13 )
	private double construcciones;
	
	@Column( name = "EDIFICIOS_ESTRUCTURAS", nullable = true, updatable = true, length = 13 )
	private double edificiosEstructuras;
	
	@Column( name = "MAQUINARIA_EQUIPO", nullable = true, updatable = true, length = 13 )
	private double maquinariaEquipo;
	
	@Column( name = "EQUIPO_INFORMATICA", nullable = true, updatable = true, length = 13 )
	private double equipoInformatica;
	
	@Column( name = "SOFTWARE", nullable = true, updatable = true, length = 13 )
	private double software;
	
	@Column( name = "EQUIPO_TRANSPORTE", nullable = true, updatable = true, length = 13 )
	private double equipoTransporte;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private ETiposActivos tiposActivos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_INVERSION_FK", nullable = false, updatable = true)
	private TiposInversion tiposInversion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_DERECHO_USO_FK", nullable = false, updatable = true)
	private TiposDerechosUso tiposDerechosUso;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;

}
