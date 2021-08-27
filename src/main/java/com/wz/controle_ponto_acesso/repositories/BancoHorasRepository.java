package com.wz.controle_ponto_acesso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wz.controle_ponto_acesso.entities.BancoHoras;
import com.wz.controle_ponto_acesso.entities.BancoHoras.BancoHorasId;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, BancoHorasId> {

}
