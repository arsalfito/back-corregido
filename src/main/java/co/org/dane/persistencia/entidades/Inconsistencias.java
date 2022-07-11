package co.org.dane.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.org.dane.persistencia.entidades.enumeraciones.ETiposInconsistencia;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EAC_INCONSISTENCIAS")
@Setter
@Getter
public class Inconsistencias implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqInconsistencias" )
	@SequenceGenerator( name = "SeqInconsistencias", sequenceName = "SEQ_INCONSISTENCIAS", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_INCONSISTENCIA_PK", nullable = false )
	private long id;
	
	@Column( name = "DESCRIPCION", nullable = true, updatable = true, length = 4000 )
	private String descripcion;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ETiposInconsistencia tipoInconsistencia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MODULO_FK", nullable = false, updatable = true)
	private Modulo modulo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inconsistencias")
	private Collection<Observaciones> observaciones;

}
