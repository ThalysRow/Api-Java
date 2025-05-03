package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @PostMapping("/add")
    public String addNinja(){
        return "Created Ninja";
    }

    @GetMapping("/ID")
    public String showNinja(){
        return "Ninja";
    }

    @GetMapping("/all")
    public String showNinjas(){
        return "Ninjas";
    }

    @PutMapping("/ID")
    public String NinjaUpdate(){
        return "Ninja Update";
    }

    @DeleteMapping("/ID")
    public String NinjaDelete(){
        return "Ninja Delete";
    }
}
