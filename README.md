# Criando um Banco Digital com Java e Orientação a Objetos

Desafio: Desafio proposto pela DIO, onde o foco é praticar o conhecimento em Programação orientada a objeto com Java. 

O intuito sugerido, foi construir um banco digital, com quase todas as funcionalidades em que um sistema bancário pode oferecer para o usuário

## Objetivo
* A construção do banco, foi elaborada com 6 classes e 1 interface, no qual foi usado conceitos de POO, obdecendo as regas de sintaxe e semântica da linguagem Java.

* O JavaBank, nome em que foi dado ao sistema, possui o mecanismo de cadastro pessoal do usuário, onde é pedido, nome, cpf, data de nascimento, login, senha e o numero do celular. Logo após isso, é criado uma conta para o usuário de acordo com o login e senha escolhido pelo o mesmo, gerando atráves do banco uma agência e conta.

Além disso, é possivel depositar, sacar e transferir de conta corrente para uma conta poupança e vice versa, bem como, transferir valores entre usuários cadastrados.

## Funcionalidade

### ``Cliente (classe Cliente)``
A classe Cliente representa um cliente do banco. Ela possui os seguintes atributos:

- nomeCompleto: O nome completo do cliente.
dataNascimento: A data de nascimento do cliente.
- cpf: O CPF do cliente (alterado para tipo String).
- login: O nome de login para o cliente acessar sua conta.
- senha: A senha associada ao login.
- contas: Uma lista que armazena as contas associadas ao cliente.
- numeroCelular: O número de celular do cliente.
#### Métodos:

- getters e setters: Métodos para acessar e modificar os atributos da classe.
- adicionarConta(Conta conta): Adiciona uma conta à lista de contas do cliente.
- toString(): Exibe os dados do cliente de maneira formatada.
- nome(): Retorna o nome do cliente em uma string.

### ``Conta (classe abstrata Conta)``
A classe Conta é abstrata e define a estrutura de uma conta bancária. Ela possui os seguintes atributos:

- agencia: O número da agência onde a conta foi aberta (fixo como 1).
- numero: O número da conta, gerado automaticamente.
- saldo: O saldo atual da conta.
- cliente: O cliente associado à conta.
#### Métodos:

- sacar(double valor): Realiza um saque, subtraindo o valor do saldo.
- depositar(double valor): Realiza um depósito, somando o valor ao saldo.
- transferir(double valor, Conta contaDestino): Realiza uma transferência para outra conta, verificando se há saldo suficiente.
- verificarCredenciais(int agencia, int numero, String senha): Verifica se os dados de acesso estão corretos.
- imprimirInfosComuns(): Exibe as informações comuns da conta (agência, número, saldo, e nome do titular).
- toString(): Retorna uma representação string da conta

### ``ContaCorrente (classe ContaCorrente)``
A classe ContaCorrente estende a classe Conta e representa uma conta corrente. Ela possui o método:

- imprimirExtrato(Cliente cliente): Exibe o extrato da conta corrente do cliente, chamando o método de informações comuns da classe Conta.

### ``ContaPoupanca (classe ContaPoupanca)``
A classe ContaPoupanca também estende a classe Conta e representa uma conta poupança. Ela possui o método:

- imprimirExtrato(Cliente cliente): Exibe o extrato da conta poupança do cliente, chamando o método de informações comuns da classe Conta.

### ``IConta (interface IConta)``
A interface IConta define os métodos que qualquer tipo de conta (como ContaCorrente e ContaPoupanca) deve implementar. Ela contém os seguintes métodos:

- sacar(double valor): Realiza um saque.
- depositar(double valor): Realiza um depósito.
- transferir(double valor, Conta contaDestino): Realiza uma transferência.
- imprimirExtrato(Cliente cliente): Imprime o extrato da conta.

### ``SaldoInsuficienteException (classe SaldoInsuficienteException)``
A classe SaldoInsuficienteException é uma exceção personalizada que é lançada quando um cliente tenta transferir um valor superior ao saldo da conta. Ela herda de Exception e recebe uma mensagem de erro ao ser instanciada.

### ``JavaBank (classe JavaBank)``
A classe JavaBank é a principal do sistema bancário, que funciona como a interface de interação com o usuário. Ela contém um menu com várias opções, incluindo:

- Registrar um novo cliente: Onde os dados do cliente, como nome, CPF, data de nascimento, login, senha e número de celular são registrados.
- Login: O cliente pode realizar o login usando sua agência, número da conta e senha.
- Operações bancárias: Após o login, o cliente pode acessar suas contas e realizar operações como:
    - Ver extrato da conta.
    - Depositar valores.
    - Transferir dinheiro para outra conta.

O fluxo de interações é baseado em entradas do usuário via Scanner.
