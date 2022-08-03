package com.example.bicicletariabikecenter.model;

import android.graphics.drawable.Drawable;

public class Bicicleta {

    private Integer id;

    private String descricao;

    private Double precoDinheiro;

    private Double precoCartao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoDinheiro() {
        return precoDinheiro;
    }

    public void setPrecoDinheiro(Double precoDinheiro) {
        this.precoDinheiro = precoDinheiro;
    }

    public Double getPrecoCartao() {
        return precoCartao;
    }

    public void setPrecoCartao(Double precoCartao) {
        this.precoCartao = precoCartao;
    }

    public String getPrecoDinheiroFormatado() {
        return "R$: " + String.format("%.2f", this.getPrecoDinheiro());
    }

    public String getPrecoCartaoFormatado() {
        return "R$: " + String.format("%.2f", this.getPrecoCartao());
    }

}
