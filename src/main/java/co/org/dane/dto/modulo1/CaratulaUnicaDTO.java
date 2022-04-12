/**
 * 
 */
package co.org.dane.dto.modulo1;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Setter
@Getter
public class CaratulaUnicaDTO implements Serializable{

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
		
	private int idTipoDocumento;	
	private int idTipoCausa;
	private int idTipoRegistroMercantil;
	private int idTipoOrganizacion;
	private int idSubTipoOrganizacion;
	private int idEstadoEmpresa;
	private int idPeriodoRecoleccion;
	private long idDirectorio;
	private int idEstadoEncuesta;
	
}
