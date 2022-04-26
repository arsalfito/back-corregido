/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.CapitalSocialDTO;
import co.org.dane.persistencia.entidades.CapitalSocial;

/**
 * @author ALFONSO
 *
 */
public class CapitalSocialFachada {
	
private static CapitalSocialFachada capitalSocialFachada;
	
	public static CapitalSocialFachada getInstance() {
		if(capitalSocialFachada == null)
			return new CapitalSocialFachada();
		else
			return capitalSocialFachada;
	}
	
	
	public List<CapitalSocialDTO> obtenerListaDTO(List<CapitalSocial> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<CapitalSocial> obtenerListaEntity(List<CapitalSocialDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	public CapitalSocialDTO convertirDTO(CapitalSocial entity){
		
		CapitalSocialDTO dto = new CapitalSocialDTO();
		dto.setId(entity.getId());
		dto.setPublico(entity.getPublico());
		dto.setPrivado(entity.getPrivado());
		dto.setTotal(entity.getTotal());
		//TODO Ajustar
		//dto.setIdTipoCapitalSocial(entity.getTipoCapitalSocial() != null ? entity.getTipoCapitalSocial().getId() : 0);
		//dto.setIdCaratulaUnica(entity.getCaratulaUnica() != null ? entity.getCaratulaUnica().getId() : 0);
		
		return dto;
	}
	
	public CapitalSocial convertirEntity(CapitalSocialDTO dto){
		CapitalSocial entity = new CapitalSocial();
		entity.setId(dto.getId());
		entity.setPublico(dto.getPublico());
		entity.setPrivado(dto.getPrivado());
		entity.setTotal(dto.getTotal());
		
		/*if(dto.getIdTipoCapitalSocial() != 0){
			TipoCapitalSocial tc = new TipoCapitalSocial();
			tc.setId(dto.getIdTipoCapitalSocial());
			entity.setTipoCapitalSocial(tc);
		}*/
		
		/*if(dto.getIdCaratulaUnica() != 0){
			CaratulaUnica cu = new CaratulaUnica();
			cu.setId(dto.getIdCaratulaUnica());
			entity.setCaratulaUnica(cu);
		}*/
		
		return entity;
	}
		
		

}

/*
private long id;
private int publico;
private int privado;
private int total;
private int idTipoCapitalSocial;
private long idCaratulaUnica;
*/
