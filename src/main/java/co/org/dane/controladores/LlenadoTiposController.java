package co.org.dane.controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.org.dane.persistencia.entidades.tipos.CausasOperacion;
import co.org.dane.persistencia.entidades.tipos.SubTipoOrganizacion;
import co.org.dane.persistencia.entidades.tipos.TipoOrganizacion;
import co.org.dane.persistencia.entidades.tipos.TiposGenericos;
import co.org.dane.persistencia.repositorios.genericos.TodosRepositorios;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/api/pruebatipo")
public class LlenadoTiposController {

	@Autowired
	private TodosRepositorios<TiposGenericos> repositorioTiposGenericos;
	
	@GetMapping("/agregar")
	public void agregar() {
		//crearCausasOperacion();
		//crearTipoOrganizacion();
		crearSubTipoOrganizacion();
	}
	
	
	private void crearCausasOperacion(){
		try {
			List<String> cadenasCausasOperacion = Arrays.asList("Liquidada","Por huelga","Por amplicacion","Por traslado","Por fusion");
			int length = cadenasCausasOperacion.size();
			List<CausasOperacion> causasOperacion= new ArrayList<CausasOperacion>();
			IntStream.range(0, length).forEach(index  -> {
				CausasOperacion cop= new CausasOperacion();				
				cop.setCodigo(index+1);
				cop.setOrden(index+1);
				cop.setNombre(cadenasCausasOperacion.get(index));
				causasOperacion.add(cop);
				agregarTipo(cop);				
			});
			
			
		}catch (Exception e) {				
		}		
	}
	
	private void crearTipoOrganizacion(){
		try {
			List<String> cadenastiposOrganizacion = Arrays.asList("Sociedad Colectiva",
					"Sociedad en comandita simple",
					"Sociedad en comandita por acciones",
					"Sociedad limitada",
					"Sociedad anónima",
					"Sociedad de economía mixta",
					"Sucursal de sociedad extranjera",
					"Empresa industrial y comercial del estado",
					"Empresas unipersonales",
					"Sociedad de hecho",
					"Persona natural",
					"Organización de economía solidaria",
					"Entidades sin ánimo de lucro",
					"Sociedad por Acciones Simplificada",
					"Otras");
			int length = cadenastiposOrganizacion.size();
			List<TipoOrganizacion> tiposOrganizacion= new ArrayList<TipoOrganizacion>();
			IntStream.range(0, length).forEach(index  -> {
				TipoOrganizacion tip= new TipoOrganizacion();				
				tip.setCodigo(index+1);
				tip.setOrden(index+1);
				tip.setNombre(cadenastiposOrganizacion.get(index));
				tiposOrganizacion.add(tip);
				agregarTipo(tip);				
			});
			
			
		}catch (Exception e) {				
		}		
	}
	
	
	private void crearSubTipoOrganizacion(){
		System.out.println("crearSubTipoOrganizacion");
		try {
			final TiposGenericos to = repositorioTiposGenericos.findById(57).get();
			
			List<String> cadenasSUBTiposOrganizacion = Arrays.asList(
					"Cooperativas",
					"Precooperativa",
					"I. Auxiliares de economía solidaria",
					"Empresas de servicio en forma de Admón. Pública Cooperativa",
					"Fondo de empleados",
					"Cooperativa de trabajo asociado",
					"Asociación mutual",
					"Empresa solidaria de salud",
					"Empresa comunitaria",
					"Federación y confederación",
					"Empresa asociativa de trabajo",
					"Cooperativas"
					 );
			
			int length = cadenasSUBTiposOrganizacion.size();
			System.out.println("size: " + length);
			
			List<SubTipoOrganizacion> subtiposOrganizacion= new ArrayList<SubTipoOrganizacion>();
			IntStream.range(0, length).forEach(index  -> {
				SubTipoOrganizacion sto= new SubTipoOrganizacion();				
				sto.setCodigo(index+1);
				sto.setOrden(index+1);
				sto.setNombre(cadenasSUBTiposOrganizacion.get(index));
				sto.setTipoOrganizacion((TipoOrganizacion) to);
				subtiposOrganizacion.add(sto);
				agregarTipo(sto);
			});
			
		}catch (Exception e) {		
			e.printStackTrace();
		}
	}
	
	
	
	
	
	private void agregarTipo(TiposGenericos tipoGenerico) {
		try {				
			repositorioTiposGenericos.save(tipoGenerico);
			} 
		catch (Exception e) {				
		}	
	}
}
