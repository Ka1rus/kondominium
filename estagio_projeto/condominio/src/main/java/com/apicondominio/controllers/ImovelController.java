package com.apicondominio.controllers;

import com.apicondominio.models.Imovel;
import com.apicondominio.models.dtos.ImovelDTO;
import com.apicondominio.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("api/imoveis")
@RestController
public class ImovelController {

    @Autowired
    private ImovelService imovelService;


    @GetMapping("/{id}")
    public ResponseEntity<ImovelDTO> findById(@PathVariable Integer id) {
        Imovel obj = imovelService.findById(id);
        return ResponseEntity.ok().body(new ImovelDTO(obj));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ImovelDTO> create(@RequestBody ImovelDTO obj) {
        Imovel newObj = imovelService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getIdImovel()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ImovelDTO>> findAll() {
        List<Imovel> list = imovelService.findAll();
        List<ImovelDTO> listDTO = list.stream().map(obj -> new ImovelDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ImovelDTO> update(@PathVariable Integer id, @RequestBody ImovelDTO objDTO) {
        Imovel obj = imovelService.update(id, objDTO);
        return ResponseEntity.ok().body(new ImovelDTO(obj));
    }


}
