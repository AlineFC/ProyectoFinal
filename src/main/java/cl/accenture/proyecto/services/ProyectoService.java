package cl.accenture.proyecto.services;


import cl.accenture.proyecto.model.Proyecto;
import cl.accenture.proyecto.repositorio.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProyectoService {

    private ProyectoRepository proyectoRepository;

    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }


    public Proyecto contarProyectosId(Integer idProyecto){
        return proyectoRepository.findById(idProyecto).get();
    }
    public Iterable<Proyecto> findAll(){
        return proyectoRepository.findAll();
    }
    public long contarProyectos(){
        return proyectoRepository.count();
    }
    public Proyecto econtrarNombre(String nombre){return proyectoRepository.findBynombreProyecto(nombre);}
   // public Proyecto econtrarStatus(boolean status){return proyectoRepository.findByStatus(status); }
    public Optional<Proyecto> econtrarId(Integer idProyecto){return proyectoRepository.findById(idProyecto);}


}
