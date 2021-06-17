package br.org.generation.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.bootcamp.model.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
	
	
}

