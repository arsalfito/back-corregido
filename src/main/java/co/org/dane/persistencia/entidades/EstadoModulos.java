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

import co.org.dane.persistencia.entidades.enumeraciones.EEstadoDiligenciamiento;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_ESTADO_MODULOS")
@Setter
@Getter
public class EstadoModulos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqEstadoModulos" )
	@SequenceGenerator( name = "SeqEstadoModulos", sequenceName = "SEQ_ESTADO_MODULOS", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_ESTADO_MODULO_PK", nullable = false )
	private int id;
	
	@Column( name = "ESTADO", nullable = false, updatable = true, length = 1 )
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MODULO_FK", nullable = false, updatable = true)
	private Modulo modulo;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EEstadoDiligenciamiento estadoDiligenciamiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;

}
