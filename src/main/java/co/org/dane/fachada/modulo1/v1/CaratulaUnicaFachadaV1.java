/**
 * 
 */
package co.org.dane.fachada.modulo1.v1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.CapitalSocialDTO;
import co.org.dane.dto.modulo1.OperacionDTO;
import co.org.dane.dto.modulo1.v1.CaratulaUnicaV1DTO;
import co.org.dane.persistencia.entidades.CapitalSocial;
import co.org.dane.persistencia.entidades.CaratulaUnica;
import co.org.dane.persistencia.entidades.Direccion;
import co.org.dane.persistencia.entidades.Directorio;
import co.org.dane.persistencia.entidades.EstadoEmpresa;
import co.org.dane.persistencia.entidades.Operacion;
import co.org.dane.persistencia.entidades.PeriodoRecoleccion;
import co.org.dane.persistencia.entidades.tipos.CausasOperacion;
import co.org.dane.persistencia.entidades.tipos.SubTipoOrganizacion;
import co.org.dane.persistencia.entidades.tipos.TipoOrganizacion;

/**
 * @author ALFONSO
 *
 */
public class CaratulaUnicaFachadaV1 {

	private static CaratulaUnicaFachadaV1 caratulaUnicaFachada;
	
	public static CaratulaUnicaFachadaV1 getInstance() {
		if(caratulaUnicaFachada == null)
			return new CaratulaUnicaFachadaV1();
		else
			return caratulaUnicaFachada;
	}
	
	
	public List<CaratulaUnicaV1DTO> obtenerListaDTO(List<CaratulaUnica> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<CaratulaUnica> obtenerListaEntity(List<CaratulaUnicaV1DTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	
	public CaratulaUnicaV1DTO convertirDTO(CaratulaUnica entity){
		
		CaratulaUnicaV1DTO dto = new CaratulaUnicaV1DTO();
		
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
		
		dto.setTipoDocumento(entity.getTipoDocumento());
		dto.setTipoRegistroMercantil(entity.getTipoRegistroMercantil());
		dto.setIdTipoOrganizacion(entity.getTipoOrganizacion() != null ? entity.getTipoOrganizacion().getId() : 0);
		dto.setIdSubTipoOrganizacion(entity.getSubTipoOrganizacion() != null ? entity.getSubTipoOrganizacion().getId() : 0);
		dto.setIdEstadoEmpresa(entity.getEstadoEmpresa() != null ? entity.getEstadoEmpresa().getId() : 0);
		dto.setIdPeriodoRecoleccion(entity.getPeriodoRecoleccion() != null ? entity.getPeriodoRecoleccion().getId() : 0 );
		dto.setIdCausasOperacion(entity.getCausasOperacion() != null ? entity.getCausasOperacion().getId() : 0);
		
		dto.setIdDirectorio(entity.getDirectorio() != null ? entity.getDirectorio().getId() : 0);
		
		if(entity.getCapitalSocialExtranjero()!=null) {
			CapitalSocialDTO cseDTO = new CapitalSocialDTO();
			cseDTO.setId(entity.getCapitalSocialExtranjero().getId());
			cseDTO.setPublico(entity.getCapitalSocialExtranjero().getPublico());
			cseDTO.setPrivado(entity.getCapitalSocialExtranjero().getPrivado());
			cseDTO.setTotal(entity.getCapitalSocialExtranjero().getTotal());
			cseDTO.setTipoCapitalSocial(entity.getCapitalSocialExtranjero().getTipoCapitalSocial());
			dto.setCapitalSocialExt(cseDTO);
		}
		
		if(entity.getCapitalSocialNacional()!=null) {
			CapitalSocialDTO csnDTO = new CapitalSocialDTO();
			csnDTO.setId(entity.getCapitalSocialNacional().getId());
			csnDTO.setPublico(entity.getCapitalSocialNacional().getPublico());
			csnDTO.setPrivado(entity.getCapitalSocialNacional().getPrivado());
			csnDTO.setTotal(entity.getCapitalSocialNacional().getTotal());
			csnDTO.setTipoCapitalSocial(entity.getCapitalSocialNacional().getTipoCapitalSocial());
			dto.setCapitalSocialNac(csnDTO);
		}
		
		//Transforma las operaciones a DTO.
		List<Operacion> operaciones = (List<Operacion>) entity.getOperaciones();
		if(operaciones!=null && !operaciones.isEmpty()){
			List<OperacionDTO> opDTO = new ArrayList<OperacionDTO>();
			int length = operaciones.size();
			IntStream.range(0, length).forEach(index  -> {
				opDTO.add(convertirOperacionDTO(operaciones.get(index)));	
			});
			dto.setOperaciones(opDTO);
		}
				
		return dto;
	}
	
	public CaratulaUnica convertirEntity(CaratulaUnicaV1DTO dto){
		
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
		
		caratulaUnica.setTipoDocumento(dto.getTipoDocumento());
		caratulaUnica.setTipoRegistroMercantil(dto.getTipoRegistroMercantil());
		
		if(dto.getIdDirectorio() != 0){
			Directorio di = new Directorio();
			di.setId(dto.getIdDirectorio());
			caratulaUnica.setDirectorio(di);
		}
		
		if(dto.getIdPeriodoRecoleccion() != 0){
			PeriodoRecoleccion pr = new PeriodoRecoleccion();
			pr.setId(dto.getIdPeriodoRecoleccion());
			caratulaUnica.setPeriodoRecoleccion(pr);
		}
		
		if(dto.getIdTipoOrganizacion() != 0){
			TipoOrganizacion to = new TipoOrganizacion();
			to.setId(dto.getIdTipoOrganizacion());
			caratulaUnica.setTipoOrganizacion(to);
		}
		
		if(dto.getIdSubTipoOrganizacion() != 0){
			SubTipoOrganizacion sto = new SubTipoOrganizacion();
			sto.setId(dto.getIdSubTipoOrganizacion());
			caratulaUnica.setSubTipoOrganizacion(sto);
		}
		
		if(dto.getIdCausasOperacion() != 0) {
			CausasOperacion co = new CausasOperacion();
			co.setId(dto.getIdCausasOperacion());
			caratulaUnica.setCausasOperacion(co);
		}
		
		if(dto.getIdEstadoEmpresa() != 0){
			EstadoEmpresa ee = new EstadoEmpresa();
			ee.setId(dto.getIdEstadoEmpresa());
			caratulaUnica.setEstadoEmpresa(ee);
		}
		
		if(dto.getCapitalSocialExt() != null){
			CapitalSocial cse = new CapitalSocial();
			cse.setId(dto.getCapitalSocialExt().getId());
			cse.setPublico(dto.getCapitalSocialExt().getPublico());
			cse.setPrivado(dto.getCapitalSocialExt().getPrivado());
			cse.setTotal(dto.getCapitalSocialExt().getTotal());
			cse.setTipoCapitalSocial(dto.getCapitalSocialExt().getTipoCapitalSocial());
			caratulaUnica.setCapitalSocialExtranjero(cse);
		}
		
		if(dto.getCapitalSocialNac() != null){
			CapitalSocial csn = new CapitalSocial();
			csn.setId(dto.getCapitalSocialNac().getId());
			csn.setPublico(dto.getCapitalSocialNac().getPublico());
			csn.setPrivado(dto.getCapitalSocialNac().getPrivado());
			csn.setTotal(dto.getCapitalSocialNac().getTotal());
			csn.setTipoCapitalSocial(dto.getCapitalSocialNac().getTipoCapitalSocial());
			caratulaUnica.setCapitalSocialNacional(csn);
		}
		
		if(dto.getIdDireccionPrincipal() != 0){
			Direccion dip = new Direccion();
			dip.setId(dto.getIdDireccionPrincipal());
			caratulaUnica.setDireccionPrincipal(dip);
		}
		
		if(dto.getIdDireccionNotificacion() != 0){
			Direccion din = new Direccion();
			din.setId(dto.getIdDireccionNotificacion());
			caratulaUnica.setDireccionNotificacion(din);
		}
		
		if(dto.getOperaciones() != null && !dto.getOperaciones().isEmpty()){
			Collection<Operacion> operaciones = new ArrayList<Operacion>();
			int length = dto.getOperaciones().size();
			IntStream.range(0, length).forEach(index  -> {
				OperacionDTO opDTO = dto.getOperaciones().get(index);
				
				Operacion entity = new Operacion();
				entity.setId(opDTO.getId());
				entity.setBienes(opDTO.getBienes());
				entity.setServicios(opDTO.getServicios());
				entity.setNinguna(opDTO.getNinguna());
				entity.setTipoOperacion(opDTO.getTipoOperacion());
				operaciones.add(entity);
					
			});
			caratulaUnica.setOperaciones(operaciones);
		}else
			caratulaUnica.setOperaciones(null);
		
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
	
	private OperacionDTO convertirOperacionDTO(Operacion entity){
		
		OperacionDTO dto = new OperacionDTO();
		dto.setId(entity.getId());
		dto.setBienes(entity.getBienes());
		dto.setServicios(entity.getServicios());
		dto.setNinguna(entity.getNinguna());
		dto.setTipoOperacion(entity.getTipoOperacion());
		dto.setIdCaratulaUnica(entity.getCaratulaUnica() != null ? entity.getCaratulaUnica().getId() : 0);
		
		return dto;
	}
	
}
