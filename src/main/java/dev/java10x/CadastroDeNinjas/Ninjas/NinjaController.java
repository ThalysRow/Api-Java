package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaServices ninjaServices;

    public NinjaController(NinjaServices ninjaServices) {
        this.ninjaServices = ninjaServices;
    }

    @PostMapping("/add")
    public String addNinja(){
        return "Created Ninja";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showNinja(@PathVariable UUID id){
       try {
           NinjaModel ninja = ninjaServices.findByID(id);
           return ResponseEntity.ok(ninja);
       }catch (RuntimeException e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }
    }

    @GetMapping("/all")
    public List<NinjaModel> showNinjas(){
        return ninjaServices.NinjaList();
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
