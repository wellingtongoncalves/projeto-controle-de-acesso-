package com.wz.controle_ponto_acesso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wz.controle_ponto_acesso.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
