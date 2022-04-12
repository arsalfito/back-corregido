/**
 * 
 */
package co.org.dane.servicios.modulo1;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.org.dane.excepciones.EncuestaAnualComercioException;
import co.org.dane.persistencia.entidades.modulo1.CapitalSocial;
import co.org.dane.persistencia.entidades.modulo1.CaratulaUnica;
import co.org.dane.persistencia.entidades.modulo1.Direccion;
import co.org.dane.persistencia.entidades.modulo1.EstadoEncuesta;
import co.org.dane.persistencia.entidades.modulo1.EstadoModulos;
import co.org.dane.persistencia.entidades.modulo1.InformacionFuncionamiento;
import co.org.dane.persistencia.entidades.modulo1.IngresosNoOperacionales;
import co.org.dane.persistencia.entidades.modulo1.NovedadEncuesta;
import co.org.dane.persistencia.entidades.modulo1.Operacion;
import co.org.dane.persistencia.entidades.modulo1.TipoCausa;
import co.org.dane.persistencia.entidades.modulo1.VariableEmpresa;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioCaratulaUnica;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioDireccion;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioEstadoEncuesta;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioEstadoModulos;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioInformacionFuncionamiento;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioIngresosNoOperacionales;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioNovedadEncuesta;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioOperacion;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioTipoCausa;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioVariableEmpresa;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioaCapitalSocial;

/**
 * @author ALFONSO
 *
 */
@Service
public class ServiciosCaratulaUnica implements IServiciosCaratulaUnica {

	@Autowired
	private RepositorioCaratulaUnica repositorioCaratulaUnica;
	
	@Autowired
	private RepositorioDireccion repositorioDireccion;
	
	@Autowired
	private RepositorioaCapitalSocial repositorioCapitalSocial;
	
	@Autowired
	private RepositorioOperacion repositorioOperacion; 
	
	@Autowired
	private RepositorioVariableEmpresa repositorioVariableEmpresa; 
	
	@Autowired
	private RepositorioIngresosNoOperacionales repositorioIngresosNoOperacionales;
	
	@Autowired
	private RepositorioInformacionFuncionamiento repositorioInformacionFuncionamiento;
	
	@Autowired
	private RepositorioNovedadEncuesta repositorioNovedadEncuesta;
	
	@Autowired
	private RepositorioEstadoEncuesta repositorioEstadoEncuesta;
	
	@Autowired
	private RepositorioEstadoModulos repositorioEstadoModulos;
	
	@Autowired
	private RepositorioTipoCausa repositorioTipoCausa;
	
	@Override
	public CaratulaUnica guardarCaratulaUnica(CaratulaUnica caratulaUnica, String usuario) throws EncuestaAnualComercioException {	
		
		if(caratulaUnica.getTipoCausa()!=null){
			TipoCausa tc = this.repositorioTipoCausa.findById( caratulaUnica.getTipoCausa().getId( ) ).get();
			if( tc != null && !tc.isTieneOpcionOtra()) 
				caratulaUnica.setCualOtroEstado("");			
		}
		
		if(caratulaUnica.getId() == 0) {
			caratulaUnica.setFechaCreacion(new Date());
			caratulaUnica.setUsuarioCreacion(usuario);
		}else {
			CaratulaUnica caratulaUnicaDB = this.repositorioCaratulaUnica.findById(caratulaUnica.getId()).get();
			caratulaUnica.setUsuarioCreacion(caratulaUnicaDB.getUsuarioCreacion());
			caratulaUnica.setFechaCreacion(caratulaUnicaDB.getFechaCreacion());
			caratulaUnica.setFechaModificacion(new Date());
			caratulaUnica.setUsuarioModificacion(usuario);
		}
		
		return this.repositorioCaratulaUnica.save(caratulaUnica);
	}

	@Override
	public CaratulaUnica modificarCaratulaUnica(CaratulaUnica caratulaUnica) throws EncuestaAnualComercioException {
		return null;
	}

	@Override
	public CaratulaUnica eliminarCaratulaUnica(CaratulaUnica caratulaUnica) throws EncuestaAnualComercioException {
		return null;
	}

	@Override
	public CaratulaUnica cargarCaratulaUnica(String usuario) throws EncuestaAnualComercioException {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, -1);
		Date fechaInicio = calendar.getTime();
		Date fechaFin = calendar.getTime();
		
		System.out.println("usuario: " +  usuario);
		System.out.println("fecha inicio: " +  fechaInicio);
		System.out.println("fecha final: " +  fechaFin);
		
		return this.repositorioCaratulaUnica.findCaratulaUnicaByUsuarioFechaDesdeFechaHasta(usuario, fechaInicio, fechaFin);
		
	}

	@Override
	public List<Direccion> getCaratulaUnicaDirecciones(long idCaratulaUnica) throws EncuestaAnualComercioException {
		return this.repositorioDireccion.findDireccionByIdCaratula(idCaratulaUnica);
	}

	@Override
	public List<CapitalSocial> getCaratulaUnicaCapitalSocial(long idCaratulaUnica)
			throws EncuestaAnualComercioException {
		return this.repositorioCapitalSocial.findCapitalSocialByIdCaratula(idCaratulaUnica);
	}

	@Override
	public List<Operacion> getCaratulaUnicaOperacion(long idCaratulaUnica) throws EncuestaAnualComercioException {
		return this.repositorioOperacion.findOperacionByIdCaratula(idCaratulaUnica);
	}

	@Override
	public List<VariableEmpresa> getCaratulaUnicaVariableEmpresa(long idCaratulaUnica) throws EncuestaAnualComercioException {
		return this.repositorioVariableEmpresa.findVariableEmpresaByIdCaratula(idCaratulaUnica);
	}

	@Override
	public List<IngresosNoOperacionales> getCaratulaUnicaIngresosNoOperacionales(long idCaratulaUnica)
			throws EncuestaAnualComercioException {
		return this.repositorioIngresosNoOperacionales.findIngresosNoOperacionalesByIdCaratula(idCaratulaUnica);
	}

	@Override
	public InformacionFuncionamiento getCaratulaUnicaInformacionFuncionamiento(long idCaratulaUnica)
			throws EncuestaAnualComercioException {
		return this.repositorioInformacionFuncionamiento.findInformacionFuncionamientoByIdCaratula(idCaratulaUnica);
	}

	@Override
	public List<NovedadEncuesta> getCaratulaUnicaNovedadEncuesta(long idCaratulaUnica)
			throws EncuestaAnualComercioException {
		return this.repositorioNovedadEncuesta.findNovedadEncuestaByIdCaratula(idCaratulaUnica);
	}

	@Override
	public List<EstadoEncuesta> getCaratulaUnicaEstadoEncuesta(long idCaratulaUnica)
			throws EncuestaAnualComercioException {
		return this.repositorioEstadoEncuesta.findEstadoEncuestaByIdCaratula(idCaratulaUnica);
	}

	@Override
	public List<EstadoModulos> getCaratulaUnicaEstadoModulos(long idCaratulaUnica)
			throws EncuestaAnualComercioException {
		return this.repositorioEstadoModulos.findEstadoModulosByIdCaratula(idCaratulaUnica);
	}

	@Override
	public Direccion guardarDireccion(Direccion direccion, String usuario) throws EncuestaAnualComercioException {
		
		if(direccion.getId()==0) {
			direccion.setUsuarioCreacion(usuario);
			direccion.setFechaCreacion(new Date());
		}else {
			Direccion direccionDB = this.repositorioDireccion.getById(direccion.getId());
			direccion.setUsuarioCreacion(direccionDB.getUsuarioCreacion());
			direccion.setFechaCreacion(direccionDB.getFechaCreacion());
			direccion.setUsuarioModificacion(usuario);
			direccion.setFechaModificacion(new Date());
		}
		
		return this.repositorioDireccion.save(direccion);
	}

	@Override
	public CapitalSocial guardarCapitalSocial(CapitalSocial capitalSocial, String usuario) throws EncuestaAnualComercioException {
		
		if(capitalSocial.getId()==0){
			capitalSocial.setUsuarioCreacion(usuario);
			capitalSocial.setFechaCreacion(new Date());
		}else{
			CapitalSocial capitalSocialDB = this.repositorioCapitalSocial.findById(capitalSocial.getId()).get();
			capitalSocial.setUsuarioCreacion(capitalSocialDB.getUsuarioCreacion());
			capitalSocial.setFechaCreacion(capitalSocialDB.getFechaCreacion());
			capitalSocial.setUsuarioModificacion(usuario);
			capitalSocial.setFechaModificacion(new Date());
		}
		
		return this.repositorioCapitalSocial.save(capitalSocial);
	}

	@Override
	public Operacion guardarOperacion(Operacion operacion, String usuario) throws EncuestaAnualComercioException {
		
		if(operacion.getId()==0){
			operacion.setUsuarioCreacion(usuario);
			operacion.setFechaCreacion(new Date());
		}else{
			Operacion operacionDB = this.repositorioOperacion.findById(operacion.getId()).get();
			operacion.setUsuarioCreacion(operacionDB.getUsuarioCreacion());
			operacion.setFechaCreacion(operacionDB.getFechaCreacion());
			operacion.setUsuarioModificacion(usuario);
			operacion.setFechaModificacion(new Date());
		}
		
		return this.repositorioOperacion.save(operacion);
	}

	@Override
	public VariableEmpresa guardarVariableEmpresa(VariableEmpresa variableEmpresa, String usuario)
			throws EncuestaAnualComercioException {
		
		if(variableEmpresa.getId()==0){
			variableEmpresa.setUsuarioCreacion(usuario);
			variableEmpresa.setFechaCreacion(new Date());
		}else {
			VariableEmpresa variableEmpresaDB = this.repositorioVariableEmpresa.findById(variableEmpresa.getId()).get();
			variableEmpresa.setUsuarioCreacion(variableEmpresaDB.getUsuarioCreacion());
			variableEmpresa.setFechaCreacion(variableEmpresaDB.getFechaCreacion());
			variableEmpresa.setUsuarioModificacion(usuario);
			variableEmpresa.setFechaModificacion(new Date());
		}
		
		
		return this.repositorioVariableEmpresa.save(variableEmpresa);
	}

	@Override
	public IngresosNoOperacionales guardarIngresosNoOperacionales(IngresosNoOperacionales ingresosNoOperacionales, String usuario)
			throws EncuestaAnualComercioException {
		
		if(ingresosNoOperacionales.getId()==0){
			ingresosNoOperacionales.setUsuarioCreacion(usuario);
			ingresosNoOperacionales.setFechaCreacion(new Date());
		}else{
			IngresosNoOperacionales ingresosNoOperacionalesDB = this.repositorioIngresosNoOperacionales.findById(ingresosNoOperacionales.getId()).get();
			ingresosNoOperacionales.setUsuarioCreacion(ingresosNoOperacionalesDB.getUsuarioCreacion());
			ingresosNoOperacionales.setFechaCreacion(ingresosNoOperacionalesDB.getFechaCreacion());
			ingresosNoOperacionales.setUsuarioModificacion(usuario);
			ingresosNoOperacionales.setFechaModificacion(new Date());
		}
		
		return this.repositorioIngresosNoOperacionales.save(ingresosNoOperacionales);
	}

	@Override
	public InformacionFuncionamiento guardarInformacionFuncionamiento(
			InformacionFuncionamiento informacionFuncionamiento, String usuario) throws EncuestaAnualComercioException {
		
		if(informacionFuncionamiento.getId()==0) {
			informacionFuncionamiento.setUsuarioCreacion(usuario);
			informacionFuncionamiento.setFechaCreacion(new Date());
		}else{
			InformacionFuncionamiento informacionFuncionamientoDB = this.repositorioInformacionFuncionamiento.findById(informacionFuncionamiento.getId()).get();
			informacionFuncionamiento.setUsuarioCreacion(informacionFuncionamientoDB.getUsuarioCreacion());
			informacionFuncionamiento.setFechaCreacion(informacionFuncionamientoDB.getFechaCreacion());
			informacionFuncionamiento.setUsuarioModificacion(usuario);
			informacionFuncionamiento.setFechaModificacion(new Date());
		}
		
		return this.repositorioInformacionFuncionamiento.save(informacionFuncionamiento);
	}

	@Override
	public NovedadEncuesta guardarNovedadEncuesta(NovedadEncuesta novedadEncuesta, String usuario)
			throws EncuestaAnualComercioException {
		
		if(novedadEncuesta.getId()==0) {
			novedadEncuesta.setUsuarioCreacion(usuario);
			novedadEncuesta.setFechaCreacion(new Date());
		}else {
			NovedadEncuesta novedadEncuestaDB = this.repositorioNovedadEncuesta.findById(novedadEncuesta.getId()).get();
			novedadEncuesta.setUsuarioCreacion(novedadEncuestaDB.getUsuarioCreacion());
			novedadEncuesta.setFechaCreacion(novedadEncuestaDB.getFechaCreacion());
			novedadEncuesta.setUsuarioModificacion(usuario);
			novedadEncuesta.setFechaModificacion(new Date());
		}
		
		return this.repositorioNovedadEncuesta.save(novedadEncuesta);
	}

	@Override
	public EstadoEncuesta guardarEstadoEncuesta(EstadoEncuesta estadoEncuesta, String usuario) throws EncuestaAnualComercioException {
		
		if(estadoEncuesta.getId()==0) {
			estadoEncuesta.setUsuarioCreacion(usuario);
			estadoEncuesta.setFechaCreacion(new Date());
		}else {
			EstadoEncuesta estadoEncuestaDB = this.repositorioEstadoEncuesta.findById(estadoEncuesta.getId()).get();
			estadoEncuesta.setUsuarioCreacion(estadoEncuestaDB.getUsuarioCreacion());
			estadoEncuesta.setFechaCreacion(estadoEncuestaDB.getFechaCreacion());
			estadoEncuesta.setUsuarioModificacion(usuario);
			estadoEncuesta.setFechaModificacion(new Date());
			
		}
		
		return this.repositorioEstadoEncuesta.save(estadoEncuesta);
	}

	@Override
	public EstadoModulos guardarEstadoModulos(EstadoModulos estadoModulos, String usuario) throws EncuestaAnualComercioException {
		
		if(estadoModulos.getId()==0) {
			estadoModulos.setUsuarioCreacion(usuario);
			estadoModulos.setFechaCreacion(new Date());
		}else {
			EstadoModulos estadoModulosDB = this.repositorioEstadoModulos.findById(estadoModulos.getId()).get();
			estadoModulos.setUsuarioCreacion(estadoModulosDB.getUsuarioCreacion());
			estadoModulos.setFechaCreacion(estadoModulosDB.getFechaCreacion());
			estadoModulos.setUsuarioModificacion(usuario);
			estadoModulos.setFechaModificacion(new Date());
		}
		
		return this.repositorioEstadoModulos.save(estadoModulos);
	}
	
}


