/**
 * 
 */
package co.org.dane.servicios.modulo1;

import java.util.List;

import co.org.dane.excepciones.EncuestaAnualComercioException;
import co.org.dane.persistencia.entidades.modulo1.CodigoCIIU;
import co.org.dane.persistencia.entidades.modulo1.Departamento;
import co.org.dane.persistencia.entidades.modulo1.EstadoEmpresa;
import co.org.dane.persistencia.entidades.modulo1.Municipio;
import co.org.dane.persistencia.entidades.modulo1.SubTipoOrganizacion;
import co.org.dane.persistencia.entidades.modulo1.TipoCapitalSocial;
import co.org.dane.persistencia.entidades.modulo1.TipoCausa;
import co.org.dane.persistencia.entidades.modulo1.TipoDireccion;
import co.org.dane.persistencia.entidades.modulo1.TipoDocumento;
import co.org.dane.persistencia.entidades.modulo1.TipoIngresosNoOperacionales;
import co.org.dane.persistencia.entidades.modulo1.TipoOperacion;
import co.org.dane.persistencia.entidades.modulo1.TipoOrganizacion;
import co.org.dane.persistencia.entidades.modulo1.TipoRegistroMercantil;
import co.org.dane.persistencia.entidades.modulo1.TipoVariable;

/**
 * @author ALFONSO
 *
 */
public interface IServiciosParametroModulo1 {

	public List<TipoCapitalSocial> findAllTipoCapitalSocial() throws EncuestaAnualComercioException;
	public List<TipoCausa> findAllTipoCausa() throws EncuestaAnualComercioException;
	public List<TipoDireccion> findAllTipoDireccion() throws EncuestaAnualComercioException;
	public List<TipoDocumento> findAllTipoDocumento() throws EncuestaAnualComercioException;
	public List<TipoIngresosNoOperacionales> findAllTipoIngresosNoOperacionales() throws EncuestaAnualComercioException;
	public List<TipoOperacion> findAllTipoOperacion() throws EncuestaAnualComercioException;
	public List<TipoOrganizacion> findAllTipoOrganizacion() throws EncuestaAnualComercioException;
	public List<TipoRegistroMercantil> findAllTipoRegistroMercantil() throws EncuestaAnualComercioException;
	public List<TipoVariable> findAllTipoVariable() throws EncuestaAnualComercioException;
	public List<SubTipoOrganizacion> findSubTipoOrganizacionByIdTipoOrganizacion(int idTipoOrganizacion) throws EncuestaAnualComercioException;
	public List<CodigoCIIU> findCodigoCIIUByIdTipoVariable(int idTipoVariable) throws EncuestaAnualComercioException;
	public List<Departamento> findAllDepartamento() throws EncuestaAnualComercioException;
	public List<Municipio> findMunicipioByIdDepartamento(int idDepartamento) throws EncuestaAnualComercioException;
	public List<EstadoEmpresa> findAllEstadoEmpresa() throws EncuestaAnualComercioException;
}
