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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.org.dane.persistencia.entidades.tipos.TipoClientes;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_CLIENTE_PRINCIPAL")
@Setter
@Getter
public class ClientePrincipal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqClientePrincipal" )
	@SequenceGenerator( name = "SeqClientePrincipal", sequenceName = "SEQ_CLIENTE_PRINCIPAL", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_CLIENTE_PRINCIPAL_PK", nullable = false )
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_CLIENTES_FK", nullable = false, updatable = true)
	private TipoClientes tipoClientes;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARATULA_UNICA_FK", nullable = false, updatable = true)
	private CaratulaUnica caratulaUnica;
}
