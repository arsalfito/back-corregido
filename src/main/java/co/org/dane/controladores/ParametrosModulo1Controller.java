/**
 * 
 */
package co.org.dane.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.org.dane.dto.modulo1.CodigoCIIUDTO;
import co.org.dane.dto.modulo1.DepartamentoDTO;
import co.org.dane.dto.modulo1.MunicipioDTO;
import co.org.dane.dto.modulo1.SubTipoOrganizacionDTO;
import co.org.dane.dto.modulo1.TipoOrganizacionDTO;
import co.org.dane.dto.modulo1.TipoVariableDTO;
import co.org.dane.fachada.modulo1.CodigoCIIUFachada;
import co.org.dane.fachada.modulo1.DepartamentoFachada;
import co.org.dane.fachada.modulo1.MunicipioFachada;
import co.org.dane.fachada.modulo1.SubTipoOrganizacionFachada;
import co.org.dane.fachada.modulo1.TipoOrganizacionFachada;
import co.org.dane.fachada.modulo1.TipoVariableFachada;
import co.org.dane.persistencia.entidades.CodigoCIIU;
import co.org.dane.persistencia.entidades.Departamento;
import co.org.dane.persistencia.entidades.EstadoEmpresa;
import co.org.dane.persistencia.entidades.Municipio;
import co.org.dane.persistencia.entidades.SubTipoOrganizacion;
import co.org.dane.persistencia.entidades.tipos.TipoCausa;
import co.org.dane.persistencia.entidades.tipos.TipoIngresosNoOperacionales;
import co.org.dane.persistencia.entidades.tipos.TipoOrganizacion;
import co.org.dane.persistencia.entidades.tipos.TipoVariable;
import co.org.dane.servicios.modulo1.IServiciosParametroModulo1;
import co.org.dane.springjwt.security.jwt.JwtUtils;


/**
 * @author ALFONSO
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/modulo1")
public class ParametrosModulo1Controller {
	
	@Autowired
	private IServiciosParametroModulo1 serviciosParametroModulo1;
	
	@Autowired
	private JwtUtils jwtUtils;

	/*@GetMapping(path = "/getAllTipoCapitalSocial/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoCapitalSocial>> getAllTipoCapitalSocial(){
		
		try {
			List<TipoCapitalSocial> tiposCapitalSocial = this.serviciosParametroModulo1.findAllTipoCapitalSocial();
			return ResponseEntity.status(HttpStatus.OK).body(tiposCapitalSocial);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}*/
	
	@GetMapping(path = "/getAllTipoCausa/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoCausa>> getAllTipoCausa(){
		try {
			List<TipoCausa> tiposCausa = this.serviciosParametroModulo1.findAllTipoCausa();
			return ResponseEntity.status(HttpStatus.OK).body(tiposCausa);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/*@GetMapping(path = "/getAllTipoDireccion/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoDireccion>> getAllTipoDireccion(){
		try {
			List<TipoDireccion> tiposDireccion = this.serviciosParametroModulo1.findAllTipoDireccion();
			return ResponseEntity.status(HttpStatus.OK).body(tiposDireccion);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}*/
	
	/*@GetMapping(path = "/getAllTipoDocumento/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoDocumento>> getAllTipoDocumento(){
		try {
			List<TipoDocumento> tiposDocumento = this.serviciosParametroModulo1.findAllTipoDocumento();
			return ResponseEntity.status(HttpStatus.OK).body(tiposDocumento);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}*/
	
	@GetMapping(path = "/getAllTipoIngresosNoOperacionales/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoIngresosNoOperacionales>> getAllTipoIngresosNoOperacionales(){
		try {
			List<TipoIngresosNoOperacionales> tiposIngresosNoOperacionales = this.serviciosParametroModulo1.findAllTipoIngresosNoOperacionales();
			return ResponseEntity.status(HttpStatus.OK).body(tiposIngresosNoOperacionales);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/*@GetMapping(path = "/getAllTipoOperacion/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoOperacion>> getAllTipoOperacion(){
		try {
			List<TipoOperacion> tiposOperacion = this.serviciosParametroModulo1.findAllTipoOperacion();
			return ResponseEntity.status(HttpStatus.OK).body(tiposOperacion);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}*/
	
	@GetMapping(path = "/getAllTipoOrganizacion/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoOrganizacionDTO>> getAllTipoOrganizacion(){
		try {
			List<TipoOrganizacion> tiposOrganizacion = this.serviciosParametroModulo1.findAllTipoOrganizacion();
			return ResponseEntity.status(HttpStatus.OK).body(TipoOrganizacionFachada.getInstance().obtenerListaDTO(tiposOrganizacion));
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/*@GetMapping(path = "/getAllTipoRegistroMercantil/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoRegistroMercantil>> getAllTipoRegistroMercantil(){
		try {
			List<TipoRegistroMercantil> tiposRegistroMercantil = this.serviciosParametroModulo1.findAllTipoRegistroMercantil();
			return ResponseEntity.status(HttpStatus.OK).body(tiposRegistroMercantil);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}*/
	
	@GetMapping(path = "/getAllTipoVariable/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoVariableDTO>> getAllTipoVariable(@RequestHeader("Authorization") String token){
		try {
			System.out.println("token: " + token);
			System.out.println("token: " + jwtUtils.getUserNameFromJwtToken(token.substring(6)));
			
			List<TipoVariable> tiposVariable = this.serviciosParametroModulo1.findAllTipoVariable();
			return ResponseEntity.status(HttpStatus.OK).body(TipoVariableFachada.getInstance().obtenerListaDTO(tiposVariable));
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(path = "/findSubTipoOrganizacionByIdTipoOrganizacion/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubTipoOrganizacionDTO>> findSubTipoOrganizacionByIdTipoOrganizacion(@RequestParam("idTipoOrganizacion") int idTipoOrganizacion){
		try {
			List<SubTipoOrganizacion> subTiposOrganizacion = this.serviciosParametroModulo1.findSubTipoOrganizacionByIdTipoOrganizacion(idTipoOrganizacion);
			return ResponseEntity.status(HttpStatus.OK).body(SubTipoOrganizacionFachada.getInstance().obtenerListaDTO(subTiposOrganizacion));
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping(path = "/findCodigoCIIUByIdTipoVariable/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CodigoCIIUDTO>> findCodigoCIIUByIdTipoVariable(@RequestParam("idTipoVariable") int idTipoVariable){
		try {
			List<CodigoCIIU> codigosCIIU = this.serviciosParametroModulo1.findCodigoCIIUByIdTipoVariable(idTipoVariable);
			return ResponseEntity.status(HttpStatus.OK).body(CodigoCIIUFachada.getInstance().obtenerListaDTO(codigosCIIU));
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(path = "/findAllDepartamento/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DepartamentoDTO>> findAllDepartamento(){
		try {
			List<Departamento> departamentos = this.serviciosParametroModulo1.findAllDepartamento();
			return ResponseEntity.status(HttpStatus.OK).body(DepartamentoFachada.getInstance().obtenerListaDTO(departamentos));
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping(path = "/findMunicipioByIdDepartamento/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MunicipioDTO>> findMunicipioByIdDepartamento(@RequestParam("idDepartamento") int idDepartamento){
		try {
			List<Municipio> municipios = this.serviciosParametroModulo1.findMunicipioByIdDepartamento(idDepartamento);
			return ResponseEntity.status(HttpStatus.OK).body(MunicipioFachada.getInstance().obtenerListaDTO(municipios));
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping(path = "/findAllEstadoEmpresa/", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstadoEmpresa>> findAllEstadoEmpresa(){
		try {
			List<EstadoEmpresa> estados = this.serviciosParametroModulo1.findAllEstadoEmpresa();
			return ResponseEntity.status(HttpStatus.OK).body(estados);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
