package br.edu.infnet.tp3.model;

import br.edu.infnet.tp3.exceptions.NomeIncompletoException;

public class Professor extends Pessoa {
    private String disciplina;

    public Professor() {

    }

    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
    }

    public Professor(Professor source) throws NomeIncompletoException {
        super(source.getNome(), source.getIdade());
        this.disciplina = source.disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String consultarSituacao() {
        return "PROFESSOR: \n" +
                super.consultarSituacao() + "\n" +
                "Disciplina: " + disciplina + "\n";
    }
}
