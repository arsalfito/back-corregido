/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.IngresosNoOperacionalesDTO;
import co.org.dane.persistencia.entidades.CaratulaUnica;
import co.org.dane.persistencia.entidades.IngresosNoOperacionales;
import co.org.dane.persistencia.entidades.tipos.TipoIngresosNoOperacionales;

/**
 * @author ALFONSO
 *
 */
public class IngresosNoOperacionalesFachada {

	private static IngresosNoOperacionalesFachada ingresosNoOperacionalesFachada;
	
	public static IngresosNoOperacionalesFachada getInstance() {
		if(ingresosNoOperacionalesFachada == null)
			return new IngresosNoOperacionalesFachada();
		else
			return ingresosNoOperacionalesFachada;
	}
	
	
	public List<IngresosNoOperacionalesDTO> obtenerListaDTO(List<IngresosNoOperacionales> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<IngresosNoOperacionales> obtenerListaEntity(List<IngresosNoOperacionalesDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	
	public IngresosNoOperacionalesDTO convertirDTO(IngresosNoOperacionales entity){
		
		IngresosNoOperacionalesDTO dto = new IngresosNoOperacionalesDTO();
		dto.setId(entity.getId());
		dto.setValor(entity.getValor());
		dto.setIdTipoIngresosNoOperacionales(entity.getTipoIngresosNoOperacionales() != null ? entity.getTipoIngresosNoOperacionales().getId() : 0);
		dto.setIdCaratulaUnica(entity.getCaratulaUnica() != null ? entity.getCaratulaUnica().getId() : 0);
		
		return dto;
	}
	
	public IngresosNoOperacionales convertirEntity(IngresosNoOperacionalesDTO dto){
		
		IngresosNoOperacionales entity = new IngresosNoOperacionales();
		entity.setId(dto.getId());
		entity.setValor(dto.getValor());
		
		if(dto.getIdTipoIngresosNoOperacionales() != 0) {
			TipoIngresosNoOperacionales ti = new TipoIngresosNoOperacionales();
			ti.setId(dto.getIdTipoIngresosNoOperacionales());
			entity.setTipoIngresosNoOperacionales(ti);
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
private long id;
private long valor;
private int idTipoIngresosNoOperacionales;
private long idCaratulaUnica;
 */
