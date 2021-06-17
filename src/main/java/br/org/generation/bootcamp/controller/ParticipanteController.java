package br.org.generation.bootcamp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.bootcamp.model.Participante;
import br.org.generation.bootcamp.repository.ParticipanteRepository;
import br.org.generation.bootcamp.service.ParticipanteService;

@RestController
@RequestMapping("/participantes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ParticipanteController {
    
    @Autowired
	private ParticipanteRepository participanteRepository;

    @Autowired
   	private ParticipanteService participanteService;

	@GetMapping
	public ResponseEntity<List<Participante>> getAll() {
		return ResponseEntity.ok(participanteRepository.findAll());
	
	}

	@GetMapping("/{id}")
	public ResponseEntity<Participante> getById(@PathVariable long id) {
		return participanteRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
   	public ResponseEntity<Optional<Participante>> criarParticipante(@RequestBody Participante participante) {
		
		Optional<Participante> participanteSalvo = participanteService.cadastrarParticipante(participante);
		
        try {
			
            return ResponseEntity.status(HttpStatus.CREATED).body(participanteSalvo);

		} catch (Exception e) {
			
            return ResponseEntity.badRequest().build();
		}
		
	}

	@PutMapping
	public ResponseEntity<Participante> put (@RequestBody Participante participante){
		return ResponseEntity.ok(participanteRepository.save(participante));				
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		participanteRepository.deleteById(id);
	}

}
