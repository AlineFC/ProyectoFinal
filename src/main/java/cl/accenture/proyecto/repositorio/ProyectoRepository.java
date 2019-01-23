package cl.accenture.proyecto.repositorio;

import cl.accenture.proyecto.model.Proyecto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProyectoRepository extends CrudRepository<Proyecto, Integer> {

    @Override
    long count();

    Proyecto findBynombreProyecto(String nombre);
    //Proyecto findByStatus(boolean status);
   // Optional<Proyecto> findById(Integer idProyecto);




}
