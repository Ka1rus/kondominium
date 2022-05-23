package com.apicondominio.controllers;

import com.apicondominio.models.Bloco;
import com.apicondominio.models.dtos.BlocoDTO;
import com.apicondominio.services.BlocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("api/blocos")
@RestController
public class BlocoController {

    @Autowired
    private BlocoService blocoService;


    @GetMapping("/{id}")
    public ResponseEntity<BlocoDTO> findById(@PathVariable Integer id) {
        Bloco obj = blocoService.findById(id);
        return ResponseEntity.ok().body(new BlocoDTO(obj));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BlocoDTO> create(@RequestBody BlocoDTO objDTO) {
        Bloco newObj = blocoService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getIdBloco()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BlocoDTO>> findAll() {
        List<Bloco> list = blocoService.findAll();
        List<BlocoDTO> listDTO = list.stream().map(obj -> new BlocoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BlocoDTO> update(@PathVariable Integer id, @RequestBody BlocoDTO objDTO) {
        Bloco obj = blocoService.update(id, objDTO);
        return ResponseEntity.ok().body(new BlocoDTO(obj));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<BlocoDTO> delete(@PathVariable Integer id) {
        blocoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
