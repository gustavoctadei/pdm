package br.unir.pdm13_applistacompras;

public class Produto {

    private String nome;

    private Integer quantidade;

    private Float preco;

    private Integer quantidadeCarrinho;

    public Produto() {
        this.quantidadeCarrinho = 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeCarrinho() {
        return quantidadeCarrinho;
    }

    public void setQuantidadeCarrinho(Integer quantidadeCarrinho) {
        this.quantidadeCarrinho = quantidadeCarrinho;
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + "Qtd: " + this.getQuantidade() + " - " + "R$" + String.format("%.2f", this.getPreco());
    }
}
