package com.apicondominio.models.dtos;

import com.apicondominio.models.Imovel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ImovelDTO {

    private Integer idImovel;

    private Integer numero;

    private String tipoImovel;

    private String planta;

    private String situacaoAlu;

    private Double fracaoIdeal;

    private Double areaTerreno;

    private Double areaResidencialTotal;

    private Double areaConstruida;

    private Integer bloco;

    private String sigla;


    public ImovelDTO(Imovel obj) {
        this.idImovel = obj.getIdImovel();
        this.numero = obj.getNumero();
        this.tipoImovel = obj.getTipoImovel();
        this.planta = obj.getPlanta();
        this.situacaoAlu = obj.getSituacaoAlu();
        this.fracaoIdeal = obj.getFracaoIdeal();
        this.areaTerreno = obj.getAreaTerreno();
        this.areaResidencialTotal = obj.getAreaResidencialTotal();
        this.areaConstruida = obj.getAreaConstruida();
        this.sigla = obj.getBloco().getSigla();
        this.bloco = obj.getBloco().getIdBloco();
    }

}
