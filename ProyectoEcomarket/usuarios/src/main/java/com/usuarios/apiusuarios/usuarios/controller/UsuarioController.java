package com.usuarios.apiusuarios.usuarios.controller;
 
import com.usuarios.apiusuarios.usuarios.model.Usuario;
import com.usuarios.apiusuarios.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
 
import java.util.*;
 
@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = "*") // Permitir acceso desde cualquier origen (frontend HTML)
public class UsuarioController {
 
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
 
    @GetMapping
    public List<Usuario> listaUsuarios() {
        return usuarioService.getUsuarios();
    }
 
    @PostMapping
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }
 
    @GetMapping("{id}")
    public Usuario buscaUsuario(@PathVariable int id) {
        return usuarioService.getUsuarioId(id);
    }
 
    @PutMapping("{id}")
    public Usuario actualizaUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.updateUsuario(usuario);
    }
 
    @DeleteMapping("{id}")
    public String eliminarUsuario(@PathVariable int id) {
        return usuarioService.deleteUsuario(id);
    }
 
    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String contrasena = loginData.get("contrasena");
 
        return usuarioService.loginUsuario(email, contrasena)
                .map(usuario -> ResponseEntity.ok(Map.of(
                        "id", usuario.getId(),
                        "nombre", usuario.getNombre()
                )))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Credenciales inválidas")));
    }

    @Controller
    public class InicioController {
        @GetMapping("/")
        public String home() {
            return "redirect:/index.html";
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> obtenerPorEmail(@PathVariable String email) {
        return usuarioService.buscarPorEmail(email)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}
 

}
