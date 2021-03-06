package com.apicondominio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apicondominio.models.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer>{

}
