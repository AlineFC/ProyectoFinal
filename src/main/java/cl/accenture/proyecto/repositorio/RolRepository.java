package cl.accenture.proyecto.repositorio;

import cl.accenture.proyecto.model.Rol;
import org.springframework.data.repository.CrudRepository;

public interface RolRepository extends CrudRepository<Rol, Integer> {


    Rol findBynombre(String Nombre);
    Rol findBydescripcion(String descripcion);
}
