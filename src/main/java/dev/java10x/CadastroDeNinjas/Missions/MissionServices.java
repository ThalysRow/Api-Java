package dev.java10x.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionServices {
    private MissionRepository missionRepository;

    public MissionServices(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public List<MissionModel> missionList(){
        return missionRepository.findAll();
    }
}
