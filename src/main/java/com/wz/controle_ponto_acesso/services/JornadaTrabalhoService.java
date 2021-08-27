package com.wz.controle_ponto_acesso.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wz.controle_ponto_acesso.DTO.JornadaTrabalhoDTO;
import com.wz.controle_ponto_acesso.entities.JornadaTrabalho;
import com.wz.controle_ponto_acesso.repositories.JornadaTrabalhoRepository;

@Service
public class JornadaTrabalhoService {

	private final JornadaTrabalhoRepository repository;

	@Autowired
	public JornadaTrabalhoService(JornadaTrabalhoRepository repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly=true)
	public List<JornadaTrabalhoDTO> findAll() {
		List<JornadaTrabalho> list = repository.findAll();
		return list.stream().map(x -> new JornadaTrabalhoDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly=true)
	public JornadaTrabalhoDTO findByID(Long id) {
		Optional<JornadaTrabalho> obj = repository.findById(id);
		JornadaTrabalho entity = obj.orElseThrow(()-> new EntityNotFoundException("Entity not found"));
		return new JornadaTrabalhoDTO(entity);
	}
	
	@Transactional
	public JornadaTrabalhoDTO insert(JornadaTrabalhoDTO dto) {
		JornadaTrabalho entity = new JornadaTrabalho();
		entity.setId(dto.getId());
		entity.setDescricao(dto.getDescricao());
		entity = repository.save(entity);
		return new JornadaTrabalhoDTO(entity);
	}
	
	@Transactional
	public JornadaTrabalhoDTO update(Long id, JornadaTrabalhoDTO dto) {
		try {
			JornadaTrabalho entity = new JornadaTrabalho();
			entity.setId(dto.getId());
			entity.setDescricao(dto.getDescricao());
			entity = repository.save(entity);
			return new JornadaTrabalhoDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new EntityNotFoundException("Id not found " + id);
		}
	}
	
	@Transactional
	public void delete (Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException("Id not found " +id, 0);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Integrity violation");
		}
	}
}
