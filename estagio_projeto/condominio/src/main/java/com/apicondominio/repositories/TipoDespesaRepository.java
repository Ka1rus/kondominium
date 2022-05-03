package com.apicondominio.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.apicondominio.models.TipoDespesa;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Integer>{

    Optional<TipoDespesa> findByNomeDespesa(String nomeDespesa);
}
