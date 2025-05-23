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

    @GetMapping("/{id}")
    public ResponseEntity<Object> showNinja(@PathVariable UUID id){
       try {
           NinjaDTO ninja = ninjaServices.findByID(id);
           return ResponseEntity.ok(ninja);
       }catch (RuntimeException e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }
    }

    @PostMapping("/create")
    public ResponseEntity<NinjaDTO> createNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO saveNinja = ninjaServices.addNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveNinja);
    }

    @GetMapping("/all")
    public List<NinjaDTO> showNinjas(){
        return ninjaServices.NinjaList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNinja(@PathVariable UUID id){
        try {
            ninjaServices.deleteNinja(id);
            return ResponseEntity.status(HttpStatus.OK).body("Ninja deleted");
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateNinja(@PathVariable UUID id, @RequestBody NinjaDTO ninja){
        try {
            NinjaDTO ninjaUpdated = ninjaServices.updateNinja(id, ninja);
            return ResponseEntity.ok(ninjaUpdated);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
