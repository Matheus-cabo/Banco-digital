package JavaBank.Banco.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import JavaBank.Banco.Contas.Conta;

public class Cliente {
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String cpf;  // Alterado para String
    private String login;
    private String senha;
    private List<Conta> contas; // Lista de contas
    private String numeroCelular;  // Alterado para String
    
    // Construtor para facilitar a criação de um cliente

    // Getters e Setters
    public String getNome() {
        return nomeCompleto;
    }

    public void setNome(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    // Método para exibir os dados do cliente
    @Override
    public String toString() {
        return "Cliente: " + nomeCompleto + "\nData de Nascimento: " + dataNascimento + "\nCPF: " + cpf +
               "\nLogin: " + login +  "\nSenha: " + senha + "\nCelular: " + numeroCelular ;
    }
    public Cliente() {
        this.contas = new ArrayList<>();
    }
    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }
    public String nome() {
        return "Cliente: " + nomeCompleto ;
    }
}

