package cl.accenture.proyecto.repositorio;

import cl.accenture.proyecto.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{



    boolean findByEmail(String email);
    List<Usuario> findByEmailAndContrasena(String email, String password);


}
