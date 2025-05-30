package dev.java10x.CadastroDeNinjas.Missions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_missions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private char rank;
    @OneToMany(mappedBy = "missions")
    @JsonIgnore
    private List<NinjaModel> ninja;
}
