/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.InformacionFuncionamientoDTO;
import co.org.dane.persistencia.entidades.CaratulaUnica;
import co.org.dane.persistencia.entidades.InformacionFuncionamiento;
import co.org.dane.persistencia.entidades.tipos.TipoCausa;

/**
 * @author ALFONSO
 *
 */
public class InformacionFuncionamientoFachada {
	
private static InformacionFuncionamientoFachada informacionFuncionamientoFachada;
	
	public static InformacionFuncionamientoFachada getInstance() {
		if(informacionFuncionamientoFachada == null)
			return new InformacionFuncionamientoFachada();
		else
			return informacionFuncionamientoFachada;
	}
	
	
	public List<InformacionFuncionamientoDTO> obtenerListaDTO(List<InformacionFuncionamiento> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<InformacionFuncionamiento> obtenerListaEntity(List<InformacionFuncionamientoDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	
	public InformacionFuncionamientoDTO convertirDTO(InformacionFuncionamiento entity){
		
		InformacionFuncionamientoDTO dto = new InformacionFuncionamientoDTO();
		dto.setId(entity.getId());
		dto.setAnioInicioOperaciones(entity.getAnioInicioOperaciones());
		dto.setMesesOperacion(entity.getMesesOperacion());
		dto.setCualOtraCausa(entity.getCualOtraCausa());
		dto.setNumeroDepartamentos(entity.getNumeroDepartamentos());
		dto.setFechaDiligenciamiento(entity.getFechaDiligenciamiento());
		dto.setRepresentanteLegal(entity.getRepresentanteLegal());
		dto.setEmailRepresentante(entity.getEmailRepresentante());
		dto.setCelularRepresentante(entity.getCelularRepresentante());
		dto.setPersonaDiligencia(entity.getPersonaDiligencia());
		dto.setCargoDiligencia(entity.getCargoDiligencia());
		dto.setEmailDiligencia(entity.getEmailDiligencia());
		dto.setTelefonoDiligencia(entity.getTelefonoDiligencia());
		dto.setExtensionDiligencia(entity.getExtensionDiligencia());
		dto.setCelularDiligencia(entity.getCelularDiligencia());
		dto.setIdTipoCausa(entity.getTipoCausa() != null ? entity.getTipoCausa().getId() : 0);
		dto.setIdCaratulaUnica(entity.getCaratulaUnica() != null ? entity.getCaratulaUnica().getId() : 0);
		
		return dto;
	}
	
	public InformacionFuncionamiento convertirEntity(InformacionFuncionamientoDTO dto){
		
		InformacionFuncionamiento entity = new InformacionFuncionamiento();
		entity.setId(dto.getId());
		entity.setAnioInicioOperaciones(dto.getAnioInicioOperaciones());
		entity.setMesesOperacion(dto.getMesesOperacion());
		entity.setCualOtraCausa(dto.getCualOtraCausa());
		entity.setNumeroDepartamentos(dto.getNumeroDepartamentos());
		entity.setFechaDiligenciamiento(dto.getFechaDiligenciamiento());
		entity.setRepresentanteLegal(dto.getRepresentanteLegal());
		entity.setEmailRepresentante(dto.getEmailRepresentante());
		entity.setCelularRepresentante(dto.getCelularRepresentante());
		entity.setPersonaDiligencia(dto.getPersonaDiligencia());
		entity.setCargoDiligencia(dto.getCargoDiligencia());
		entity.setEmailDiligencia(dto.getEmailDiligencia());
		entity.setTelefonoDiligencia(dto.getTelefonoDiligencia());
		entity.setExtensionDiligencia(dto.getExtensionDiligencia());
		entity.setCelularDiligencia(dto.getCelularDiligencia());
		
		if(dto.getIdTipoCausa() != 0){
			TipoCausa tc = new TipoCausa();
			tc.setId(dto.getIdTipoCausa());
			entity.setTipoCausa(tc);
		}
		
		if(dto.getIdCaratulaUnica() != 0){
			CaratulaUnica cu = new CaratulaUnica();
			cu.setId(dto.getIdCaratulaUnica());
			entity.setCaratulaUnica(cu);
		}
		
		return entity;
	}

}

/*
private long id;
private int anioInicioOperaciones;
private int mesesOperacion;
private String cualOtraCausa;
private int numeroDepartamentos;
private Date fechaDiligenciamiento;
private String representanteLegal;
private String emailRepresentante;
private long celularRepresentante;
private String personaDiligencia;
private String cargoDiligencia;
private String emailDiligencia;
private long telefonoDiligencia;
private long extensionDiligencia;
private long celularDiligencia;
private int idTipoCausa;
private long idCaratulaUnica;
*/