
package com.Prj.Noticia.controlador;

import com.Prj.Noticia.entidades.Noticia;
import com.Prj.Noticia.entidades.Usuario;
import com.Prj.Noticia.excepciones.MiException;
import com.Prj.Noticia.servicios.AdministradorServicio;
import com.Prj.Noticia.servicios.NoticiaServicio;
import com.Prj.Noticia.servicios.PeriodistaServicio;
import com.Prj.Noticia.servicios.UsuarioServicio;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/")
public class NoticiaControlador {
    
    @Autowired
    NoticiaServicio noticiaServicio;
    
    @Autowired
    UsuarioServicio usuarioServicio;
    
    @Autowired
    PeriodistaServicio periodistaServicio;
    
    @Autowired
    AdministradorServicio administradorServicio;
    
    @GetMapping("/")
    public String index(ModelMap modelo){
        return "inicio.html";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_PERIODISTA','ROLE_ADMIN')")        
    @GetMapping("/editar") //localhost:8080/noticia/registrar
    public String registrar(ModelMap modelo){
        
        List<Noticia> noticias = noticiaServicio.listaNoticias();
        modelo.addAttribute("noticias", noticias);
 
        
       
        return "panel_admin.html";
    }
    
    
    @PreAuthorize("hasAnyRole('ROLE_PERIODISTA','ROLE_ADMIN')") 
    @PostMapping("/registroNoticia")
    public String formulario(@RequestParam(required = false) String titulo,@RequestParam(required = false) String cuerpo, ModelMap modelo) throws MiException{
        try{
        noticiaServicio.CrearNoticia(titulo, cuerpo);
        modelo.put("Exito", "La noticia ha sido cargada correctamente");
        List <Noticia> noticias  = noticiaServicio.listaNoticias();
        modelo.addAttribute("noticias", noticias);
        return "index.html";
        }catch(MiException ex){
        modelo.put("Error", ex.getMessage());
        return "panel_admin.html";
        }
        
    }
    
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_PERIODISTA','ROLE_ADMIN')")   
    @GetMapping("/noticiaCompleta/{id_noticia}")
    public String NoticiaCompleta(@PathVariable String id_noticia, ModelMap modelo){
        Noticia noticia = noticiaServicio.getOne(id_noticia);
        modelo.addAttribute("noticia", noticia);
        List<Noticia> noticias = noticiaServicio.listaNoticias();
        modelo.addAttribute("noticias", noticias);
        
        return "noticia_completa.html";
    }
 
    
     @PreAuthorize("hasAnyRole('ROLE_PERIODISTA','ROLE_ADMIN')")   
    @GetMapping("{id_noticia}")
    public String eliminar(@PathVariable String id_noticia, ModelMap modelo) throws Exception{
        noticiaServicio.eliminar(id_noticia);
        
        List<Noticia> noticias = noticiaServicio.listaNoticias();
        modelo.addAttribute("noticias", noticias);
 
        return "index.html";
    
    }
    
    
  @PreAuthorize("hasAnyRole('ROLE_PERIODISTA','ROLE_ADMIN')")   
    @GetMapping("/modificar/{id_noticia}")
    public String modificar(@PathVariable String id_noticia, ModelMap modelo){
        modelo.put("noticia", noticiaServicio.getOne(id_noticia));
        return "modificar_noticia.html";
        
    }
        
    @PreAuthorize("hasAnyRole('ROLE_PERIODISTA','ROLE_ADMIN')")   
    @PostMapping("modificar/{id_noticia}")
    public String modificarEnElServicio(@PathVariable String id_noticia, @RequestParam(required = false) String titulo, @RequestParam(required = false) String cuerpo, ModelMap modelo) throws Exception{
            try {
                
                Noticia noticia = noticiaServicio.getOne(id_noticia);
                noticiaServicio.Modificar(id_noticia, titulo, noticia.getCuerpo());
                List <Noticia> noticias  = noticiaServicio.listaNoticias();
                modelo.addAttribute("noticias", noticias);
                return"index.html";
                
            } catch (MiException ex) {
                
            modelo.put("error", ex.getMessage());
            return"panel_admin.html";
            }
    
    }
    
   
    @GetMapping("/login")
    public String login(@RequestParam (required = false) String error, ModelMap modelo){
        if (error != null) {
            modelo.put("Error", "Usuario o Contraseña invalidos!");
        }
        return "login.html";
    }
    
       
    @GetMapping("/registroUser")
    public String registrarUser(){
        return "registro.html";
    }
    
    
    @PostMapping("/registrarUser")
    public String registarUser1(@RequestParam String nombreUsuario, @RequestParam String password, @RequestParam String password2,@RequestParam String rol,@RequestParam String passwordEntidad, ModelMap modelo){
    
      
        try {
            
      
            if (rol.equalsIgnoreCase("Admin") && passwordEntidad.equalsIgnoreCase("123456")) {    
                administradorServicio.registrar(nombreUsuario, password, password2, passwordEntidad);
            }
            if(rol.equalsIgnoreCase("Periodista") && passwordEntidad.equalsIgnoreCase("123")){
                 periodistaServicio.registrar(nombreUsuario, password, password2, passwordEntidad);
            }   
            
            if(rol.equalsIgnoreCase("Usuario")){
                   usuarioServicio.registrar(nombreUsuario, password, password2); 
            }    
           
            
            modelo.put("exito", "Usuario registrado correctamente!");
            
            return "inicio.html";
        } catch ( MiException ex) {

            modelo.put("error", "Error!!! Ingrese un usuario distinto");
            return "registro.html";
        }

    }
    
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_PERIODISTA')")
    @GetMapping("/inicio")
    public String inicio(HttpSession session, ModelMap modelo){
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");
        modelo.addAttribute("usuario", logueado);
        List<Noticia> noticias = noticiaServicio.listaNoticias();
        modelo.addAttribute("noticias", noticias);
        return "index.html";
       
    }
   
    
    
}
