package dev.java10x.CadastroDeNinjas.Missions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MissionRepository extends JpaRepository<MissionRepository, UUID> {
}
