package br.edu.infnet.tp3.tests;

import br.edu.infnet.tp3.exceptions.NomeIncompletoException;
import br.edu.infnet.tp3.model.Aluno;

public class AlunoTest {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("João Martinho da Silva", 25, 5, 3);
        System.out.println("\n1 - " + a1.consultarSituacao());

        Aluno a2 = new Aluno();
        try {
            a2.setNome("Marcos");
            a2.setIdade(20);
            a2.setAv2(9);
            System.out.println("\n2 - " + a2.consultarSituacao());
        } catch (NomeIncompletoException e) {
            System.out.println(e.getMessage());
        }

        Aluno a3 = new Aluno();
        try {
            a3.setNome("Joaquim da Silva");;
            a3.setIdade(30);
            a3.setAv1(8);
            a3.setAv2(7);
            System.out.println("\n3 - " + a3.consultarSituacao());
        } catch (NomeIncompletoException e) {
            System.out.println(e.getMessage());
        }

        Aluno a4 = new Aluno();
        System.out.println("\n4 - " + a4.consultarSituacao());

        try {
            System.out.println("\nA idade de " + a1.getNome() + " é " + a1.getIdade() + " e esta é sua situação: " + a1.obterSituacao(a1.obterMedia())) ;
            System.out.println("A idade de " + a2.getNome() + " é " + a2.getIdade()+ " e esta é sua situação: " + a2.obterSituacao(a2.obterMedia()));
            System.out.println("A idade de " + a3.getNome() + " é " + a3.getIdade()+ " e esta é sua situação: " + a3.obterSituacao(a3.obterMedia()));
        } catch (NomeIncompletoException e) {
            System.out.println(e.getMessage());
        }
    }
}
