package cl.accenture.proyecto.services;

import cl.accenture.proyecto.model.Usuario;
import cl.accenture.proyecto.repositorio.UsuarioRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.accenture.proyecto.model.Rol;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void guardarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    public boolean existeUser(Integer idUser){
        return usuarioRepository.existsById(idUser);
    }
    public boolean existeUserMail(String email){
        return usuarioRepository.findByEmail(email);
    }
    public Iterable<Usuario> encontrarTodos(Usuario usuario){return (Iterable<Usuario>) usuarioRepository.findAll();
    }
    public void eliminarUser(Usuario usuario){usuarioRepository.delete(usuario);}
    public String encriptar(String contrasena) { String respuesta = DigestUtils.md5Hex(contrasena);return respuesta; }
    //Validador Login
    public List<Usuario> validarLogin(String email,String contrasena){
        return usuarioRepository.findByEmailAndContrasena(email,contrasena);
    }
    //Obtener usuario por ID
    public Usuario obtenerUsuario(Integer idUser){
        return usuarioRepository.findById(idUser).get();
    }
}
