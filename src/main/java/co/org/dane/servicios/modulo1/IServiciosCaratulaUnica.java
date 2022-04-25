/**
 * 
 */
package co.org.dane.servicios.modulo1;

import java.util.List;

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

/**
 * @author ALFONSO
 *
 */
public interface IServiciosCaratulaUnica {

	public CaratulaUnica guardarCaratulaUnica(CaratulaUnica caratulaUnica, String usuario) throws EncuestaAnualComercioException;
	public CaratulaUnica modificarCaratulaUnica(CaratulaUnica caratulaUnica) throws EncuestaAnualComercioException;
	public CaratulaUnica eliminarCaratulaUnica(CaratulaUnica caratulaUnica) throws EncuestaAnualComercioException;
	public CaratulaUnica cargarCaratulaUnica(String usuario) throws EncuestaAnualComercioException;
	
	//Cargar datos que hacen parte de la caratula Unica.
	public List<Direccion> getCaratulaUnicaDirecciones(long idCaratulaUnica) throws EncuestaAnualComercioException;
	public List<CapitalSocial> getCaratulaUnicaCapitalSocial(long idCaratulaUnica) throws EncuestaAnualComercioException;
	public List<Operacion> getCaratulaUnicaOperacion(long idCaratulaUnica) throws EncuestaAnualComercioException;
	public List<VariableEmpresa> getCaratulaUnicaVariableEmpresa(long idCaratulaUnica) throws EncuestaAnualComercioException;
	public List<IngresosNoOperacionales> getCaratulaUnicaIngresosNoOperacionales(long idCaratulaUnica) throws EncuestaAnualComercioException;
	public InformacionFuncionamiento getCaratulaUnicaInformacionFuncionamiento(long idCaratulaUnica) throws EncuestaAnualComercioException;
	public List<NovedadEncuesta> getCaratulaUnicaNovedadEncuesta(long idCaratulaUnica) throws EncuestaAnualComercioException;
	public List<EstadoEncuesta> getCaratulaUnicaEstadoEncuesta(long idCaratulaUnica) throws EncuestaAnualComercioException;
	public List<EstadoModulos> getCaratulaUnicaEstadoModulos(long idCaratulaUnica) throws EncuestaAnualComercioException;
	
	//Crear y modificar Datos que hacen parte de la caratula unica.
	public Direccion guardarDireccion(Direccion direccion, String usuario) throws EncuestaAnualComercioException;
	public CapitalSocial guardarCapitalSocial(CapitalSocial capitalSocial, String usuario) throws EncuestaAnualComercioException;
	public Operacion guardarOperacion(Operacion operacion, String usuario) throws EncuestaAnualComercioException;
	public VariableEmpresa guardarVariableEmpresa(VariableEmpresa variableEmpresa, String usuario) throws EncuestaAnualComercioException;
	public IngresosNoOperacionales guardarIngresosNoOperacionales(IngresosNoOperacionales ingresosNoOperacionales, String usuario) throws EncuestaAnualComercioException;
	public InformacionFuncionamiento guardarInformacionFuncionamiento(InformacionFuncionamiento informacionFuncionamiento, String usuario) throws EncuestaAnualComercioException;
	public NovedadEncuesta guardarNovedadEncuesta(NovedadEncuesta novedadEncuesta, String usuario) throws EncuestaAnualComercioException;
	public EstadoEncuesta guardarEstadoEncuesta(EstadoEncuesta estadoEncuesta, String usuario) throws EncuestaAnualComercioException;
	public EstadoModulos guardarEstadoModulos(EstadoModulos estadoModulos, String usuario) throws EncuestaAnualComercioException;
	
}
