package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NinjaServices {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaServices(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> NinjaList() {
        return ninjaRepository.findAll().stream().map(ninjaMapper::map).toList();
    }

    public NinjaDTO findByID(UUID id) {
        NinjaModel ninja = ninjaRepository.findById(id).orElseThrow(() -> new RuntimeException("Ninja not found"));
        return ninjaMapper.map(ninja);
    }

    public NinjaDTO addNinja(NinjaDTO ninja) {
        NinjaModel ninjaModel = ninjaMapper.map(ninja);
        NinjaModel saveNinja = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(saveNinja);
    }

    public void deleteNinja(UUID id) {
        if (!ninjaRepository.existsById(id)) {
            throw new RuntimeException("Ninja not found");
        }
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO updateNinja(UUID id, NinjaDTO ninja) {

        if(!ninjaRepository.existsById(id)){
            throw new RuntimeException("Ninja not found");
        }

        ninja.setId(id);
        NinjaModel updateNinja = ninjaRepository.save(ninjaMapper.map(ninja));
        return ninjaMapper.map(updateNinja);
    }

}