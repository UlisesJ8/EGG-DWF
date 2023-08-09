
package com.Prj.Noticia.servicios;

import com.Prj.Noticia.entidades.Usuario;
import com.Prj.Noticia.enumeraciones.Rol;
import com.Prj.Noticia.excepciones.MiException;
import com.Prj.Noticia.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UsuarioServicio implements UserDetailsService{
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    
    
    @Transactional
    public void registrar(String nombreUsuario, String password, String password2) throws MiException{
        validar(nombreUsuario, password, password2);
        
        Usuario usuario = new Usuario();
        
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);
        usuario.setFechaDeAlta(new Date());
        
        usuarioRepositorio.save(usuario);
    }
    
    
    @Transactional(readOnly = true)
    public Usuario getOne(String idUsuario){
        return usuarioRepositorio.getOne(idUsuario);
    }
    
    @Transactional(readOnly = true)
    public List<Usuario> listaNoticias(){
    
        List<Usuario>listaUsuario = new ArrayList<>();
        listaUsuario = usuarioRepositorio.findAll();

        return listaUsuario;
    } 
    
    @Transactional
    public void Modificar(String idUsuario, String nombre, String email, String password, String password2, Date fechaAlta) throws Exception{
        validar(nombre,password, password2);
        Optional<Usuario> respuesta = usuarioRepositorio.findById(idUsuario);
    
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            usuario.setNombreUsuario(nombre);
            usuario.setPassword(password);
            usuario.setFechaDeAlta(new Date());
            usuarioRepositorio.save(usuario);
        }
    
    
    }
    
    @Transactional
    public void eliminar(String idUsuario) throws Exception{
    Usuario usuario = usuarioRepositorio.getById(idUsuario);
        usuarioRepositorio.delete(usuario);
    }
    
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario)throws UsernameNotFoundException{
        
        Usuario usuario = usuarioRepositorio.buscarPorUsuario(nombreUsuario);
         
        if (usuario != null) {
        
            List<GrantedAuthority> permisos = new ArrayList();
            
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            
            permisos.add(p);
            
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            
            HttpSession session = attr.getRequest().getSession(true);
            
            session.setAttribute("usuariosession", usuario);
        
            return new User(usuario.getNombreUsuario(), usuario.getPassword(), permisos);
        
            
        } else {
                return null;
        }
    
    }
    
    
       
    private void validar(String nombreUsuario, String password, String password2) throws MiException{
    
     if (nombreUsuario.isEmpty() || nombreUsuario == null) {
            throw new MiException("El nombre no puede estar vacio o ser nulo");
        }

        if (password.isEmpty() || password == null) {
            throw new MiException("El password no puede ser nulo o estar vacio");
        }
        
        if (password2.isEmpty() || password2 == null) {
            throw new MiException("El password2 no puede ser nulo o estar vacio");
        }
        
        if (!password.equals(password2)) {
            throw new MiException("Las contrasenas deben ser iguales");
        }
        
         List<Usuario>listaUsuarios = usuarioRepositorio.findAll();
        
        for (Usuario usuario : listaUsuarios) {

                if (usuario.getNombreUsuario().equals(nombreUsuario) ) {
                    throw new MiException("No se puede registrar con el mismo Usuario que otro");
                }
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
