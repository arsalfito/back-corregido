/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.OperacionDTO;
import co.org.dane.persistencia.entidades.modulo1.CaratulaUnica;
import co.org.dane.persistencia.entidades.modulo1.Operacion;
import co.org.dane.persistencia.entidades.modulo1.TipoOperacion;

/**
 * @author ALFONSO
 *
 */
public class OperacionFachada {

	private static OperacionFachada operacionFachada;
	
	public static OperacionFachada getInstance() {
		if(operacionFachada == null)
			return new OperacionFachada();
		else
			return operacionFachada;
	}
	
	
	public List<OperacionDTO> obtenerListaDTO(List<Operacion> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<Operacion> obtenerListaEntity(List<OperacionDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	public OperacionDTO convertirDTO(Operacion entity){
		
		OperacionDTO dto = new OperacionDTO();
		dto.setId(entity.getId());
		dto.setBienes(entity.getBienes());
		dto.setServicios(entity.getServicios());
		dto.setNinguna(entity.getNinguna());
		dto.setIdTipoOperacion(entity.getTipoOperacion() != null ? entity.getTipoOperacion().getId() : 0);
		dto.setIdCaratulaUnica(entity.getCaratulaUnica() != null ? entity.getCaratulaUnica().getId() : 0);
		
		return dto;
	}
	
	public Operacion convertirEntity(OperacionDTO dto){
		
		Operacion entity = new Operacion();
		entity.setId(dto.getId());
		entity.setBienes(dto.getBienes());
		entity.setServicios(dto.getServicios());
		entity.setNinguna(dto.getNinguna());
		
		if(dto.getIdTipoOperacion()!=0){
			TipoOperacion to = new TipoOperacion();
			to.setId(dto.getIdTipoOperacion());
			entity.setTipoOperacion(to);
		}
		
		if(dto.getIdCaratulaUnica()!=0){
			CaratulaUnica cu = new CaratulaUnica();
			cu.setId(dto.getIdCaratulaUnica());
			entity.setCaratulaUnica(cu);
		}
		
		return entity;
	}
	
}
/*
private long id;
private int bienes;
private int servicios;
private int ninguna;
private int idTipoOperacion;
private long idCaratulaUnica;
*/