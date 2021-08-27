package com.wz.controle_ponto_acesso.controllhers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wz.controle_ponto_acesso.DTO.JornadaTrabalhoDTO;
import com.wz.controle_ponto_acesso.services.JornadaTrabalhoService;

@RestController
@RequestMapping(value = "/jornada")
public class JornadaTrabalhoController {
	
	private final JornadaTrabalhoService service;
	
	@Autowired
	public JornadaTrabalhoController(JornadaTrabalhoService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<JornadaTrabalhoDTO>> findAll(){
		List<JornadaTrabalhoDTO> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<JornadaTrabalhoDTO> findById(@PathVariable Long id) {
		JornadaTrabalhoDTO dto = service.findByID(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<JornadaTrabalhoDTO> insert(@RequestBody JornadaTrabalhoDTO dto) {
		JornadaTrabalhoDTO newDto = service.insert(dto);
		return ResponseEntity.ok().body(newDto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<JornadaTrabalhoDTO> update(@PathVariable Long id,@RequestBody JornadaTrabalhoDTO dto) {
		JornadaTrabalhoDTO newDto = service.update(id, dto);
		return ResponseEntity.ok().body(newDto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<JornadaTrabalhoDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
