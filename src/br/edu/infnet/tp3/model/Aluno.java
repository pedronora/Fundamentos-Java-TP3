package br.edu.infnet.tp3.model;

import br.edu.infnet.tp3.exceptions.NomeIncompletoException;

public class Aluno extends Pessoa {
    private float av1;
    private float av2;

    public Aluno() {
        
    }

    public Aluno(String nome, int idade, float av1, float av2) {
        super(nome, idade);
        this.av1 = av1;
        this.av2 = av2;
    }

    public Aluno(Aluno source) throws NomeIncompletoException {
        super(source.getNome(), source.getIdade());
        this.av1 = source.av1;
        this.av2 = source.av2;
    }

    public float getAv1() {
        return av1;
    }

    public void setAv1(float av1) {
        this.av1 = av1;
    }

    public float getAv2() {
        return av2;
    }

    public void setAv2(float av2) {
        this.av2 = av2;
    }

    public float obterMedia() {
        return (av1 + av2) / 2;
    }

    public String obterSituacao(float media) {
        if (media < 4) {
            return "Reprovado";
        } else if (media < 7) {
            return "Prova Final";
        } else {
            return "Aprovado";
        }
    }

    @Override
    public String consultarSituacao() {
        float media = obterMedia();

        return "ALUNO: \n" +
                super.consultarSituacao() + "\n" +
                "Avaliação 1: " + av1 + "\n" +
                "Avaliação 2: " + av2 + "\n" +
                "Média: " + media + "\n" +
                "Situação: " + obterSituacao(media) + "\n";
    }
}
