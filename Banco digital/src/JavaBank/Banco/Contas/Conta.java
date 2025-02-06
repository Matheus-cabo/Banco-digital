package JavaBank.Banco.Contas;

import JavaBank.Banco.Cliente.Cliente;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRÃO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    private Cliente cliente;
    

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRÃO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }
    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }
    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }
    @Override
    public void transferir(double valor, Conta contaDestino)throws SaldoInsuficienteException {
        if(this.saldo < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
    
    public int getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titutlo: %s",this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d",this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
    @Override
    public String toString() {
        return " [agencia: " + agencia + ", numero: " + numero + ", saldo: " + saldo + ", cliente: " + cliente + "]";
    }
    public boolean verificarCredenciais(int agencia, int numero, String senha) {
        return this.agencia == agencia && this.numero == numero && this.cliente.getSenha().equals(senha);
    }
    public Cliente getCliente() {
        return cliente;
    }
   
}
