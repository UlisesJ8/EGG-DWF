
package com.Prj.Noticia.servicios;

import com.Prj.Noticia.entidades.Periodista;
import com.Prj.Noticia.entidades.Usuario;
import com.Prj.Noticia.enumeraciones.Rol;
import com.Prj.Noticia.excepciones.MiException;
import com.Prj.Noticia.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeriodistaServicio {
    
    
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    UsuarioServicio usuarioServicio;
    
     @Transactional
    public void registrar(String nombre, String password, String password2, String passwordEntidad) throws MiException{
        validar(nombre, password, password2, passwordEntidad);
        
        Usuario usuario = new Usuario();
        
        usuario.setNombreUsuario(nombre);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.PERIODISTA);
        usuario.setFechaDeAlta(new Date());
        
        usuarioRepositorio.save(usuario);
    }

    @Transactional
    public void GenerarSueldo(String idUsuario ,String nombre, String password, String password2, int sueldoMensual ) throws MiException{

        Usuario usuario = usuarioServicio.getOne(idUsuario);
        Periodista periodista = new Periodista();
        periodista.setNombreUsuario(usuario.getNombreUsuario());
        periodista.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        periodista.setRol(Rol.PERIODISTA);
        periodista.setSueldoMensual(sueldoMensual);
        periodista.setActivo(Boolean.TRUE);
        usuarioRepositorio.save(periodista);
    }
    
    @Transactional
    public void AltaoBaja(String idUsuario, String estado) throws MiException{
        Usuario usuario = usuarioServicio.getOne(idUsuario);
        
        if (estado.equalsIgnoreCase("Alta")) {
            usuario.setActivo(true);
        } else {
            usuario.setActivo(false);
        }
        
        usuarioRepositorio.save(usuario);
    }
    
     @Transactional
    public void ModificarPeriodista(String idUsuario, String nombreUsuario, String password, String password2) throws Exception{
        validarActualizar(nombreUsuario,password, password2);
        Optional<Usuario> respuesta = usuarioRepositorio.findById(idUsuario);
    
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            usuario.setIdUsuario(usuario.getIdUsuario());
            usuario.setNombreUsuario(nombreUsuario);
            usuario.setPassword(new BCryptPasswordEncoder().encode(password));
            usuario.setFechaDeAlta(usuario.getFechaDeAlta());
            usuarioRepositorio.save(usuario);
        }
    
    
    }
    
    
    public List<Periodista>listaPeriodistas(){
    List<Usuario>usuarios = usuarioRepositorio.findAll();
    List<Periodista>listaPeriodistas = new ArrayList<>();
    
    for (Usuario p : usuarios) {
            
            if (p.getRol() == Rol.PERIODISTA) {
                Periodista per = new Periodista();
                per.setIdUsuario(p.getIdUsuario());
                per.setNombreUsuario(p.getNombreUsuario());
                per.setPassword(p.getPassword());
                per.setFechaDeAlta(p.getFechaDeAlta());
                per.setRol(Rol.PERIODISTA);
                listaPeriodistas.add(per);
               
            }
            
        }
    
        return listaPeriodistas;
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
        
        if (!passwordEntidad.equalsIgnoreCase("123")) {
                    throw new MiException("NO INGRESO UNA CONTRASEÑA CORRECTA PARA SER PERIODISTA");
                }
        
        List<Usuario>listaUsuarios = usuarioRepositorio.findAll();
        
        for (Usuario usuario : listaUsuarios) {

                if (usuario.getNombreUsuario().equals(nombreUsuario) ) {
                    throw new MiException("No se puede registrar con el mismo Nombre de usuario");
                }
        }
        
        
    }
    
    
   
    
    private void validarActualizar(String nombreUsuario, String password, String password2) throws MiException{
      
        
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
      
        
        List<Usuario>listaUsuarios = usuarioRepositorio.findAll();
        
        for (Usuario usuario : listaUsuarios) {

                if (usuario.getNombreUsuario().equals(nombreUsuario) ) {
                    throw new MiException("No se puede registrar con el mismo correo");
                }
        }
        
        
    }
    
   
}
