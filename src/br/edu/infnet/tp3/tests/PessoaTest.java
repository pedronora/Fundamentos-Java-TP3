package br.edu.infnet.tp3.tests;

import br.edu.infnet.tp3.exceptions.NomeIncompletoException;
import br.edu.infnet.tp3.model.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        try {
            p1.setNome("João");
            p1.setIdade(22);
            System.out.println("\nPessoa 1:\n" + p1.consultarSituacao());
        } catch (NomeIncompletoException e) {
            System.out.println(e.getMessage());
        }
        

        Pessoa p2 = new Pessoa(p1);
        try {
            p2.setNome("Márcio");
            System.out.println("\nPessoa 2:\n" + p2.consultarSituacao());
        } catch (NomeIncompletoException e) {
            System.out.println(e.getMessage());
        }

        Pessoa p3 = new Pessoa();
        try {
            p3.setNome("Claudia");
            p3.setIdade(25);
            System.out.println("\nPessoa 3:\n" + p3.consultarSituacao());
        } catch (NomeIncompletoException e) {
            System.out.println(e.getMessage());
        }
        

        Pessoa p4 = new Pessoa();
        System.out.println("\nPessoa 4:\n" + p4.consultarSituacao());

        System.out.println("\np1 é mais velho que p3?: " + maisVelho(p1, p3));
    }

    private static boolean maisVelho(Pessoa p1, Pessoa p2) {
        if (p1.getIdade() > p2.getIdade()) {
            return true;
        }
        return false;
    }

}
