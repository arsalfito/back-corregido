/**
 * 
 */
package co.org.dane.servicios.modulo1;

import java.util.List;

import co.org.dane.excepciones.EncuestaAnualComercioException;
import co.org.dane.persistencia.entidades.CodigoCIIU;
import co.org.dane.persistencia.entidades.Departamento;
import co.org.dane.persistencia.entidades.EstadoEmpresa;
import co.org.dane.persistencia.entidades.Municipio;
import co.org.dane.persistencia.entidades.tipos.SubTipoOrganizacion;
import co.org.dane.persistencia.entidades.tipos.TipoCausa;
import co.org.dane.persistencia.entidades.tipos.TipoIngresosNoOperacionales;
import co.org.dane.persistencia.entidades.tipos.TipoOrganizacion;
import co.org.dane.persistencia.entidades.tipos.TipoVariable;

/**
 * @author ALFONSO
 *
 */
public interface IServiciosParametroModulo1 {

	//public List<TipoCapitalSocial> findAllTipoCapitalSocial() throws EncuestaAnualComercioException;
	public List<TipoCausa> findAllTipoCausa() throws EncuestaAnualComercioException;
	//public List<TipoDireccion> findAllTipoDireccion() throws EncuestaAnualComercioException;
	//public List<TipoDocumento> findAllTipoDocumento() throws EncuestaAnualComercioException;
	public List<TipoIngresosNoOperacionales> findAllTipoIngresosNoOperacionales() throws EncuestaAnualComercioException;
	//public List<TipoOperacion> findAllTipoOperacion() throws EncuestaAnualComercioException;
	public List<TipoOrganizacion> findAllTipoOrganizacion() throws EncuestaAnualComercioException;
	//public List<TipoRegistroMercantil> findAllTipoRegistroMercantil() throws EncuestaAnualComercioException;
	public List<TipoVariable> findAllTipoVariable() throws EncuestaAnualComercioException;
	public List<SubTipoOrganizacion> findSubTipoOrganizacionByIdTipoOrganizacion(int idTipoOrganizacion) throws EncuestaAnualComercioException;
	public List<CodigoCIIU> findCodigoCIIUByIdTipoVariable(int idTipoVariable) throws EncuestaAnualComercioException;
	public List<Departamento> findAllDepartamento() throws EncuestaAnualComercioException;
	public List<Municipio> findMunicipioByIdDepartamento(int idDepartamento) throws EncuestaAnualComercioException;
	public List<EstadoEmpresa> findAllEstadoEmpresa() throws EncuestaAnualComercioException;
}
