
package com.egg.Biblioteca.controlador;

import com.egg.Biblioteca.entidades.Usuario;
import com.egg.Biblioteca.excepciones.MiException;
import com.egg.Biblioteca.servicios.UsuarioServicio;
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
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/")
public class PortalControlador { //localhost:8080/
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @GetMapping("/")
    public String index(){ //localhost:8080/
    
        return "index.html";
    }
    
    
    @GetMapping("/registrar")
    public String registrar(){
    return "registro.html";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email, @RequestParam String password, 
            @RequestParam String password2, ModelMap modelo, MultipartFile archivo){
        try {
            usuarioServicio.registrar(archivo,nombre, email, password, password2);
            
            modelo.put("exito", "Usuario registrado correctamente!");
            
            return "index.html";
        } catch (MiException ex) {
            
            modelo.put("Error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            return "registro.html";
        }
    }
    
    
    @GetMapping("/login")
    public String login(@RequestParam (required = false) String error, ModelMap modelo){
        if (error != null) {
            modelo.put("Error", "Usuario o Contraseña invalidos!");
        }
        return "login.html";
    }
    

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicio(HttpSession session, ModelMap modelo){
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");
        modelo.addAttribute("usuario", logueado);
        if(logueado.getRol().toString().equals("ADMIN")){
        return "redirect:/admin/dashboard";
        }
        return "inicio.html";
    }
    
    
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/perfil")
    public String perfil(ModelMap modelo, HttpSession session){
    
    Usuario usuario = (Usuario) session.getAttribute("usuariosession");
    modelo.put("usuario", usuario);
    return "usuario_modificar.html";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping("/perfil/{id}")
    public String Actualizar(@PathVariable String id, @RequestParam String nombre, @RequestParam String email, @RequestParam String password, @RequestParam String password2, ModelMap modelo, MultipartFile archivo){
        try {
            usuarioServicio.actualizar(archivo, id, nombre, email, password, password2);
            modelo.put("exito", "Usuario actualizado correctamente!");
            return "inicio.html";
            
        } catch (MiException ex) {
        modelo.put("Error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            return "usuario_modificar.html";
                    
        }
   
    }
    
    
    
    
}
