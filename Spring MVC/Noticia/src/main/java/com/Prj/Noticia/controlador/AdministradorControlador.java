
package com.Prj.Noticia.controlador;

import com.Prj.Noticia.entidades.Periodista;
import com.Prj.Noticia.entidades.Usuario;
import com.Prj.Noticia.enumeraciones.Rol;
import com.Prj.Noticia.excepciones.MiException;
import com.Prj.Noticia.repositorios.UsuarioRepositorio;
import com.Prj.Noticia.servicios.PeriodistaServicio;
import com.Prj.Noticia.servicios.UsuarioServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdministradorControlador {

    
    @Autowired
    PeriodistaServicio periodistaServicio;
    
    @Autowired
    UsuarioServicio usuarioServicio;
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/listaPeriodista")
    public String listaPeriodista(ModelMap modelo){
        List<Periodista>periodistas = periodistaServicio.listaPeriodistas();
        modelo.addAttribute("periodistas", periodistas);
        return "periodista_list.html";
    }
    
    
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/formularioModificar/{idUsuario}")
    public String modificarPeriodista(@PathVariable String idUsuario, ModelMap modelo){
        Usuario periodista = usuarioServicio.getOne(idUsuario);
        modelo.put("periodista", periodista);
        return "modificar_periodista.html";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/periodistaSueldo")
    public String modificarPeriodista2(@RequestParam String nombreUsuario, @RequestParam String password, @RequestParam String password2, @RequestParam String activo, @RequestParam int sueldoMensual, ModelMap modelo) throws Exception{
     
        try {
            Usuario usuario = usuarioRepositorio.buscarPorUsuario(nombreUsuario);
            periodistaServicio.ModificarPeriodista(usuario.getIdUsuario(), nombreUsuario, password, password2);
            periodistaServicio.AltaoBaja(usuario.getIdUsuario(),activo);
            periodistaServicio.GenerarSueldo(usuario.getIdUsuario(), nombreUsuario, password, password2, sueldoMensual);
            
            
            modelo.put("exito", "Periodista actualizado correctamente!");
            
           return "redirect:/inicio";
        }catch(MiException ex) {
            
            modelo.put("error", ex.getMessage());
             return "modificar_periodista.html";
        }
        
        
       
    }
  
}


