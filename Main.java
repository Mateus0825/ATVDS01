import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        while (true) {
            System.out.println("\n1 - Criar Produto\n2 - Alterar Produto\n3 - Excluir Produto\n4 - Listar Produtos\n5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                System.out.print("Código: ");
                int cdg = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Cor: ");
                String cor = scanner.nextLine();
                System.out.print("Categoria: ");
                String categoria = scanner.nextLine();
                System.out.print("CEP: ");
                int cep = scanner.nextInt();
                scanner.nextLine(); 

                produtos.add(new Produto(cdg, cor, categoria, nome, cep));
                System.out.println("Produto cadastrado com sucesso!");

            } else if (opcao == 2) {
                System.out.print("Digite o código do produto para alterar: ");
                int cdgBusca = scanner.nextInt();
                scanner.nextLine();

                boolean encontrado = false;
                for (Produto p : produtos) {
                    if (p.getCdg() == cdgBusca) {
                        System.out.print("Novo nome: ");
                        p.setNome(scanner.nextLine());
                        System.out.print("Nova cor: ");
                        p.setCor(scanner.nextLine());
                        System.out.print("Nova categoria: ");
                        p.setCategoria(scanner.nextLine());
                        System.out.print("Novo CEP: ");
                        p.setCep(scanner.nextInt());
                        scanner.nextLine();

                        System.out.println("Produto atualizado!");
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Produto não encontrado.");
                }

            } else if (opcao == 3) {
                System.out.print("Digite o código do produto para excluir: ");
                int cdgBusca = scanner.nextInt();
                scanner.nextLine();

                if (produtos.removeIf(p -> p.getCdg() == cdgBusca)) {
                    System.out.println("Produto removido com sucesso!");
                } else {
                    System.out.println("Produto não encontrado.");
                }

            } else if (opcao == 4) {
                System.out.println("\nLista de Produtos:");
                if (produtos.isEmpty()) {
                    System.out.println("Nenhum produto cadastrado.");
                } else {
                    for (Produto p : produtos) {
                        System.out.println(p);
                    }
                }

            } else if (opcao == 5) {
                System.out.println("Saindo...");
                break;

            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
