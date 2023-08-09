
package com.Prj.Noticia.servicios;

import com.Prj.Noticia.entidades.Usuario;
import com.Prj.Noticia.enumeraciones.Rol;
import com.Prj.Noticia.excepciones.MiException;
import com.Prj.Noticia.repositorios.UsuarioRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministradorServicio {
    
    @Autowired
    UsuarioServicio usuarioServicio;
    
    @Autowired 
    UsuarioRepositorio usuarioRepositorio;
    
   @Transactional
    public void registrar(String nombre, String password, String password2, String passwordEntidad) throws MiException{
        validar(nombre, password, password2, passwordEntidad);
        
        Usuario usuario = new Usuario();
        
        usuario.setNombreUsuario(nombre);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.ADMIN);
        usuario.setFechaDeAlta(new Date());
        
        usuarioRepositorio.save(usuario);
    }
    
    
      private void validar(String nombreUsuario, String password, String password2, String passwordEntidad) throws MiException{
     
        if (nombreUsuario.isEmpty() || nombreUsuario == null) {
            throw new MiException("El nombre no puede estar vacio o ser nulo");
        }

        if (password.isEmpty() || password == null) {
            throw new MiException("El password no puede ser nulo o estar vacio");
        }
        
        if (password2.isEmpty() || password2 == null ) {
            throw new MiException("El password2 no puede ser nulo o estar vacio");
        }
        
        if (!password.equals(password2)) {
            throw new MiException("Las contrasenas deben ser iguales");
        }
        
         if (!passwordEntidad.equalsIgnoreCase("123456")) {
                    throw new MiException("NO INGRESO UNA CONTRASEÑA CORRECTA PARA SER ADMIN");
                }
        
        List<Usuario>listaUsuarios = usuarioRepositorio.findAll();
        
        for (Usuario usuario : listaUsuarios) {

                if (usuario.getNombreUsuario().equals(nombreUsuario) ) {
                    throw new MiException("No se puede registrar con el mismo Nombre que otro");
                }
        }
        
        
    }
    
    
    
    
    
    
    
    
}
