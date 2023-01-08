package Salao.Beleza;

public class RegistroServico {

    private Servico servico;
    private Funcionario funcionario;
    private Cliente cliente;


    public RegistroServico(Servico servico, Funcionario funcionario) {
        this.servico = servico;
        this.funcionario = funcionario;


    }


    public RegistroServico(Cliente cliente) {
        this.cliente = cliente;

    }

    public RegistroServico() {

    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public Funcionario getFuncionario() {
        return funcionario;

    }
}
