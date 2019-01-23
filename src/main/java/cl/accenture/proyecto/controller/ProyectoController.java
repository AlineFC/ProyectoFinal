package cl.accenture.proyecto.controller;

import cl.accenture.proyecto.model.Proyecto;
import cl.accenture.proyecto.model.Rol;
import cl.accenture.proyecto.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    private ProyectoService proyectoService;
    @Autowired
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping("/proyectos/{porNombre}")
    public Proyecto proyectoPorNombre(@RequestParam String nombre){
        return proyectoService.econtrarNombre(nombre);
    }
   /* @GetMapping("/proyectos/{porStatus}")
    public Proyecto proyectoPorStatus(@RequestParam boolean status){
        return proyectoService.econtrarStatus(status);
    }*/
   // @GetMapping("/proyectos/{porId}")
   // public Proyecto proyectoPorStatus(@RequestParam Integer idProyecto){
   //     return proyectoService.econtrarId(idProyecto);
   // }
}
