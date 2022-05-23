package com.apicondominio.models.dtos;


import com.apicondominio.models.Bloco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class BlocoDTO {

    private Integer idBloco;

    private String sigla;

    private String descricao;

    private String endereco;

    public BlocoDTO(Bloco obj) {
        this.idBloco = obj.getIdBloco();
        this.sigla = obj.getSigla();
        this.descricao = obj.getDescricao();
        this.endereco = obj.getEndereco();
    }
}
