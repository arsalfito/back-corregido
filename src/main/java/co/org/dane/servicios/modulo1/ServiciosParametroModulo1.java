/**
 * 
 */
package co.org.dane.servicios.modulo1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.org.dane.excepciones.EncuestaAnualComercioException;
import co.org.dane.persistencia.entidades.CodigoCIIU;
import co.org.dane.persistencia.entidades.Departamento;
import co.org.dane.persistencia.entidades.EstadoEmpresa;
import co.org.dane.persistencia.entidades.Municipio;
import co.org.dane.persistencia.entidades.SubTipoOrganizacion;
import co.org.dane.persistencia.entidades.tipos.TipoCausa;
import co.org.dane.persistencia.entidades.tipos.TipoIngresosNoOperacionales;
import co.org.dane.persistencia.entidades.tipos.TipoOrganizacion;
import co.org.dane.persistencia.entidades.tipos.TipoVariable;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioCodigoCIIU;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioDepartamento;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioEstadoEmpresa;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioMunicipio;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioSubTipoOrganizacion;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioTipoIngresosNoOperacionales;

/**
 * @author ALFONSO
 *
 */
@Service
public class ServiciosParametroModulo1 implements IServiciosParametroModulo1 {

	/*@Autowired
	private RepositorioTipoCapitalSocial repositorioTipoCapitalSocial;*/
	
	
	/*@Autowired
	private RepositorioTipoDireccion repositorioTipoDireccion;*/
	
	/*@Autowired
	private RepositorioTipoDocumento repositorioTipoDocumento;*/
	
	@Autowired
	private RepositorioTipoIngresosNoOperacionales repositorioTipoIngresosNoOperacionales;
	
	/*@Autowired
	private RepositorioTipoOperacion repositorioTipoOperacion;*/
	
	
	/*@Autowired
	private RepositorioTipoRegistroMercantil repositorioTipoRegistroMercantil;*/
	
	
	@Autowired
	private RepositorioSubTipoOrganizacion repositorioSubTipoOrganizacion;
	
	@Autowired
	private RepositorioCodigoCIIU repositorioCodigoCIIU;
	
	@Autowired
	private RepositorioDepartamento repositorioDepartamento;
	
	@Autowired
	private RepositorioMunicipio repositorioMunicipio;
	
	@Autowired
	private RepositorioEstadoEmpresa repositorioEstadoEmpresa;
	
	
	/*@Override
	public List<TipoCapitalSocial> findAllTipoCapitalSocial() throws EncuestaAnualComercioException {
		return this.repositorioTipoCapitalSocial.findAllTipoCapitalSocial();
	}*/

	@Override
	public List<TipoCausa> findAllTipoCausa() throws EncuestaAnualComercioException {
		return null;
		//return this.repositorioTipoCausa.findAllTipoCausa();
	}

	/*@Override
	public List<TipoDireccion> findAllTipoDireccion() throws EncuestaAnualComercioException {
		return this.repositorioTipoDireccion.findAllTipoDireccion();
	}*/

	/*@Override
	public List<TipoDocumento> findAllTipoDocumento() throws EncuestaAnualComercioException {
		return this.repositorioTipoDocumento.findAllTipoDocumento();
	}*/

	@Override
	public List<TipoIngresosNoOperacionales> findAllTipoIngresosNoOperacionales()
			throws EncuestaAnualComercioException {
		return this.repositorioTipoIngresosNoOperacionales.findAllTipoIngresosNoOperacionales();
	}

	/*@Override
	public List<TipoOperacion> findAllTipoOperacion() throws EncuestaAnualComercioException {
		return this.repositorioTipoOperacion.findAllTipoOperacion();
	}*/

	@Override
	public List<TipoOrganizacion> findAllTipoOrganizacion() throws EncuestaAnualComercioException {
		return null;
		//return this.repositorioTipoOrganizacion.findAllTipoOrganizacion();
	}

	/*@Override
	public List<TipoRegistroMercantil> findAllTipoRegistroMercantil() throws EncuestaAnualComercioException {
		return this.repositorioTipoRegistroMercantil.findAllTipoRegistroMercantil();
	}*/

	@Override
	public List<TipoVariable> findAllTipoVariable() throws EncuestaAnualComercioException {
		return null;
		//return this.repositorioTipoVariable.findAllTipoVariable();
	}

	@Override
	public List<SubTipoOrganizacion> findSubTipoOrganizacionByIdTipoOrganizacion(int idTipoOrganizacion)
			throws EncuestaAnualComercioException {
		return this.repositorioSubTipoOrganizacion.findSubTipoOrganizacionByIdTipoOrganizacion(idTipoOrganizacion);
	}

	@Override
	public List<CodigoCIIU> findCodigoCIIUByIdTipoVariable(int idTipoVariable) throws EncuestaAnualComercioException {
		return this.repositorioCodigoCIIU.findCodigoCIIUByIdTipoVariable(idTipoVariable);
	}

	@Override
	public List<Departamento> findAllDepartamento() throws EncuestaAnualComercioException {
		return this.repositorioDepartamento.findAllDepartamento();
	}

	@Override
	public List<Municipio> findMunicipioByIdDepartamento(int idDepartamento) throws EncuestaAnualComercioException {
		return this.repositorioMunicipio.findMunicipioByIdDepartamento(idDepartamento);
	}

	@Override
	public List<EstadoEmpresa> findAllEstadoEmpresa() throws EncuestaAnualComercioException {
		return this.repositorioEstadoEmpresa.findAll();
	}

}
