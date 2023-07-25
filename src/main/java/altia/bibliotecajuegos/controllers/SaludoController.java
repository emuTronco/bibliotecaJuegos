package altia.bibliotecajuegos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class SaludoController {
    @GetMapping("/saludar")
    public String saludar() {
        return "Hola mundo";
    }

    @GetMapping("/saludar/{nombre}")
    public String saludar(@PathVariable String nombre) {
        return "Hola mundo " + nombre;
    }
}
