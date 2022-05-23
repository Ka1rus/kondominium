package com.apicondominio.models;

import com.apicondominio.models.dtos.BlocoDTO;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Bloco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idBloco;

    @Column(nullable = false)
    private String sigla;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String endereco;

    @OneToMany(mappedBy = "bloco")
    private List<Imovel> imoveis = new ArrayList<>();

    public Bloco(BlocoDTO obj) {
        this.idBloco = obj.getIdBloco();
        this.sigla = obj.getSigla();
        this.descricao = obj.getDescricao();
        this.endereco = obj.getEndereco();
    }
}

