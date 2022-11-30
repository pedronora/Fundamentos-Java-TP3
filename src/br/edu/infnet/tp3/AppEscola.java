package br.edu.infnet.tp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import br.edu.infnet.tp3.model.*;
import br.edu.infnet.tp3.util.Constant;

public class AppEscola {

    private static Pessoa[] pessoas;
    private static int pos;
    private static String caminho = "src/br/edu/infnet/tp3/data/data.txt";

    public static void main(String[] args) {

        pessoas = new Pessoa[Constant.TAMANHO];

        Scanner scan = new Scanner(System.in);

        pos = carregarDados();

        String opcao;

        do {
            System.out.println("\n[1] Cadastrar professor");
            System.out.println("[2] Cadastrar aluno");
            System.out.println("[3] Consultar situação de um docente/discente.");
            System.out.println("[4] Consultar cadastrados.");
            System.out.println("[5] Sair.");

            System.out.print("\n\tInforme a opção desejada: ");
            opcao = scan.next();

            switch (opcao) {
                case "1":
                    if (pos < Constant.TAMANHO) {
                        System.out.print("\nInforme o nome do professor: ");
                        scan.nextLine();
                        String nome = scan.nextLine();

                        System.out.print("Informe a idade do professor: ");
                        int idade = scan.nextInt();

                        System.out.print("Informe a disciplina minstrada pelo professor: ");
                        scan.nextLine();
                        String disciplina = scan.nextLine();

                        Professor novoProfessor = new Professor(nome, idade, disciplina);

                        pessoas[pos] = novoProfessor;

                        System.out.println("\n----- Cadastro n. " + pos + " -----");
                        System.out.println(novoProfessor.consultarSituacao());
                        pos++;
                    } else {
                        System.out.println(
                                "Limite máximo! Não é possível cadastrar mais de " + Constant.TAMANHO + " alunos.");
                    }
                    break;
                case "2":
                    if (pos < Constant.TAMANHO) {
                        System.out.print("\nInforme o nome do aluno: ");
                        scan.nextLine();
                        String nome = scan.nextLine();

                        System.out.print("Informe a idade do aluno: ");
                        int idade = scan.nextInt();

                        System.out.print("Informa a nota da 1ª avaliação: ");
                        float av1 = scan.nextFloat();

                        System.out.print("Informa a nota da 2ª avaliação: ");
                        float av2 = scan.nextFloat();

                        Aluno novAluno = new Aluno(nome, idade, av1, av2);

                        pessoas[pos] = novAluno;
                        System.out.println("\n----- Cadastro n. " + pos + " -----");
                        System.out.println(novAluno.consultarSituacao());

                        pos++;
                    } else {
                        System.out.println(
                                "Limite máximo! Não é possível cadastrar mais de " + Constant.TAMANHO + " alunos.");
                    }
                    break;

                case "3":
                    System.out.print("\n\nInforme o número do cadastro: ");
                    int numCadastro = scan.nextInt();

                    if (numCadastro >= 0 && numCadastro < pos) {
                        System.out.println(pessoas[numCadastro].consultarSituacao());
                    } else {
                        System.out.println("\n\tA matrícula [" + numCadastro + "] é inválida!");
                    }

                    break;

                case "4":
                    imprimir();
                    break;

                case "5":
                    escreverDados();
                    System.out.println("\n\tAté logo!");
                    break;

                default:
                    System.out.println("\n\tERRO: Opção inválida!");
                    break;
            }
        } while (!"5".equals(opcao));

        System.out.println("\nProcessamento finalizado!");

        scan.close();
    }

    private static void imprimir() {
        if (pos == 0) {
            System.out.println("\nAinda não há alunos cadastrados!");
        } else {
            System.out.println("\n----- CADASTRO ESCOLAR -----\n");
            for (int i = 0; i < pos; i++) {
                System.out.println("----- Posição n. " + i + " -----");
                System.out.println(pessoas[i].consultarSituacao());
            }
        }
    }

    private static int carregarDados() {
        int index = 0;
        try {
            try {
                FileReader arquivo = new FileReader(caminho);
                BufferedReader reader = new BufferedReader(arquivo);
                String line = reader.readLine();

                while (line != null) {
                    String[] atributos = line.split(";");

                    String nome = atributos[1];
                    int idade = Integer.valueOf(atributos[2]);

                    switch (atributos[0]) {
                        case "A":
                            float av1 = Float.parseFloat(atributos[3]);
                            float av2 = Float.parseFloat(atributos[4]);

                            pessoas[index] = new Aluno(nome, idade, av1, av2);
                            break;

                        case "P":
                            String disciplina = atributos[3];
                            pessoas[index] = new Professor(nome, idade, disciplina);
                            break;

                        default:
                            break;
                    }

                    index++;
                    line = reader.readLine();
                }

                arquivo.close();
                reader.close();

            } catch (IOException e) {
                System.out.println("Error:" + e.getMessage());
            }
        } finally {
            System.out.println("\nCadastro carregado com sucesso!");
        }

        return index;
    }

    private static void escreverDados() {
        try {
            try {
                FileWriter arquivo = new FileWriter(caminho);
                BufferedWriter escrever = new BufferedWriter(arquivo);

                String linha = "";

                for (int i = 0; i < pos; i++) {
                    if (pessoas[i] instanceof Aluno) {
                        Aluno aluno = (Aluno) pessoas[i];
                        linha += "A;" + aluno.getNome() + ";" + aluno.getIdade() + ";" + aluno.getAv1() + ";"
                                + aluno.getAv2() + "\n";
                    } else {
                        Professor professor = (Professor) pessoas[i];
                        linha += "P;" + professor.getNome() + ";" + professor.getIdade() + ";" + professor.getDisciplina() + "\n";
                    }                    
                }

                escrever.write(linha);                
                escrever.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } finally {
            System.out.println("Dados salvos com sucesso!");
        }
    }
}
