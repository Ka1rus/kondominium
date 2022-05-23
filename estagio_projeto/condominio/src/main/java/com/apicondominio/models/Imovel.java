package com.apicondominio.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idImovel;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private String tipoImovel;

    @Column(nullable = false)
    private String planta;

    @Column(nullable = false)
    private String situacaoAlu;

    @Column(nullable = false)
    private Double fracaoIdeal;

    @Column(nullable = false)
    private Double areaTerreno;

    @Column(nullable = false)
    private Double areaResidencialTotal;

    @Column(nullable = false)
    private Double areaConstruida;

    @ManyToOne
    @JoinColumn(name = "bloco_id")
    private Bloco bloco;

}
