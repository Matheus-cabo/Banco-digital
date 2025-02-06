package JavaBank.SistemaBancario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import JavaBank.Banco.Cliente.Cliente;
import JavaBank.Banco.Contas.Conta;
import JavaBank.Banco.Contas.ContaCorrente;
import JavaBank.Banco.Contas.ContaPoupanca;
import JavaBank.Banco.Contas.SaldoInsuficienteException;

public class JavaBank {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>(); // Lista de clientes

        System.out.println("Bem-vindo ao JavaBank");

        while (true) {
            System.out.println("Clique 1 para se Registrar");
            System.out.println("Clique 2 para fazer Login");
            System.out.println("Clique 3 para fechar o aplicativo");

            int digito = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha após nextInt()

            switch (digito) {
                case 1:
                    // Criando o cliente
                    Cliente cliente = new Cliente();

                    // Leitura do nome
                    System.out.println("Digite seu nome:");
                    cliente.setNome(scanner.nextLine());

                    // Leitura do CPF
                    String cpf;
                    while (true) {
                        System.out.println("Digite seu CPF (somente números):");
                        cpf = scanner.nextLine();
                        if (cpf.matches("\\d{11}")) { // Verifica se contém 11 dígitos
                            break;
                        } else {
                            System.out.println("O CPF precisa conter 11 caracteres numéricos.");
                        }
                    }
                    cliente.setCpf(cpf);

                    // Leitura da data de nascimento
                    LocalDate dataNascimento = null;
                    while (dataNascimento == null) {
                        System.out.println("Digite sua data de nascimento (formato: dd/MM/yyyy):");
                        String dateString = scanner.nextLine();
                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            dataNascimento = LocalDate.parse(dateString, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Data inválida. Tente novamente.");
                        }
                    }
                    cliente.setDataNascimento(dataNascimento);

                    // Leitura do login e senha
                    System.out.println("Digite seu Login: ");
                    cliente.setLogin(scanner.nextLine());

                    String senha;
                    while (true) {
                        System.out.println("Digite sua senha (Máximo 8 caracteres):");
                        senha = scanner.nextLine();
                        if (senha.length() == 8) {
                            break;
                        } else {
                            System.out.println("A senha precisa conter 8 caracteres.");
                        }
                    }
                    cliente.setSenha(senha);

                    // Leitura do número de celular
                    String numeroCelular;
                    while (true) {
                        System.out.println("Digite seu número de celular (somente números):");
                        numeroCelular = scanner.nextLine();
                        if (numeroCelular.matches("\\d{11}")) {
                            break;
                        } else {
                            System.out.println("Seu número precisa ter 11 caracteres numéricos.");
                        }
                    }
                    cliente.setNumeroCelular(numeroCelular);

                    // Criando as contas
                    ContaCorrente contaCorrente = new ContaCorrente(cliente);
                    ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);
                    cliente.adicionarConta(contaCorrente);
                    cliente.adicionarConta(contaPoupanca);
                    clientes.add(cliente); // Adiciona o cliente à lista

                    // Exibindo os dados cadastrados
                    System.out.println("\nCadastro realizado com sucesso!");
                    System.out.println(cliente);

                    // Exibir a agência e o número da conta
                    System.out.println("Agência: " + contaCorrente.getAgencia());
                    System.out.println("Conta Corrente: " + contaCorrente.getNumero());
                    System.out.println("Conta Poupança: " + contaPoupanca.getNumero());
                    break;

                case 2:
                    System.out.println("Digite sua Agência:");
                    int agenciaLogin = scanner.nextInt();
                    System.out.println("Digite sua Conta:");
                    int numeroLogin = scanner.nextInt();
                    System.out.println("Digite sua Senha:");
                    String senhaLogin = scanner.next();

                    Conta contaAutenticada = null;

                    for (Cliente c : clientes) {
                        for (Conta conta : c.getContas()) {
                            if (conta.verificarCredenciais(agenciaLogin, numeroLogin, senhaLogin)) {
                                contaAutenticada = conta;
                                break;
                            }
                        }
                        if (contaAutenticada != null) {
                            break;
                        }
                    }

                    if (contaAutenticada == null) {
                        System.out.println("Login ou senha inválidos.");
                        break;
                    }

                    System.out.println("Login realizado com sucesso!");
                    System.out.println("Bem-vindo ao Java Bank, " + contaAutenticada.getCliente().getNome() + "!");
                    //bem vindo ao java bank e o nome da pessoa

                    
                    // Menu de opções após o login
                    boolean operacoesAtivas = true;
                    while (operacoesAtivas) {
                        System.out.println("Digite 1 para ver o extrato da conta");
                        System.out.println("Digite 2 para depositar na conta");
                        System.out.println("Digite 3 para transferir para outra conta");
                        System.out.println("Digite 4 para voltar ao menu principal");

                        int opcao = scanner.nextInt();
                        scanner.nextLine(); // Consome a quebra de linha após nextInt()

                        switch (opcao) {
                            case 1:
                                contaAutenticada.imprimirExtrato(contaAutenticada.getCliente());
                                break;

                            case 2:
                                System.out.println("Digite o valor a depositar:");
                                double valorDeposito = scanner.nextDouble();
                                contaAutenticada.depositar(valorDeposito);
                                System.out.println("Depósito realizado com sucesso!");
                                break;

                                case 3:
                                System.out.println("Digite o valor a transferir:");
                                double valorTransferencia = scanner.nextDouble();
                                System.out.println("Digite a Agência do destinatário:");
                                int agenciaDestino = scanner.nextInt();
                                System.out.println("Digite o Número da conta do destinatário:");
                                int numeroDestino = scanner.nextInt();
                            
                                Conta contaDestino = null;
                            
                                // Busca pela conta destino
                                for (Cliente c : clientes) {
                                    for (Conta conta : c.getContas()) {
                                        if (conta.getAgencia() == agenciaDestino && conta.getNumero() == numeroDestino) {
                                            contaDestino = conta;
                                            break;
                                        }
                                    }
                                    if (contaDestino != null) {
                                        break;
                                    }
                                }
                            
                                System.out.println("Digite a senha da sua conta:");
                                String senhaDestino = scanner.next();
                                if (contaDestino != null && contaDestino.verificarCredenciais(agenciaDestino, numeroDestino, senhaDestino)) {
                                    try {
                                        contaAutenticada.transferir(valorTransferencia, contaDestino);
                                        System.out.println("Transferência realizada com sucesso!");
                                    } catch (SaldoInsuficienteException e) {
                                        System.out.println("Erro: " + e.getMessage()); // Exibe a mensagem da exceção
                                    }
                                } else {
                                    System.out.println("Senha incorreta ou conta destinatária não encontrada.");
                                }
                                break;
                                // Verifica se o valor da transferência é maior que o saldo da conta
                                

                            case 4:
                                System.out.println("Voltando ao menu principal.");
                                operacoesAtivas = false; // Sai do loop de operações
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Aplicativo fechado.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}

