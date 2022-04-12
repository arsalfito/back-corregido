package co.org.dane.persistencia.repositorios.modulo1;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.org.dane.persistencia.entidades.jwt.ERole;
import co.org.dane.persistencia.entidades.jwt.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(ERole name);
}
