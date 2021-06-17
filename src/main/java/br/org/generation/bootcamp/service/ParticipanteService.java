package br.org.generation.bootcamp.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.generation.bootcamp.model.Participante;
import br.org.generation.bootcamp.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
    
    @Autowired
	private ParticipanteRepository participanteRepository;

    public Optional<Participante> cadastrarParticipante(Participante participante) {
	
	    int idade = Period.between(participante.getDataNascimento(), LocalDate.now()).getYears();
		
        if(idade < 18)
            return null;

		return Optional.of(participanteRepository.save(participante));

	}
    
}
