package JavaBank.Banco.Contas;

import JavaBank.Banco.Cliente.Cliente;

public class ContaPoupanca extends Conta {

    @Override
    public void imprimirExtrato(Cliente cliente) {
       System.out.println("=== Extrato Conta Poupança ===");
       super.imprimirInfosComuns();
    }
    public ContaPoupanca(Cliente cliente){
        super(cliente);
    }
    
    
}
