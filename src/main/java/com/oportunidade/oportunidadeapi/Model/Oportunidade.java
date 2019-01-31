package com.oportunidade.oportunidadeapi.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Oportunidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)/*Geração de identidade do banco de dados, no caso autoinctement*/
    private Long id;

    @NotEmpty
    @Size(max = 200)
    private String descricao;

    /*Usando Bean Validation*/
    @NotEmpty
    @Size(max = 80)
    @Column(name = "nome_prospecto")
    private String nomeProspecto;

    @Min(0) /*Para nao incluir valor negativo*/
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeProspecto() {
        return nomeProspecto;
    }

    public void setNomeProspecto(String nomeProspecto) {
        this.nomeProspecto = nomeProspecto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Oportunidade)) return false;
        Oportunidade that = (Oportunidade) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
