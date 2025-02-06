package JavaBank.Banco.Contas;

import JavaBank.Banco.Cliente.Cliente;

public interface IConta  {
    void sacar(double valor);
    void depositar(double valor);
    void transferir (double valor, Conta contaDestino) throws SaldoInsuficienteException;
    void imprimirExtrato(Cliente cliente);
}