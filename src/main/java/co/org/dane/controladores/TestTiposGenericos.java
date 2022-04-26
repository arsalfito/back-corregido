package co.org.dane.controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.org.dane.persistencia.entidades.tipos.CausasOperacion;
import co.org.dane.persistencia.entidades.tipos.TipoEjemplo;
import co.org.dane.persistencia.entidades.tipos.TiposGenericos;
import co.org.dane.persistencia.repositorios.genericos.TiposGenericosRepositorio;
import co.org.dane.persistencia.repositorios.genericos.TodosRepositorios;


@RestController 
@CrossOrigin(origins = { "*" })
@RequestMapping("/api/pruebatipo")
public class TestTiposGenericos {

	@Autowired
	private TiposGenericosRepositorio tgRepositorio;
	
	@Autowired
	private TodosRepositorios<TiposGenericos> repositoriosCausasOperacion;
	
	@Autowired
	private TodosRepositorios<TipoEjemplo> repositoriosTipoEjemplo;
	
	@GetMapping("/agregartiposcausas")
	public void agregar() {
		
		try {
			List<String> cadenasCausasOperacion = Arrays.asList("Liquidada","Por huelga","Por amplicacion","Por traslado","Por fusion");
			int length = cadenasCausasOperacion.size();
			List<CausasOperacion> causasOperacion= new ArrayList<CausasOperacion>();
			IntStream.range(0, length).forEach(index  -> {
				CausasOperacion cop= new CausasOperacion();				
				cop.setCodigo(index);
				cop.setOrden(index);
				cop.setNombre(cadenasCausasOperacion.get(index));
				causasOperacion.add(cop);
				agregarTipo(cop);				
				}
				);
			
			} 
		catch (Exception e) {				
			Integer i=0;
		}		
	}
	
	@GetMapping("/agregarTipoEjemplo")
	public void agregarTipoEjemplo() {
		
		try {
			List<String> tiposEjemplo = Arrays.asList("Tipo Ejemplo 1","Tipo Ejemplo 2");
			int length = tiposEjemplo.size();
			List<TipoEjemplo> tiposEjemplos= new ArrayList<TipoEjemplo>();
			IntStream.range(0, length).forEach(index  -> {
				TipoEjemplo te= new TipoEjemplo();				
				te.setCodigo(index);
				te.setOrden(index);
				te.setNombre(tiposEjemplo.get(index));
				tiposEjemplos.add(te);
				agregarTipo(te);				
				}
				);
			
			} 
		catch (Exception e) {				
			Integer i=0;
		}		
	}
	
	@GetMapping("/traerCausasOperacion")
	public ResponseEntity<List<TiposGenericos>>  traerCausasOperacion() {
		System.out.println(CausasOperacion.class.getSimpleName());
		List<TiposGenericos> causasOperacion = this.repositoriosCausasOperacion.traerTipos(CausasOperacion.class.getSimpleName());
		
		return ResponseEntity.status(HttpStatus.OK).body(causasOperacion);
	}
	
	@GetMapping("/traerTipoEjemplo")
	public ResponseEntity<List<TipoEjemplo>>  traerTipoEjemplo() {
		List<TipoEjemplo> tiposEjemplo = this.repositoriosTipoEjemplo.traerTipos(TipoEjemplo.class.getSimpleName());
		
		return ResponseEntity.status(HttpStatus.OK).body(tiposEjemplo);
	}

	
	private void agregarTipo(TiposGenericos tipoGenerico) {
		try {				
			tgRepositorio.save(tipoGenerico);
			} 
		catch (Exception e) {				
			Integer i=0;
		}	
	}
	
	
}
