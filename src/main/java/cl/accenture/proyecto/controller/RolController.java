package cl.accenture.proyecto.controller;


import cl.accenture.proyecto.model.Rol;
import cl.accenture.proyecto.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administradores")
public class RolController {

    private RolService rolService;

    @Autowired
    public RolController(RolService rolService){
        this.rolService=rolService;
    }

    @GetMapping("/administradores/{idRol}")
    public Rol rolPorId(@RequestParam Integer id){
        return rolService.rolPorId(id);
    }
    @GetMapping("/administradores/{nombre}")
    public Rol rolPorNombre(@RequestParam String nombre){
        return rolService.rolPorNombre(nombre);
    }
    @GetMapping("/administradores/{descripcion}")
    public Rol rolPorDescripcion(@RequestParam String descripcion){
        return rolService.rolPorDescripcion(descripcion);
    }

}
