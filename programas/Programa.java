package programas;

import classes.Contato;
import java.util.Scanner;

public class Programa {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    final int CAPACIDADE = 2;

    Contato[] contatos = new Contato[CAPACIDADE];

    int qtdCadastrados = 0;
    
    int opcao;

    do {
      System.out.println("Escolha uma opção:");
      System.out.println("1 - Incluir pessoa");
      System.out.println("2 - Listar todos os cadastrados");
      System.out.print("Opção: ");

      opcao = sc.nextInt();
      sc.nextLine(); // Limpa o ENTER q fica na entrada

      switch (opcao) {
        
        case 0:
          System.out.println("Fim do programa!");
          break;
        
        case 1:
        
        if (qtdCadastrados == CAPACIDADE) {
        System.out.println("Não há mais espaço para cadastrar");
        continue;
        }
        
        Contato contato = new Contato();

        System.out.print("Nome: ");
        contato.setNome(sc.nextLine());

        System.out.print("Sobrenome: ");
        contato.setSobrenome(sc.nextLine());

        System.out.print("Telefone: ");
        contato.setTelefone(sc.nextLine());


        contatos[qtdCadastrados] = contato;

        qtdCadastrados = qtdCadastrados + 1;

          break;
        
        case 2:
        if (qtdCadastrados == 0) {
        System.out.println("Não há contatos cadastrados");
        continue;
        }

        System.out.println("====================");
        System.out.println("LISTAGEM DE CONTATOS");
        System.out.println("====================");

        for (int i = 0; i < qtdCadastrados; i++) {
          Contato c = contatos[i];
          System.out.printf("Nome completo: %s %s - Telefone: %s\n", c.getNome(), c.getSobrenome(), c.getTelefone());
        }

          break;
        default:
          System.out.println("Opção inválida!");
          break;
      }
    } while (opcao != 0);

    sc.close();
  }
}