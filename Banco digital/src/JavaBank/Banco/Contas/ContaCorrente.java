package JavaBank.Banco.Contas;

import JavaBank.Banco.Cliente.Cliente;

public class ContaCorrente extends Conta {

    @Override
    public void imprimirExtrato(Cliente cliente) {
       System.out.println("=== Extrato Conta Corrente ===");
       super.imprimirInfosComuns();
       
    }
    public ContaCorrente(Cliente cliente){
        super(cliente);
    }
    
    
}
