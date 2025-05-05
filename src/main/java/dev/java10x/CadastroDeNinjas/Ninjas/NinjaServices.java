package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NinjaServices {

    private NinjaRepository ninjaRepository;

    public NinjaServices(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> NinjaList() {
        return ninjaRepository.findAll();
    }

    public NinjaModel findByID(UUID id) {
        return ninjaRepository.findById(id).orElseThrow(() -> new RuntimeException("Ninja not found"));
    }

    public NinjaModel addNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    public void deleteNinja(UUID id) {
        if (!ninjaRepository.existsById(id)) {
            throw new RuntimeException("Ninja not found");
        }
        ninjaRepository.deleteById(id);
    }

    public NinjaModel updateNinja(UUID id, NinjaModel ninja) {
        if (ninjaRepository.existsById(id)) {
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        throw new RuntimeException("Ninja not found");
    }
}