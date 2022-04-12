/**
 * 
 */
package co.org.dane.servicios.modulo1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import co.org.dane.persistencia.repositorios.modulo1.RepositorioCodigoCIIU;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioDepartamento;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioEstadoEmpresa;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioMunicipio;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioSubTipoOrganizacion;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioTipoCapitalSocial;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioTipoCausa;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioTipoDireccion;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioTipoDocumento;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioTipoIngresosNoOperacionales;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioTipoOperacion;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioTipoOrganizacion;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioTipoRegistroMercantil;
import co.org.dane.persistencia.repositorios.modulo1.RepositorioTipoVariable;

/**
 * @author ALFONSO
 *
 */
@Service
public class ServiciosParametroModulo1 implements IServiciosParametroModulo1 {

	@Autowired
	private RepositorioTipoCapitalSocial repositorioTipoCapitalSocial;
	
	@Autowired
	private RepositorioTipoCausa repositorioTipoCausa;
	
	@Autowired
	private RepositorioTipoDireccion repositorioTipoDireccion;
	
	@Autowired
	private RepositorioTipoDocumento repositorioTipoDocumento;
	
	@Autowired
	private RepositorioTipoIngresosNoOperacionales repositorioTipoIngresosNoOperacionales;
	
	@Autowired
	private RepositorioTipoOperacion repositorioTipoOperacion;
	
	@Autowired
	private RepositorioTipoOrganizacion repositorioTipoOrganizacion;
	
	@Autowired
	private RepositorioTipoRegistroMercantil repositorioTipoRegistroMercantil;
	
	@Autowired
	private RepositorioTipoVariable repositorioTipoVariable;
	
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
	
	
	@Override
	public List<TipoCapitalSocial> findAllTipoCapitalSocial() throws EncuestaAnualComercioException {
		return this.repositorioTipoCapitalSocial.findAllTipoCapitalSocial();
	}

	@Override
	public List<TipoCausa> findAllTipoCausa() throws EncuestaAnualComercioException {
		return this.repositorioTipoCausa.findAllTipoCausa();
	}

	@Override
	public List<TipoDireccion> findAllTipoDireccion() throws EncuestaAnualComercioException {
		return this.repositorioTipoDireccion.findAllTipoDireccion();
	}

	@Override
	public List<TipoDocumento> findAllTipoDocumento() throws EncuestaAnualComercioException {
		return this.repositorioTipoDocumento.findAllTipoDocumento();
	}

	@Override
	public List<TipoIngresosNoOperacionales> findAllTipoIngresosNoOperacionales()
			throws EncuestaAnualComercioException {
		return this.repositorioTipoIngresosNoOperacionales.findAllTipoIngresosNoOperacionales();
	}

	@Override
	public List<TipoOperacion> findAllTipoOperacion() throws EncuestaAnualComercioException {
		return this.repositorioTipoOperacion.findAllTipoOperacion();
	}

	@Override
	public List<TipoOrganizacion> findAllTipoOrganizacion() throws EncuestaAnualComercioException {
		return this.repositorioTipoOrganizacion.findAllTipoOrganizacion();
	}

	@Override
	public List<TipoRegistroMercantil> findAllTipoRegistroMercantil() throws EncuestaAnualComercioException {
		return this.repositorioTipoRegistroMercantil.findAllTipoRegistroMercantil();
	}

	@Override
	public List<TipoVariable> findAllTipoVariable() throws EncuestaAnualComercioException {
		return this.repositorioTipoVariable.findAllTipoVariable();
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
