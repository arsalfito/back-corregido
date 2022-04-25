/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.TipoVariableDTO;
import co.org.dane.persistencia.entidades.TipoVariable;

/**
 * @author ALFONSO
 *
 */
public class TipoVariableFachada {

	private static TipoVariableFachada tipoVariableFachada;
	
	public static TipoVariableFachada getInstance() {
		if(tipoVariableFachada == null)
			return new TipoVariableFachada();
		else
			return tipoVariableFachada;
	}
	
	public List<TipoVariableDTO> obtenerListaDTO(List<TipoVariable> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<TipoVariable> obtenerListaEntity(List<TipoVariableDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	public TipoVariableDTO convertirDTO(TipoVariable entity){
	
		TipoVariableDTO dto = new TipoVariableDTO();
		dto.setId(entity.getId());
		dto.setOrden(entity.getOrden());
		dto.setCodigo(entity.getCodigo());
		dto.setNombre(entity.getNombre());
		
		return dto;
	}
	
	public TipoVariable convertirEntity(TipoVariableDTO dto){
		
		TipoVariable entity = new TipoVariable();
		entity.setId(dto.getId());
		entity.setOrden(dto.getOrden());
		entity.setCodigo(dto.getCodigo());
		entity.setNombre(dto.getNombre());
		
		return entity;
	}
}
