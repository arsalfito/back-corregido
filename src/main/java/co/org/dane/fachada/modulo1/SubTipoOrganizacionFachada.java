/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.SubTipoOrganizacionDTO;
import co.org.dane.persistencia.entidades.modulo1.SubTipoOrganizacion;

/**
 * @author ALFONSO
 *
 */
public class SubTipoOrganizacionFachada {

	private static SubTipoOrganizacionFachada subTipoOrganizacionFachada;
	
	public static SubTipoOrganizacionFachada getInstance() {
		if(subTipoOrganizacionFachada == null)
			return new SubTipoOrganizacionFachada();
		else
			return subTipoOrganizacionFachada;
	}
	
	public List<SubTipoOrganizacionDTO> obtenerListaDTO(List<SubTipoOrganizacion> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<SubTipoOrganizacion> obtenerListaEntity(List<SubTipoOrganizacionDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	public SubTipoOrganizacionDTO convertirDTO(SubTipoOrganizacion entity){
	
		SubTipoOrganizacionDTO dto = new SubTipoOrganizacionDTO();
		dto.setId(entity.getId());
		dto.setOrden(entity.getOrden());
		dto.setCodigo(entity.getCodigo());
		dto.setNombre(entity.getNombre());
		
		return dto;
	}
	
	public SubTipoOrganizacion convertirEntity(SubTipoOrganizacionDTO dto){
		
		SubTipoOrganizacion entity = new SubTipoOrganizacion();
		entity.setId(dto.getId());
		entity.setOrden(dto.getOrden());
		entity.setCodigo(dto.getCodigo());
		entity.setNombre(dto.getNombre());
		
		return entity;
	}
}
