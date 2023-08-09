
package com.egg.Biblioteca.servicios;

import com.egg.Biblioteca.entidades.Imagen;
import com.egg.Biblioteca.entidades.Usuario;
import com.egg.Biblioteca.enumeraciones.Rol;
import com.egg.Biblioteca.excepciones.MiException;
import com.egg.Biblioteca.repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio UsuarioRepositorio;

    @Autowired
    private ImagenServicio imagenServicio;
    
    
    @Transactional
    public void registrar(MultipartFile archivo, String nombre, String email, String password, String password2) throws MiException {
        validar(nombre, email, password, password2);
      
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);
        Imagen imagen = imagenServicio.guardar(archivo);
        
        usuario.setImagen(imagen);
        UsuarioRepositorio.save(usuario);

    }
    
    @Transactional
    public void actualizar(MultipartFile archivo,String idUsuario, String nombre, String email, String password, String password2) throws MiException {
    
        validar(nombre, email, password, password2);
       
        Optional<Usuario> respuesta = UsuarioRepositorio.findById(idUsuario);
        if(respuesta.isPresent()){
        
            Usuario usuario = respuesta.get();
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setPassword(new BCryptPasswordEncoder().encode(password));
            usuario.setRol(Rol.USER);
            String idImagen = null;
            if(usuario.getImagen() != null){
                idImagen = usuario.getImagen().getId();
            
            }
            Imagen imagen = imagenServicio.actualizar(archivo, idImagen);
            usuario.setImagen(imagen);
            UsuarioRepositorio.save(usuario);
        }
    
    }


    private void validar(String nombre, String email, String password, String password2) throws MiException {

        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("El nombre no puede ser nulo o estar vacio");
        }

        if (email == null || email.isEmpty()) {
            throw new MiException("El email no puede ser nulo o estar vacio");
        }
        

        if (password == null || password.isEmpty() || password.length() <= 5) {
            throw new MiException("La contrasena no puede estar vacia y debe tener mas de 5 digitos");
        }

        if (!password.equals(password2)) {
            throw new MiException("Las contrasenas deben ser iguales");
        }
        
        List<Usuario>listaUsuarios = listarUsuarios();
        for (Usuario usuario : listaUsuarios) {
                if (usuario.getEmail().equals(email)) {
                    throw new MiException("No se puede registrar con el mismo correo");
                }
        }
            
        

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = UsuarioRepositorio.buscarPorEmail(email);

        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());

            permisos.add(p);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            
            HttpSession session = attr.getRequest().getSession(true);
            
            session.setAttribute("usuariosession", usuario);
            
            return new User(usuario.getEmail(), usuario.getPassword(), permisos);

        } else {

            return null;

        }

    }

     public Usuario getOne(String id){
        Usuario usuario = UsuarioRepositorio.getOne(id);
      return usuario;
    
    }
     
    @org.springframework.transaction.annotation.Transactional(readOnly=true)
    public List<Usuario> listarUsuarios(){
    List<Usuario> listaUsuarios = new ArrayList<>();
    listaUsuarios = UsuarioRepositorio.findAll();
    
    return listaUsuarios;
    }
    
    
    
    public void cambiarRol(String id){
        Optional<Usuario> respuesta = UsuarioRepositorio.findById(id);
        
        
        if (respuesta.isPresent()) {
            
            Usuario usuario = respuesta.get();
            
            if(usuario.getRol().equals(Rol.USER)){
            usuario.setRol(Rol.ADMIN);
            }else if(usuario.getRol().equals(Rol.ADMIN)){
                usuario.setRol(Rol.USER);
            }

        }

    }
    
    
}
