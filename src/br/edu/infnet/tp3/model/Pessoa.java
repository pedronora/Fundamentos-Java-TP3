package br.edu.infnet.tp3.model;

import br.edu.infnet.tp3.exceptions.NomeIncompletoException;
import br.edu.infnet.tp3.util.Constant;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private String ultimoNome;
    private int idade;

    public Pessoa() {
        this.nome = Constant.NOME;
        this.idade = Constant.IDADE;
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;

        try {
            this.setNome(nome);
        } catch (NomeIncompletoException e) {
            System.out.println(e.getMessage());
        }
    }

    public Pessoa(Pessoa source) {
        this.nome = source.nome;
        this.idade = source.idade;

        try {
            this.setNome(nome);
        } catch (NomeIncompletoException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getNome() throws NomeIncompletoException {
        if (nome == null || nome.isBlank() ||
            sobrenome == null || sobrenome.isBlank() ||
            ultimoNome == null || ultimoNome.isBlank()) {
            throw new NomeIncompletoException("O preenchimento do campo 'nome' está incorreto!");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(nome);
        sb.append(" ");
        sb.append(sobrenome);
        sb.append(" ");
        sb.append(ultimoNome);

        return sb.toString();
    }

    public void setNome(String nome) throws NomeIncompletoException {
        int posInicial = nome.indexOf(" ");
        int posFinal = nome.lastIndexOf(" ");

        if (posInicial < 0 || posFinal < 0) {
            throw new NomeIncompletoException("O preechimento do campo 'nome' está incorreto!");
        }
        this.nome = nome.substring(0, posInicial);
        this.sobrenome = nome.substring(posInicial, posFinal).trim();
        this.ultimoNome = nome.substring(posFinal).trim();
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String consultarSituacao() {
        String consultaNome = "Não foi possível consultar";

        try {
            consultaNome = this.getNome();
        } catch (NomeIncompletoException e) {
            System.out.println(e.getMessage());
        }
        return "Nome: " + consultaNome + "\n" +
                "Idade: " + idade;
    }
}
