/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.ej1.libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalControlador {
    
    @GetMapping("/")
    public String index() {
        return "index.html";
    }
    

    

    //todo: implementar spring security para que deje de pedir password
    
    
}
