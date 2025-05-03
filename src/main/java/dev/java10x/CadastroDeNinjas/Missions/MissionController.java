package dev.java10x.CadastroDeNinjas.Missions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mission")
public class MissionController {

    @PostMapping("/add")
    public String addMission(){
        return "New Mission";
    }

    @GetMapping("/ID")
    public String showMission(){
        return "Mission";
    }

    @GetMapping("/all")
    public String ShowMissions(){
        return "Missions";
    }

    @PutMapping("/ID")
    public String updateMission(){
        return "Update Mission";
    }

    @DeleteMapping("/ID")
    public String deleteMission(){
        return "Delete Mission";
    }
}
