/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.CaratulaUnicaDTO;
import co.org.dane.persistencia.entidades.modulo1.CaratulaUnica;
import co.org.dane.persistencia.entidades.modulo1.Directorio;
import co.org.dane.persistencia.entidades.modulo1.EstadoEmpresa;
import co.org.dane.persistencia.entidades.modulo1.PeriodoRecoleccion;
import co.org.dane.persistencia.entidades.modulo1.SubTipoOrganizacion;
import co.org.dane.persistencia.entidades.modulo1.TipoCausa;
import co.org.dane.persistencia.entidades.modulo1.TipoDocumento;
import co.org.dane.persistencia.entidades.modulo1.TipoOrganizacion;
import co.org.dane.persistencia.entidades.modulo1.TipoRegistroMercantil;

/**
 * @author ALFONSO
 *
 */
public class CaratulaUnicaFachada {

	private static CaratulaUnicaFachada caratulaUnicaFachada;
	
	public static CaratulaUnicaFachada getInstance() {
		if(caratulaUnicaFachada == null)
			return new CaratulaUnicaFachada();
		else
			return caratulaUnicaFachada;
	}
	
	
	public List<CaratulaUnicaDTO> obtenerListaDTO(List<CaratulaUnica> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<CaratulaUnica> obtenerListaEntity(List<CaratulaUnicaDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	
	public CaratulaUnicaDTO convertirDTO(CaratulaUnica entity){
		
		CaratulaUnicaDTO dto = new CaratulaUnicaDTO();
		
		dto.setId(entity.getId());
		dto.setNumeroOrden(entity.getNumeroOrden());
		dto.setNumeroDocumento(entity.getNumeroDocumento());
		dto.setDigitoVerificacion(entity.getDigitoVerificacion());
		dto.setNumeroCamara(entity.getNumeroCamara());
		dto.setNumeroRegistro(entity.getNumeroRegistro());
		dto.setRazonSocial(entity.getRazonSocial());
		dto.setGeoreferenciaGerecia(entity.getGeoreferenciaGerecia());
		dto.setNombreComercial(entity.getNombreComercial());
		dto.setSigla(entity.getSigla());
		dto.setPaginaWeb(entity.getPaginaWeb());
		dto.setGeoreferenciaNotificacion(entity.getGeoreferenciaNotificacion());
		dto.setCualTipoOrgaizacion(entity.getCualTipoOrgaizacion());
		dto.setFechaConstitucionDesde(""+entity.getFechaConstitucionDesde());
		dto.setFechaConstitucionHasta(""+entity.getFechaConstitucionHasta());	
		dto.setCualOtroEstado(entity.getCualOtroEstado());
		dto.setNumeroUnidadesApoyo(entity.getNumeroUnidadesApoyo());
		dto.setIdTipoDocumento(entity.getTipoDocumento() != null ? entity.getTipoDocumento().getId() : 0);
		dto.setIdTipoRegistroMercantil(entity.getTipoRegistroMercantil() != null ? entity.getTipoRegistroMercantil().getId() : 0);		
		dto.setIdTipoOrganizacion(entity.getTipoOrganizacion() != null ? entity.getTipoOrganizacion().getId() : 0);
		dto.setIdTipoCausa(entity.getTipoCausa() != null ? entity.getTipoCausa().getId() : 0);
		
		if(entity.getSubTipoOrganizacion()==null)
			dto.setIdSubTipoOrganizacion(0);
		else {
			dto.setIdSubTipoOrganizacion(entity.getSubTipoOrganizacion().getId());
			dto.setCualTipoOrgaizacion("");
		}
		//dto.setIdSubTipoOrganizacion(entity.getSubTipoOrganizacion() != null ? entity.getSubTipoOrganizacion().getId() : 0);
		
		dto.setIdEstadoEmpresa(entity.getEstadoEmpresa() != null ? entity.getEstadoEmpresa().getId() : 0);
		dto.setIdPeriodoRecoleccion(entity.getPeriodoRecoleccion() != null ? entity.getPeriodoRecoleccion().getId() : 0 );
		dto.setIdDirectorio(entity.getDirectorio() != null ? entity.getDirectorio().getId() : 0);
		
		return dto;
	}
	
	public CaratulaUnica convertirEntity(CaratulaUnicaDTO dto){
		
		CaratulaUnica caratulaUnica = new CaratulaUnica();
		caratulaUnica.setId(dto.getId());
		caratulaUnica.setNumeroOrden(dto.getNumeroOrden());
		caratulaUnica.setNumeroDocumento(dto.getNumeroDocumento());
		caratulaUnica.setDigitoVerificacion(dto.getDigitoVerificacion());
		caratulaUnica.setNumeroCamara(dto.getNumeroCamara());
		caratulaUnica.setNumeroRegistro(dto.getNumeroRegistro());
		caratulaUnica.setRazonSocial(dto.getRazonSocial());
		caratulaUnica.setGeoreferenciaGerecia(dto.getGeoreferenciaGerecia());
		caratulaUnica.setNombreComercial(dto.getNombreComercial());
		caratulaUnica.setSigla(dto.getSigla());
		caratulaUnica.setPaginaWeb(dto.getPaginaWeb());
		caratulaUnica.setGeoreferenciaNotificacion(dto.getGeoreferenciaNotificacion());
		caratulaUnica.setCualTipoOrgaizacion(dto.getCualTipoOrgaizacion());
		
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if(dto.getFechaConstitucionDesde()!=null)
				caratulaUnica.setFechaConstitucionDesde(format.parse(dto.getFechaConstitucionDesde()));
			
			if(dto.getFechaConstitucionHasta()!=null)
				caratulaUnica.setFechaConstitucionHasta(format.parse(dto.getFechaConstitucionHasta()));					
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		caratulaUnica.setCualOtroEstado(dto.getCualOtroEstado());
		caratulaUnica.setNumeroUnidadesApoyo(dto.getNumeroUnidadesApoyo());
		
		if(dto.getIdTipoDocumento() != 0){
			TipoDocumento td = new TipoDocumento();
			td.setId(dto.getIdTipoDocumento());		
			caratulaUnica.setTipoDocumento(td);
		}
			
		if(dto.getIdTipoRegistroMercantil() != 0){
			TipoRegistroMercantil trm = new TipoRegistroMercantil();
			trm.setId(dto.getIdTipoRegistroMercantil());
			caratulaUnica.setTipoRegistroMercantil(trm);
		}
		
		if(dto.getIdTipoOrganizacion() != 0){
			TipoOrganizacion to = new TipoOrganizacion();
			to.setId(dto.getIdTipoOrganizacion());
			caratulaUnica.setTipoOrganizacion(to);
		}
		
		if(dto.getIdTipoCausa() != 0) {
			TipoCausa tc = new TipoCausa();
			tc.setId(dto.getIdTipoCausa());
			caratulaUnica.setTipoCausa(tc);
		}
		
		if(dto.getIdSubTipoOrganizacion() != 0){
			SubTipoOrganizacion sto = new SubTipoOrganizacion();
			sto.setId(dto.getIdSubTipoOrganizacion());
			caratulaUnica.setSubTipoOrganizacion(sto);
			caratulaUnica.setCualTipoOrgaizacion("");
		}

		if(dto.getIdEstadoEmpresa() != 0){
			EstadoEmpresa ee = new EstadoEmpresa();
			ee.setId(dto.getIdEstadoEmpresa());
			caratulaUnica.setEstadoEmpresa(ee);
		}
		
		if(dto.getIdPeriodoRecoleccion() != 0){
			PeriodoRecoleccion pr = new PeriodoRecoleccion();
			pr.setId(dto.getIdPeriodoRecoleccion());
			caratulaUnica.setPeriodoRecoleccion(pr);
		}
		
		if(dto.getIdDirectorio() != 0){
			Directorio di = new Directorio();
			di.setId(dto.getIdDirectorio());
			caratulaUnica.setDirectorio(di);
		}
		
		
		//private long id;
		//private int numeroOrden;
		//private long numeroDocumento;
		//private byte digitoVerificacion;
		//private int numeroCamara;
		//private long numeroRegistro;	
		//private String razonSocial;
		//private String georeferenciaGerecia;
		//private String nombreComercial;
		
		//private String sigla;
		//private String paginaWeb;
		//private String georeferenciaNotificacion;
		//private String cualTipoOrgaizacion;
		//private String fechaConstitucionDesde;
		//private String fechaConstitucionHasta;
		//private String cualOtroEstado;
		//private String numeroUnidadesApoyo;	
		//private int idTipoDocumento;
		
		
		return caratulaUnica;
	}
	
}
