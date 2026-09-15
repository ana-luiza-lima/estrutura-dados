package atividade03;

import javax.swing.*;
import java.util.Scanner;

public class MainAgenda {

//    public static void main(String[] args) {
//
//        Scanner leia = new Scanner(System.in);
//        Agenda agenda = new Agenda();
//
//        int opcao;
//        do {
//            System.out.println("\n=== MENU AGENDA ===");
//            System.out.println("1. Inserir contato");
//            System.out.println("2. Listar contatos");
//            System.out.println("3. Sair");
//            System.out.print("Escolha uma opção: ");
//            opcao = leia.nextInt();
//            leia.nextLine(); // buffer
//
//            switch (opcao) {
//                case 1:
//                    System.out.print("Digite o nome: ");
//                    String nome = leia.nextLine();
//                    System.out.print("Digite o número: ");
//                    String numero = leia.nextLine();
//                    agenda.inserir(nome, numero);
//                    System.out.println("Contato inserido com sucesso!");
//                    break;
//                case 2:
//                    agenda.listar();
//                    break;
//                case 3:
//                    System.out.println("Encerrando programa...");
//                    break;
//                default:
//                    System.out.println("Opção inválida!");
//            }
//        } while (opcao != 3);
//
//        leia.close();
//
//    }









    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        int opcao;

        do {
            String menu = "=== MENU AGENDA ===\n"
                    + "1. Inserir contato\n"
                    + "2. Listar contatos\n"
                    + "3. Sair\n"
                    + "Escolha uma opção:";

            String input = JOptionPane.showInputDialog(menu);

            if (input == null) {
                opcao = 3;
            } else {
                try {
                    opcao = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    opcao = -1;
                }
            }

            switch (opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o nome:");
                    String numero = JOptionPane.showInputDialog("Digite o número:");
                    if (nome != null && numero != null) {
                        agenda.inserir(nome, numero);
                        JOptionPane.showMessageDialog(null, "Contato inserido com sucesso!");
                    }
                    break;
                case 2:
                    if (agenda.getContador() == 0) {
                        JOptionPane.showMessageDialog(null, "Agenda vazia.");
                    } else {
                        StringBuilder lista = new StringBuilder();
                        for (int i = 0; i < agenda.getContador(); i++) {
                            lista.append("Nome: ").append(agenda.getNomes()[i])
                                    .append(" | Número: ").append(agenda.getNumeros()[i])
                                    .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, lista.toString());
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Encerrando programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 3);
    }















}
