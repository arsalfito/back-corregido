/**
 * 
 */
package co.org.dane.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.org.dane.persistencia.entidades.enumeraciones.ETipoDocumento;
import co.org.dane.persistencia.entidades.enumeraciones.ETipoRegistroMercantil;
import co.org.dane.persistencia.entidades.tipos.CausasOperacion;
import co.org.dane.persistencia.entidades.tipos.SubTipoOrganizacion;
import co.org.dane.persistencia.entidades.tipos.TipoOrganizacion;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ALFONSO
 *
 */
@Entity
@Table(name = "EAC_CARATULA_UNICA")
@Setter
@Getter
//@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class CaratulaUnica implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SeqCaratulaUnica" )
	@SequenceGenerator( name = "SeqCaratulaUnica", sequenceName = "SEQ_CARATULA_UNICA", initialValue = 1, allocationSize = 1 )
	@Column( name = "ID_CARATULA_UNICA_PK", nullable = false )
	private long id;
	
	//IDNOREMP Número de orden, identificación de cada empresa en el directorio 
	@Column( name = "NUMERO_ORDEN", nullable = false, updatable = true, length = 6 )
	private int numeroOrden;//ok
	
	//IDNITCC NIT 
	@Column( name = "NUMERO_DOCUMENTO", nullable = false, updatable = true, length = 10 )
	private long numeroDocumento;//ok
	
	//IDDV Dígito de verificación 
	@Column( name = "DIGITO_VERIFICACION", nullable = false, updatable = true, length = 1 )
	private byte digitoVerificacion;//ok
	
	//IDCAMA Registro de cámara 
	@Column( name = "NUMERO_CAMARA", nullable = true, updatable = true, length = 3 )
	private int numeroCamara;//ok
	
	//IDREG Registro mercantil
	@Column( name = "NUMERO_REGISTRO", nullable = true, updatable = true, length = 11 )
	private long numeroRegistro;//ok	
	
	//IDPRORAZ Razón social de la empresa
	@Column( name = "RAZON_SOCIAL", nullable = false, updatable = true, length = 80 )
	private String razonSocial;
	
	//IDIGG Localización georeferenciada de la gerencia (código asignado por georefenciación - LGGR)
	@Column( name = "GEOREFERENCIA_GERENCIA", nullable = false, updatable = true, length = 11 )
	private double georeferenciaGerecia;
	
	//IDNOMCOM Nombre comercial
	@Column( name = "NOMBRE_COMERCIAL", nullable = false, updatable = true, length = 80 )
	private String nombreComercial;
	
	//IDSIGLA Sigla
	@Column( name = "SIGLA", nullable = true, updatable = true, length = 10 )
	private String sigla;
	
	//IDWEB Página Web 
	@Column( name = "PAGINA_WEB", nullable = true, updatable = true, length = 40 )
	private String paginaWeb;
	
	//IDIGG Localización georeferenciada de la gerencia (código asignado por georefenciación - LGGR)
	@Column( name = "GEOREFERENCIA_NOTIFICACION", nullable = false, updatable = true, length = 11 )
	private double georeferenciaNotificacion;
	
	@Column( name = "CUAL_TIPO_ORGANIZACION", nullable = true, updatable = true, length = 30 )
	private String cualTipoOrgaizacion;
	
	//IDFEINI Fecha inicio operaciones
	@Column( name = "FECHA_CONSTITUCION_DESDE", nullable = true, updatable = true )
	private Date fechaConstitucionDesde;
	
	//IDFECIE Fecha terminación operaciones
	@Column( name = "FECHA_CONSTITUCION_HASTA", nullable = true, updatable = true )
	private Date fechaConstitucionHasta;
	
	@Column( name = "CUAL_OTRO_ESTADO", nullable = true, updatable = true, length = 30 )
	private String cualOtroEstado;
	
	@Column( name = "NUMERO_UNIDADES_APOYO", nullable = true, updatable = true, length = 5 )
	private String numeroUnidadesApoyo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DIRECTORIO_FK", nullable = false, updatable = true)
	private Directorio directorio;
	
	//----------------------------------------
	//Relaciones con las entidaes de Modulo 1
	//----------------------------------------
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private ETipoDocumento tipoDocumento;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 25)
	private ETipoRegistroMercantil tipoRegistroMercantil;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_ORGANIZACION_FK", nullable = true, updatable = true)
	private TipoOrganizacion tipoOrganizacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SUC_TIPO_ORGANIZACION_FK", nullable = true, updatable = true)
	private SubTipoOrganizacion subTipoOrganizacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTADO_EMPRESA_FK", nullable = true, updatable = true)
	private EstadoEmpresa estadoEmpresa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CAUSAS_OPERACION_FK", nullable = true, updatable = true)
	private CausasOperacion causasOperacion;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CAP_SOC_NACIONAL_FK", nullable = true, updatable = true)
	private CapitalSocial capitalSocialNacional;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CAP_SOC_EXTRNJ_FK", nullable = true, updatable = true)
	private CapitalSocial capitalSocialExtranjero;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<Operacion> operaciones;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<VariableEmpresa> variablesEmpresa;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<IngresosNoOperacionales> ingresosNoOperacionales;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private InformacionFuncionamiento informacionFuncionamiento;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERIODO_RECOLECCION_FK", nullable = false, updatable = true)
	private PeriodoRecoleccion periodoRecoleccion; 
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<NovedadEncuesta> novedadesEncuestas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<EstadoEncuesta> estadosEncuestas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<EstadoModulos> estadoModulos;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DIRECCION_PRINCIPAL_FK", nullable = true, updatable = true)
	private Direccion direccionPrincipal;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DIRECCION_NOTIFICACION_FK", nullable = true, updatable = true)
	private Direccion direccionNotificacion;
	
	//----------------------------------------
	//Relaciones con las entidaes de Modulo 2
	//----------------------------------------
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<IngresosNetosPorGrupos> ingresosNetosPorGrupos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<VentasVehiculosMotos> ventasVehiculosMotos; 

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<MetodosVenta> metodosVenta;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private ClientePrincipal clientePrincipal;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<VehiculosComercializados> vehiculosComercializados;
	
	//----------------------------------------
	//Relaciones con las entidaes de Modulo 3
	//----------------------------------------
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<PersonalOcupado> personalOcupado;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<GastosCausadosPersonal> gastosCausadosPersonal;
	
	//----------------------------------------
	//Relaciones con las entidaes de Modulo 4
	//----------------------------------------
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<ComprasInventario> comprasInventarios;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<CostosCausados> costosCausados;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<OtrosGastosCausados> otrosGastosCausados;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<ValorActivos> valorActivos;
	
	//----------------------------------------
	//Relaciones con las entidaes de Inconsistencias.
	//----------------------------------------
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caratulaUnica")
	private Collection<Observaciones> observaciones;

	
}
