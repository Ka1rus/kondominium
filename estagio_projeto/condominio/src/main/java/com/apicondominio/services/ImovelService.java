package com.apicondominio.services;

import com.apicondominio.models.Bloco;
import com.apicondominio.models.Imovel;
import com.apicondominio.models.dtos.ImovelDTO;
import com.apicondominio.repositories.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private BlocoService blocoService;

    public Imovel findById(Integer id) {
        Optional<Imovel> obj = imovelRepository.findById(id);
        return obj.orElseThrow();
    }

    public List<Imovel> findAll() {
        return imovelRepository.findAll();
    }

    public Imovel create(ImovelDTO obj) {

        return imovelRepository.save(newImovel(obj));
    }

    public Imovel update(Integer id, ImovelDTO objDTO) {
        objDTO.setIdImovel(id);
        Imovel oldObj = findById(id);
        oldObj = newImovel(objDTO);
        return imovelRepository.save(oldObj);
    }

    private Imovel newImovel(ImovelDTO obj) {
        Bloco bloco = blocoService.findById(obj.getBloco());
        Imovel imovel = new Imovel();
        if(obj.getIdImovel() != null) {
            imovel.setIdImovel(obj.getIdImovel());
        }
        imovel.setBloco(bloco);
        imovel.setNumero(obj.getNumero());
        imovel.setTipoImovel(obj.getTipoImovel());
        imovel.setPlanta(obj.getPlanta());
        imovel.setSituacaoAlu(obj.getSituacaoAlu());
        imovel.setFracaoIdeal(obj.getFracaoIdeal());
        imovel.setAreaTerreno(obj.getAreaTerreno());
        imovel.setAreaResidencialTotal(obj.getAreaResidencialTotal());
        imovel.setAreaConstruida(obj.getAreaConstruida());
        return imovel;
    }
}


