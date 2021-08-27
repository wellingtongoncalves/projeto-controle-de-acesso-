package com.wz.controle_ponto_acesso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wz.controle_ponto_acesso.entities.CategoriaUsuario;

@Repository
public interface CategoriaUsuarioRepository extends JpaRepository<CategoriaUsuario, Long> {

}
