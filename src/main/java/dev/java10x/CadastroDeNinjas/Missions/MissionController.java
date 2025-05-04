package dev.java10x.CadastroDeNinjas.Missions;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {

    public MissionServices missionServices;

    public MissionController(MissionServices missionServices) {
        this.missionServices = missionServices;
    }

    @GetMapping("/all")
    public List<MissionModel> ShowMissions(){
        return missionServices.missionList();
    }
}
