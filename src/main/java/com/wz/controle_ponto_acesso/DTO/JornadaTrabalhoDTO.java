package com.wz.controle_ponto_acesso.DTO;

import com.wz.controle_ponto_acesso.entities.JornadaTrabalho;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class JornadaTrabalhoDTO {
	
	private long id;
    private String descricao;
    
	public JornadaTrabalhoDTO(JornadaTrabalho entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
	}

    
}
