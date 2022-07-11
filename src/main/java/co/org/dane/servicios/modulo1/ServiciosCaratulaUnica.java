/**
 * 
 */
package co.org.dane.servicios.modulo1;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.dane.excepciones.EncuestaAnualComercioException;
import co.org.dane.persistencia.entidades.CapitalSocial;
import co.org.dane.persistencia.entidades.CaratulaUnica;
import co.org.dane.persistencia.entidades.Direccion;
import co.org.dane.persistencia.entidades.EstadoEncuesta;
import co.org.dane.persistencia.entidades.EstadoModulos;
import co.org.dane.persistencia.entidades.InformacionFuncionamiento;
import co.org.dane.persistencia.entidades.IngresosNoOperacionales;
import co.org.dane.persistencia.entidades.NovedadEncuesta;
import co.org.dane.persistencia.entidades.Operacion;
import co.org.dane.persistencia.entidades.VariableEmpresa;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioCaratulaUnica;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioDireccion;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioEstadoEncuesta;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioEstadoModulos;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioInformacionFuncionamiento;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioNovedadEncuesta;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioOperacion;
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
	private RepositorioInformacionFuncionamiento repositorioInformacionFuncionamiento;
	
	@Autowired
	private RepositorioNovedadEncuesta repositorioNovedadEncuesta;
	
	@Autowired
	private RepositorioEstadoEncuesta repositorioEstadoEncuesta;
	
	@Autowired
	private RepositorioEstadoModulos repositorioEstadoModulos;
	
	
	
	
	
	@Override
	public CaratulaUnica guardarCaratulaUnica(CaratulaUnica caratulaUnica, String usuario) throws EncuestaAnualComercioException {	
		
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
		return null;
		//return this.repositorioDireccion.findDireccionByIdCaratula(idCaratulaUnica);
	}

	@Override
	public List<CapitalSocial> getCaratulaUnicaCapitalSocial(long idCaratulaUnica)
			throws EncuestaAnualComercioException {
		return null;
		//return this.repositorioCapitalSocial.findCapitalSocialByIdCaratula(idCaratulaUnica);
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
		return null;
		//return this.repositorioIngresosNoOperacionales.findIngresosNoOperacionalesByIdCaratula(idCaratulaUnica);
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
		
		return this.repositorioDireccion.save(direccion);
	}

	@Override
	public CapitalSocial guardarCapitalSocial(CapitalSocial capitalSocial, String usuario) throws EncuestaAnualComercioException {
		
		
		return this.repositorioCapitalSocial.save(capitalSocial);
	}

	@Override
	public Operacion guardarOperacion(Operacion operacion, String usuario) throws EncuestaAnualComercioException {
		
		
		return this.repositorioOperacion.save(operacion);
	}

	@Override
	public VariableEmpresa guardarVariableEmpresa(VariableEmpresa variableEmpresa, String usuario)
			throws EncuestaAnualComercioException {
		
		
		
		return this.repositorioVariableEmpresa.save(variableEmpresa);
	}

	@Override
	public IngresosNoOperacionales guardarIngresosNoOperacionales(IngresosNoOperacionales ingresosNoOperacionales, String usuario)
			throws EncuestaAnualComercioException {
		return null;
		//return this.repositorioIngresosNoOperacionales.save(ingresosNoOperacionales);
	}

	@Override
	public InformacionFuncionamiento guardarInformacionFuncionamiento(
			InformacionFuncionamiento informacionFuncionamiento, String usuario) throws EncuestaAnualComercioException {
		
		return this.repositorioInformacionFuncionamiento.save(informacionFuncionamiento);
	}

	@Override
	public NovedadEncuesta guardarNovedadEncuesta(NovedadEncuesta novedadEncuesta, String usuario)
			throws EncuestaAnualComercioException {
		return this.repositorioNovedadEncuesta.save(novedadEncuesta);
	}

	@Override
	public EstadoEncuesta guardarEstadoEncuesta(EstadoEncuesta estadoEncuesta, String usuario) throws EncuestaAnualComercioException {
		return this.repositorioEstadoEncuesta.save(estadoEncuesta);
	}

	@Override
	public EstadoModulos guardarEstadoModulos(EstadoModulos estadoModulos, String usuario) throws EncuestaAnualComercioException {
		
		
		return this.repositorioEstadoModulos.save(estadoModulos);
	}
	
	@Override
	@Transactional
	public CaratulaUnica guardarCaratulaCompleta(CaratulaUnica caratulaUnica) throws EncuestaAnualComercioException {
		System.out.println("guardarCaratulaCompleta");
		
		//TODO se deben eliminar el capital social si ya existe cuando viene null desde el front
		
		//Gestiona capilat social.
		CapitalSocial cse = null;
		if(caratulaUnica.getCapitalSocialExtranjero()!=null) 
			cse = this.repositorioCapitalSocial.save(caratulaUnica.getCapitalSocialExtranjero());
		caratulaUnica.setCapitalSocialExtranjero(cse);
		
		CapitalSocial csn = null;
		if(caratulaUnica.getCapitalSocialNacional()!=null) 
			csn = this.repositorioCapitalSocial.save(caratulaUnica.getCapitalSocialNacional());
		caratulaUnica.setCapitalSocialNacional(csn);
		
		//Almacena la caratula unica,
		CaratulaUnica result = this.repositorioCaratulaUnica.save(caratulaUnica);
		
		//Almacena las operaaciones.
		List<Operacion> operaciones = (List<Operacion>) caratulaUnica.getOperaciones();
		if(operaciones!=null && !operaciones.isEmpty()){
			int length = operaciones.size();
			IntStream.range(0, length).forEach(index  -> {
				Operacion operacion = operaciones.get(index);
				operacion.setCaratulaUnica(result);
				this.repositorioOperacion.save(operacion);					
			});
		}
		
		return result;
	}
	
}


