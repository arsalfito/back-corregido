package co.org.dane.persistencia.entidades.tipos;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "my_DType", discriminatorType = DiscriminatorType.STRING )
@Table(name="EAC_TIPOS_GENERICOS")
@Setter
@Getter
public class TiposGenericos {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqTiposGenericos" )
	@SequenceGenerator( name = "SeqTiposGenericos", sequenceName = "SEQ_TIPOS_GENERICOS", initialValue = 1, allocationSize = 1 )
	@Column( name = "id", nullable = false )
	private Integer Id;
	
	private Integer codigo;
	
	@Column(length = 300, nullable = false)
	private String nombre;
	
	@Column(length = 3, nullable = true)
	private int orden;
	
	@Column(name = "my_DType", insertable = false, updatable = false)
	private String myDType;
	
}
