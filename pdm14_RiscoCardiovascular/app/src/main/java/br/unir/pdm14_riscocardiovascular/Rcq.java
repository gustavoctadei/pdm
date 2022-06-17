package br.unir.pdm14_riscocardiovascular;

public class Rcq {
    private String nome;
    private Integer idade;
    private String sexo;
    private Float rcq;
    private String classificacao;

    public Rcq() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Float getRcq() {
        return rcq;
    }

    public void setRcq(Float rcq) {
        this.rcq = rcq;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.sexo + " - " + String.format("%.2f", this.rcq);
    }
}
