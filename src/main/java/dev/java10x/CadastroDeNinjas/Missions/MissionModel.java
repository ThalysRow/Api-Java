package dev.java10x.CadastroDeNinjas.Missions;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_missions")
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private char rank;
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninja;

    public MissionModel(){
    }

    public MissionModel(String name, char rank){
        this.name = name;
        this.rank = rank;
    }

    public String getName(String name){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public char getRank(char rank){
        return rank;
    }

    public void setRank(char rank){
        this.rank = rank;
    }
}
