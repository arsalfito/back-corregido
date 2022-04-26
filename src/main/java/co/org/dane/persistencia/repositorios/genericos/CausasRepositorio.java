package co.org.dane.persistencia.repositorios.genericos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.tipos.CausasOperacion;

@Repository
public interface CausasRepositorio extends JpaRepository<CausasOperacion, Integer> {
	
}
