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

import co.org.dane.persistencia.entidades.enumeraciones.EEstadoObservaciones;
import co.org.dane.persistencia.entidades.jwt.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EAC_OBSERVACIONES")
@Setter
@Getter
public class Observaciones implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqObservaciones" )
	@SequenceGenerator( name = "SeqObservaciones", sequenceName = "SEQ_OBSERVACIONES", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_OBSERVACION_PK", nullable = false )
	private long id;
	
	@Column( name = "OBSERVACION_GENERAL", nullable = true, updatable = true, length = 4000 )
	private String observacionGeneral;
	
	@Column( name = "OBSERVACION_ANUAL", nullable = true, updatable = true, length = 4000 )
	private String observacionAnual;
	
	@Column( name = "OBSERVACION_MENSUAL", nullable = true, updatable = true, length = 4000 )
	private String observacionMensual;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private EEstadoObservaciones estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_INCONSISTENCIA_FK", nullable = false, updatable = true)
	private Inconsistencias inconsistencias;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO_FK", nullable = false, updatable = true)
	private User usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;
}
