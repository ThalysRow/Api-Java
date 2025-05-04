package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NinjaServices {

    private NinjaRepository ninjaRepository;

    public NinjaServices(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> NinjaList(){
        return ninjaRepository.findAll();
    }

    public NinjaModel findByID(UUID id){
        return ninjaRepository.findById(id).orElseThrow(() -> new RuntimeException("Ninja not found"));
    }
}
