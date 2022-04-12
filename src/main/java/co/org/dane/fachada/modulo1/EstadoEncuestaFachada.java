/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.EstadoEncuestaDTO;
import co.org.dane.persistencia.entidades.modulo1.CaratulaUnica;
import co.org.dane.persistencia.entidades.modulo1.EstadoEncuesta;

/**
 * @author ALFONSO
 *
 */
public class EstadoEncuestaFachada {
	
private static EstadoEncuestaFachada estadoEncuestaFachada;
	
	public static EstadoEncuestaFachada getInstance() {
		if(estadoEncuestaFachada == null)
			return new EstadoEncuestaFachada();
		else
			return estadoEncuestaFachada;
	}
	
	
	public List<EstadoEncuestaDTO> obtenerListaDTO(List<EstadoEncuesta> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<EstadoEncuesta> obtenerListaEntity(List<EstadoEncuestaDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	
	public EstadoEncuestaDTO convertirDTO(EstadoEncuesta entity){
		
		EstadoEncuestaDTO dto = new EstadoEncuestaDTO();
		dto.setId(entity.getId());
		dto.setCodigo(entity.getCodigo());
		dto.setNombre(entity.getNombre());
		dto.setFechaInicio(entity.getFechaInicio());
		dto.setFechaFin(entity.getFechaFin());
		dto.setActivo(entity.getActivo());
		dto.setIdCaratulaUnica(entity.getCaratulaUnica() != null ? entity.getCaratulaUnica().getId() : 0);
		
		return dto;
	}
	
	public EstadoEncuesta convertirEntity(EstadoEncuestaDTO dto){
		
		EstadoEncuesta entity = new EstadoEncuesta();
		entity.setId(dto.getId());
		entity.setCodigo(dto.getCodigo());
		entity.setNombre(dto.getNombre());
		entity.setFechaInicio(dto.getFechaInicio());
		entity.setFechaFin(dto.getFechaFin());
		entity.setActivo(dto.getActivo());
		
		if(dto.getIdCaratulaUnica() !=0 ) {
			CaratulaUnica cu = new CaratulaUnica();
			cu.setId(dto.getIdCaratulaUnica());
			entity.setCaratulaUnica(cu);
		}
		return entity;
	}

}
/*
 private long id;
	private int codigo;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private String activo;
	private long idCaratulaUnica;
*/
