package mx.com.leonrv.testfirebase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mx.com.leonrv.testfirebase.domain.Usuario;
import mx.com.leonrv.testfirebase.services.IUsuarioService;

@Controller
public class FirebaseController {
    

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("x", "x");
        return "index";
    }

    @PostMapping("/login")
    public String login(Usuario usuario, Model model){

        Usuario  usuarioObtenido = usuarioService.getUsuario(usuario.getUsername());

        if(usuarioObtenido != null){
            if(usuario.getPassword().equals(usuarioObtenido.getPassword())){
                model.addAttribute("usuario", usuario);
                return "home";
            }
        }

        model.addAttribute("isAuthenticated", false);
        return "index";
    }

}
