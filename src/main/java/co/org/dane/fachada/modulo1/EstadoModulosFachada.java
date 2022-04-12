/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.EstadoModulosDTO;
import co.org.dane.persistencia.entidades.modulo1.CaratulaUnica;
import co.org.dane.persistencia.entidades.modulo1.EstadoModulos;
import co.org.dane.persistencia.entidades.modulo1.Modulo;

/**
 * @author ALFONSO
 *
 */
public class EstadoModulosFachada {

	
private static EstadoModulosFachada estadoModulosFachada;
	
	public static EstadoModulosFachada getInstance() {
		if(estadoModulosFachada == null)
			return new EstadoModulosFachada();
		else
			return estadoModulosFachada;
	}
	
	
	public List<EstadoModulosDTO> obtenerListaDTO(List<EstadoModulos> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<EstadoModulos> obtenerListaEntity(List<EstadoModulosDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	
	public EstadoModulosDTO convertirDTO(EstadoModulos entity){
		
		EstadoModulosDTO dto = new EstadoModulosDTO();
		dto.setId(entity.getId());
		dto.setEstado(entity.getEstado());
		dto.setIdModulo(entity.getModulo() != null ? entity.getModulo().getId(): 0);
		dto.setIdCaratulaUnica(entity.getCaratulaUnica() != null ? entity.getCaratulaUnica().getId(): 0);
		
		return dto;
	}
	
	public EstadoModulos convertirEntity(EstadoModulosDTO dto){
		
		EstadoModulos entity = new EstadoModulos();
		entity.setId(dto.getId());
		entity.setEstado(dto.getEstado());
		
		if(dto.getIdModulo() != 0) {
			Modulo mo = new Modulo();
			mo.setId(dto.getIdModulo());
			entity.setModulo(mo);
		}
		
		if(dto.getIdCaratulaUnica() != 0) {
			CaratulaUnica cu = new CaratulaUnica();
			cu.setId(dto.getIdCaratulaUnica());
			entity.setCaratulaUnica(cu);
		}
		
		return entity;
	}
}

/*
private int id;
private String estado;
private int idModulo;
private long idCaratulaUnica;
 */