
import java.util.Scanner;

public class SistemaAtendimento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fila filaAtendimento = new Fila();
        Pilha historicoSolicitacoes = new Pilha();

        int idSolicitacaoCounter = 1; // Contador simples 
        int idClienteCounter = 100;

        int opcao = 0;

        while (opcao != 6) {
            exibirMenu();

            try {
                // Lê 
                String input = scanner.nextLine();
                // Converte
                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        // adiciona à Fila
                        System.out.print("Nome do Cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Motivo do Atendimento: ");
                        String motivo = scanner.nextLine();

                        // gera um ID 
                        String idCliente = "C" + idClienteCounter;
                        idClienteCounter = idClienteCounter + 1;

                        Cliente novoCliente = new Cliente(nome, idCliente, motivo);
                        filaAtendimento.adicionar(novoCliente);
                        break;

                    case 2:
                        // Atender próximo 
                        Cliente clienteAtendido = filaAtendimento.atender();

                        if (clienteAtendido != null) {
                            System.out.println("Atendendo: " + clienteAtendido.getInfo());

                            // Adiciona no histórico
                            System.out.print("Digite a data e hora (DD/MM/AAAA HH:MM): ");
                            String dataHora = scanner.nextLine();
                            String idSol = "S" + idSolicitacaoCounter;
                            idSolicitacaoCounter = idSolicitacaoCounter + 1;
                            String desc = "Atendimento concluído para " + clienteAtendido.getNome();

                            Solicitacao novaSolicitacao = new Solicitacao(idSol, desc, dataHora);
                            historicoSolicitacoes.adicionar(novaSolicitacao);
                        } else {
                            System.out.println("A fila de atendimento está vazia.");
                        }
                        break;

                    case 3:
                        // fila de Atendimento
                        filaAtendimento.verFila();
                        break;

                    case 4:
                        // Histórico de Solicitações
                        historicoSolicitacoes.verHistorico();
                        break;

                    case 5:
                        // Remove ultima Solicitação do histórico
                        Solicitacao removida = historicoSolicitacoes.remover();
                        if (removida != null) {
                            System.out.println("Solicitação removida do histórico (desfeita):");
                            System.out.println(removida.getInfo());
                        } else {
                            System.out.println("O histórico já está vazio.");
                        }
                        break;

                    case 6:
                        // Sair
                        System.out.println("Encerrando o sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (Exception e) {
                // Captura erro se o usuário digitar algo que não é um número
                System.out.println("Entrada inválida. Por favor, digite um número.");
                opcao = 0; // Reseta a opção para não entrar em loop infinito
            }

            if (opcao != 6) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine(); // Pausa
            }
        }

        scanner.close(); // Fecha o scanner ao sair
    }

    // exibir o menu (meu deus tudo por extenso)
    public static void exibirMenu() {
        System.out.println("\n--- Sistema de Gerenciamento de Atendimento ---");
        System.out.println("1. Adicionar Cliente à Fila");
        System.out.println("2. Atender Próximo Cliente");
        System.out.println("3. Ver Fila de Atendimento");
        System.out.println("4. Ver Histórico de Solicitações");
        System.out.println("5. Desfazer Última Solicitação (Pop)");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }
}
