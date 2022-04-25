/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.CodigoCIIUDTO;
import co.org.dane.persistencia.entidades.CodigoCIIU;

/**
 * @author ALFONSO
 *
 */
public class CodigoCIIUFachada {
	
	private static CodigoCIIUFachada codigoCIIUFachada;
	
	public static CodigoCIIUFachada getInstance() {
		if(codigoCIIUFachada == null)
			return new CodigoCIIUFachada();
		else
			return codigoCIIUFachada;
	}
	
	public List<CodigoCIIUDTO> obtenerListaDTO(List<CodigoCIIU> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<CodigoCIIU> obtenerListaEntity(List<CodigoCIIUDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	public CodigoCIIUDTO convertirDTO(CodigoCIIU entity){
	
		CodigoCIIUDTO dto = new CodigoCIIUDTO();
		dto.setId(entity.getId());
		dto.setOrden(entity.getOrden());
		dto.setCodigo(entity.getCodigo());
		dto.setNombre(entity.getNombre());
		
		return dto;
	}
	
	public CodigoCIIU convertirEntity(CodigoCIIUDTO dto){
		
		CodigoCIIU entity = new CodigoCIIU();
		entity.setId(dto.getId());
		entity.setOrden(dto.getOrden());
		entity.setCodigo(dto.getCodigo());
		entity.setNombre(dto.getNombre());
		
		return entity;
	}

}
