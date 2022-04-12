/**
 * 
 */
package co.org.dane.fachada.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import co.org.dane.dto.modulo1.VariableEmpresaDTO;
import co.org.dane.persistencia.entidades.modulo1.CaratulaUnica;
import co.org.dane.persistencia.entidades.modulo1.CodigoCIIU;
import co.org.dane.persistencia.entidades.modulo1.TipoVariable;
import co.org.dane.persistencia.entidades.modulo1.VariableEmpresa;

/**
 * @author ALFONSO
 *
 */
public class VariableEmpresaFachada {

private static VariableEmpresaFachada variableEmpresaFachada;
	
	public static VariableEmpresaFachada getInstance() {
		if(variableEmpresaFachada == null)
			return new VariableEmpresaFachada();
		else
			return variableEmpresaFachada;
	}
	
	
	public List<VariableEmpresaDTO> obtenerListaDTO(List<VariableEmpresa> entities){
		 return CollectionUtils.isEmpty(entities) ? new ArrayList<>()
	                : entities.stream().map(entidad -> convertirDTO(entidad)).collect(Collectors.toList());
	}
	
	
	public List<VariableEmpresa> obtenerListaEntity(List<VariableEmpresaDTO> dtos){
		 return CollectionUtils.isEmpty(dtos) ? new ArrayList<>()
	                : dtos.stream().map(dto -> convertirEntity(dto)).collect(Collectors.toList());
	}
	
	public VariableEmpresaDTO convertirDTO(VariableEmpresa entity){
		
		VariableEmpresaDTO dto = new VariableEmpresaDTO();
		dto.setId(entity.getId());
		dto.setNumeroEstablecimientos(entity.getNumeroEstablecimientos());
		dto.setIngreso(entity.getIngreso());
		dto.setPersonalOcupado(entity.getPersonalOcupado());
		dto.setRemuneracion(entity.getRemuneracion());
		dto.setOtrosCostosGastos(entity.getOtrosCostosGastos());
		dto.setIdSeccion(entity.getSeccion() != null ? entity.getSeccion().getId() : 0);
		dto.setIdCodigoCIIU(entity.getCodigoCIIU() != null ? entity.getCodigoCIIU().getId() : 0);
		dto.setIdCaratulaUnica(entity.getCaratulaUnica() != null ? entity.getCaratulaUnica().getId() : 0);
		
		return dto;
	}
	
	public VariableEmpresa convertirEntity(VariableEmpresaDTO dto){
		
		VariableEmpresa entity = new VariableEmpresa();
		entity.setId(dto.getId());
		entity.setNumeroEstablecimientos(dto.getNumeroEstablecimientos());
		entity.setIngreso(dto.getIngreso());
		entity.setPersonalOcupado(dto.getPersonalOcupado());
		entity.setRemuneracion(dto.getRemuneracion());
		entity.setOtrosCostosGastos(dto.getOtrosCostosGastos());
		
		if(dto.getIdSeccion() != 0) {
			TipoVariable tv = new TipoVariable();
			tv.setId(dto.getIdSeccion());
			entity.setSeccion(tv);
		}
		
		if(dto.getIdCodigoCIIU() != 0) {
			CodigoCIIU cc = new CodigoCIIU();
			cc.setId(dto.getIdCodigoCIIU());
			entity.setCodigoCIIU(cc);
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
private int numeroEstablecimientos;
private long ingreso;
private int personalOcupado;
private long remuneracion;
private long otrosCostosGastos;
private int seccion;
private int idCodigoCIIU;
private long idCaratulaUnica;

*/