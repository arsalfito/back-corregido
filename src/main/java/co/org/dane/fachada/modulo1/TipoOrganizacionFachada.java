/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.TipoOrganizacionDTO;
import co.org.dane.persistencia.entidades.modulo1.TipoOrganizacion;

/**
 * @author ALFONSO
 *
 */
public class TipoOrganizacionFachada {

	private static TipoOrganizacionFachada tipoOrganizacionFachada;
	
	public static TipoOrganizacionFachada getInstance() {
		if(tipoOrganizacionFachada == null)
			return new TipoOrganizacionFachada();
		else
			return tipoOrganizacionFachada;
	}
	
	public List<TipoOrganizacionDTO> obtenerListaDTO(List<TipoOrganizacion> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<TipoOrganizacion> obtenerListaEntity(List<TipoOrganizacionDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	public TipoOrganizacionDTO convertirDTO(TipoOrganizacion entity){
	
		TipoOrganizacionDTO dto = new TipoOrganizacionDTO();
		dto.setId(entity.getId());
		dto.setOrden(entity.getOrden());
		dto.setCodigo(entity.getCodigo());
		dto.setNombre(entity.getNombre());
		
		return dto;
	}
	
	public TipoOrganizacion convertirEntity(TipoOrganizacionDTO dto){
		
		TipoOrganizacion entity = new TipoOrganizacion();
		entity.setId(dto.getId());
		entity.setOrden(dto.getOrden());
		entity.setCodigo(dto.getCodigo());
		entity.setNombre(dto.getNombre());
		
		return entity;
	}
}

/*
private int id;
private int orden;
private String codigo;
private String nombre;		 
	 */
