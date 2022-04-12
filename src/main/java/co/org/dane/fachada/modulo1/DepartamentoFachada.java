/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.DepartamentoDTO;
import co.org.dane.persistencia.entidades.modulo1.Departamento;

/**
 * @author ALFONSO
 *
 */
public class DepartamentoFachada {
	
	private static DepartamentoFachada departamentoFachada;
	
	public static DepartamentoFachada getInstance() {
		if(departamentoFachada == null)
			return new DepartamentoFachada();
		else
			return departamentoFachada;
	}
	
	public List<DepartamentoDTO> obtenerListaDTO(List<Departamento> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<Departamento> obtenerListaEntity(List<DepartamentoDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	public DepartamentoDTO convertirDTO(Departamento entity){
	
		DepartamentoDTO dto = new DepartamentoDTO();
		dto.setId(entity.getId());
		dto.setCodigo(entity.getCodigo());
		dto.setNombre(entity.getNombre());
		
		return dto;
	}
	
	public Departamento convertirEntity(DepartamentoDTO dto){
		
		Departamento entity = new Departamento();
		entity.setId(dto.getId());
		entity.setCodigo(dto.getCodigo());
		entity.setNombre(dto.getNombre());
		
		return entity;
	}

}
