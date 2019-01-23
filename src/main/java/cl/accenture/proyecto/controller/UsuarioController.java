package cl.accenture.proyecto.controller;
import cl.accenture.proyecto.model.Usuario;
import cl.accenture.proyecto.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/encontrarTodos")
    public Iterable<Usuario> encontrarTodos(@RequestBody Usuario usuario){
    return (Iterable<Usuario>) usuarioService.encontrarTodos(usuario); }

    @GetMapping("/login")
    public boolean loginUsuario(@RequestParam(name = "email") String email, @RequestParam(name = "contrasena") String contrasena) {

        String respuesta = null;

        List<Usuario> usuario =  usuarioService.validarLogin(email, contrasena);
        if (usuario != null) {
            respuesta = "Iniciando Sesion";
            return true;
        } else {
            respuesta = "Usuario o contraseña incorrectos";
            return false;
        }
    }

    @GetMapping("/usuario/{obtenerIdUser}")
    public Usuario obtenerPorId(@RequestParam("obtenerIdUser") Integer id) {
        return usuarioService.obtenerUsuario(id); }

    @GetMapping("/usuario/{mailUser}")
    public boolean encontrarMail(@RequestParam String email) {
        return  usuarioService.existeUserMail(email); }
    @GetMapping("/usuario/{idUser}")
    public boolean encontrarId(@RequestParam Integer idUser) {
        return  usuarioService.existeUser(idUser); }

    @GetMapping("/usuario/agregar")
        public void registrarUser(@RequestParam Integer idUser, @RequestParam String nombre,
                @RequestParam String email,
                @RequestParam String password){
            if (usuarioService.existeUser(idUser)){
                System.out.println("El id que esta tratando de registrar, ya se encuentra en la base de datos");
            }
            else if(usuarioService.existeUserMail(email)){
                System.out.println("Email ya existe en la base de datos.");
            }
            else {
                Usuario usuario=new Usuario(idUser,nombre,email,password);
                usuarioService.guardarUsuario(usuario);
                System.out.println("Guardado."); } }


    @PutMapping("/usuarios/{id}/editar")
    public boolean editUser(@RequestParam Integer idUser, @RequestBody Usuario usuario) {
        Usuario existeUser = usuarioService.obtenerUsuario(idUser);
        Assert.notNull(existeUser, "Usuario not found");
        existeUser.setNombreUs(usuario.getNombreUs());
        existeUser.setContrasena(usuario.getContrasena());
        existeUser.setEmail(usuario.getEmail());
        existeUser.setRol(usuario.getRol());
        existeUser.setIdUser(usuario.getIdUser());
        usuarioService.guardarUsuario(existeUser);
        return false;
    }

    @DeleteMapping("/usuarios/{iduser}/eliminar")
    public boolean deleteUser(@RequestParam Integer idUser, @RequestBody Usuario usuario) {
        Usuario usuario1 = usuarioService.obtenerUsuario(idUser);
        usuarioService.eliminarUser(usuario);
        return true;
    }
}