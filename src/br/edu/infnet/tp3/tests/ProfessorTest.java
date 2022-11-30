package br.edu.infnet.tp3.tests;

import br.edu.infnet.tp3.exceptions.NomeIncompletoException;
import br.edu.infnet.tp3.model.Professor;

public class ProfessorTest {
    public static void main(String[] args) {
        Professor p1 = new Professor();
        try {
            p1.setNome("Pedro Henrique Macedo");
        } catch (NomeIncompletoException e) {
            System.out.println(e.getMessage());
        }
        p1.setIdade(35);
        p1.setDisciplina("Java");
        System.out.println("\n1 - " + p1.consultarSituacao());

        Professor p2 = new Professor();
        p2.setIdade(25);
        p2.setDisciplina("Python");
        // try {
        //     p2.setNome("Arthur");
        //     System.out.println("\nO novo professor se chama " + p2.getNome() + ", também possui " + p2.getIdade() + " anos de idade e também é especialista em " + p2.getDisciplina() + ".");
        // } catch (NomeIncompletoException e) {
        //     System.out.println(e.getMessage());
        // }


        Professor p3 = new Professor("Anita da Silva", 25, "Redes");

        System.out.println("\n3 - " + p3.consultarSituacao());
    }
}
