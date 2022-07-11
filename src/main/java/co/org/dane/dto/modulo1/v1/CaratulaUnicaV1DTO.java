/**
 * 
 */
package co.org.dane.dto.modulo1.v1;

import java.io.Serializable;
import java.util.List;

import co.org.dane.dto.modulo1.CapitalSocialDTO;
import co.org.dane.dto.modulo1.OperacionDTO;
import co.org.dane.persistencia.entidades.enumeraciones.ETipoDocumento;
import co.org.dane.persistencia.entidades.enumeraciones.ETipoRegistroMercantil;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Setter
@Getter
public class CaratulaUnicaV1DTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private int numeroOrden;
	private long numeroDocumento;
	private byte digitoVerificacion;
	private int numeroCamara;
	private long numeroRegistro;	
	private String razonSocial;
	private double georeferenciaGerecia;
	private String nombreComercial;
	private String sigla;
	private String paginaWeb;
	private double georeferenciaNotificacion;
	private String cualTipoOrgaizacion;
	private String fechaConstitucionDesde;
	private String fechaConstitucionHasta;
	private String cualOtroEstado;
	private String numeroUnidadesApoyo;	
	
	
	private int idPeriodoRecoleccion;
	private int idTipoOrganizacion;
	private int idSubTipoOrganizacion;
	private ETipoDocumento tipoDocumento;
	private ETipoRegistroMercantil tipoRegistroMercantil;
	private int idCausasOperacion;
	private int idEstadoEmpresa;
	
	
	
	private long idDireccionPrincipal;
	private long idDireccionNotificacion;
	
	private long idDirectorio;
	
	
	private CapitalSocialDTO capitalSocialExt;
	private CapitalSocialDTO capitalSocialNac;
	private List<OperacionDTO> operaciones;
	
	
	/*;	
	private int idTipoCausa;
	;
	;
	private long idDirectorio;
	private int idEstadoEncuesta;*/
	
}
