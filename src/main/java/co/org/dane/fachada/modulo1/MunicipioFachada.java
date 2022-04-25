/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.MunicipioDTO;
import co.org.dane.persistencia.entidades.Municipio;

/**
 * @author ALFONSO
 *
 */
public class MunicipioFachada {

	private static MunicipioFachada municipioFachada;
	
	public static MunicipioFachada getInstance() {
		if(municipioFachada == null)
			return new MunicipioFachada();
		else
			return municipioFachada;
	}
	
	public List<MunicipioDTO> obtenerListaDTO(List<Municipio> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<Municipio> obtenerListaEntity(List<MunicipioDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	public MunicipioDTO convertirDTO(Municipio entity){
	
		MunicipioDTO dto = new MunicipioDTO();
		dto.setId(entity.getId());
		dto.setCodigo(entity.getCodigo());
		dto.setNombre(entity.getNombre());
		
		return dto;
	}
	
	public Municipio convertirEntity(MunicipioDTO dto){
		
		Municipio entity = new Municipio();
		entity.setId(dto.getId());
		entity.setCodigo(dto.getCodigo());
		entity.setNombre(dto.getNombre());
		
		return entity;
	}
}
