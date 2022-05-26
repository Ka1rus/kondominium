package com.apicondominio.models.dtos;


import com.apicondominio.models.Bloco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
public class BlocoDTO {

    private Integer idBloco;

    @NotEmpty(message = "O campo sigla está vazio")
    @NotNull(message = "O campo sigla é obrigatório")
    private String sigla;

    @NotNull(message = "O campo descrição é obrigatório")
    private String descricao;

    @NotNull(message = "O campo endereço é obrigatório")
    private String endereco;

    public BlocoDTO(Bloco obj) {
        this.idBloco = obj.getIdBloco();
        this.sigla = obj.getSigla();
        this.descricao = obj.getDescricao();
        this.endereco = obj.getEndereco();
    }
}
