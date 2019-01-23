package cl.accenture.proyecto.services;

import cl.accenture.proyecto.model.Rol;
import cl.accenture.proyecto.repositorio.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    private RolRepository rolRepository;

    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public Rol rolPorId(Integer idRol){
        return rolRepository.findById(idRol).get();
    }
    public Rol rolPorDescripcion(String descripcion){return rolRepository.findBydescripcion(descripcion);}
    public Rol rolPorNombre(String nombre){
        return rolRepository.findBynombre(nombre);
    }

}
