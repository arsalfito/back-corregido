/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.DireccionDTO;
import co.org.dane.persistencia.entidades.Departamento;
import co.org.dane.persistencia.entidades.Direccion;
import co.org.dane.persistencia.entidades.Municipio;

/**
 * @author ALFONSO
 *
 */
public class DireccionFachada {

	private static DireccionFachada direccioonFachada;
	
	public static DireccionFachada getInstance() {
		if(direccioonFachada == null)
			return new DireccionFachada();
		else
			return direccioonFachada;
	}
	
	public List<DireccionDTO> obtenerListaDTO(List<Direccion> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<Direccion> obtenerListaEntity(List<DireccionDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	public DireccionDTO convertirDTO(Direccion entity){
		DireccionDTO dto = new DireccionDTO();
		dto.setId(entity.getId());
		dto.setLocalizacionGeoreferenciada(entity.getLocalizacionGeoreferenciada());
		dto.setDireccion(entity.getDireccion());
		dto.setTelefono(entity.getTelefono());
		dto.setRedesSociales(entity.getRedesSociales());
		dto.setCorreoElectronico(entity.getCorreoElectronico());
		dto.setPaginaWeb(entity.getPaginaWeb());
		dto.setIdDepartamento(entity.getDepartamento() != null ? entity.getDepartamento().getId() : 0);
		dto.setIdMunicipio(entity.getMunicipio() != null ? entity.getMunicipio().getId() : 0);
		//TODO Ajustar
		//dto.setIdTipoDireccion(entity.getTipoDireccion() != null ? entity.getTipoDireccion().getId() : 0);
		//dto.setIdCaratulaUnica(entity.getCaratulaUnica() != null ? entity.getCaratulaUnica().getId() : 0);
		return dto;
	}
	
	public Direccion convertirEntity(DireccionDTO dto){
		
		Direccion entity = new Direccion();
		entity.setId(dto.getId());
		entity.setLocalizacionGeoreferenciada(dto.getLocalizacionGeoreferenciada());
		entity.setDireccion(dto.getDireccion());
		entity.setTelefono(dto.getTelefono());
		entity.setRedesSociales(dto.getRedesSociales());
		entity.setCorreoElectronico(dto.getCorreoElectronico());
		entity.setPaginaWeb(dto.getPaginaWeb());
		
		if(dto.getIdDepartamento() != 0) {
			Departamento de = new Departamento();
			de.setId(dto.getIdDepartamento());
			entity.setDepartamento(de);
		}
		
		if(dto.getIdMunicipio() != 0) {
			Municipio mu = new Municipio();
			mu.setId(dto.getIdMunicipio());
			entity.setMunicipio(mu);
		}
		
		/*if(dto.getIdTipoDireccion() != 0) {
			TipoDireccion td = new TipoDireccion();
			td.setId(dto.getIdTipoDireccion());
			entity.setTipoDireccion(td);
		}*/
		
		/*if(dto.getIdCaratulaUnica() != 0) {
			CaratulaUnica cu = new CaratulaUnica();
			cu.setId(dto.getIdCaratulaUnica());
			entity.setCaratulaUnica(cu);
		}*/
		
		return entity;
		
	}
	
	
}

/*
private long id;
private double localizacionGeoreferenciada;
private String direccion;
private String telefono;
private String redesSociales;
private String correoElectronico;
private String paginaWeb;
private int idTipoDireccion;
private long idCaratulaUnica;
*/