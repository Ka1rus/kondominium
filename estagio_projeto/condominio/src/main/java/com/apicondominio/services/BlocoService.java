package com.apicondominio.services;

import com.apicondominio.models.Bloco;
import com.apicondominio.models.dtos.BlocoDTO;
import com.apicondominio.repositories.BlocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlocoService {

    @Autowired
    private BlocoRepository blocoRepository;

    public Bloco findById(Integer id) {
        Optional<Bloco> obj = blocoRepository.findById(id);
        return obj.orElseThrow();
    }

    public Bloco create(BlocoDTO objDTO) {
        Bloco newObj = new Bloco(objDTO);
        return blocoRepository.save(newObj);
    }

    public List<Bloco> findAll() {
        return blocoRepository.findAll();
    }

    public Bloco update(Integer id, BlocoDTO objDTO) {
        objDTO.setIdBloco(id);
        Bloco oldObj = findById(id);
        oldObj = new Bloco(objDTO);
        return blocoRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Bloco obj = findById(id);
        blocoRepository.deleteById(id);
    }


}
