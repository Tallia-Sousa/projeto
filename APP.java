package Salao.Beleza;

import java.util.ArrayList;
import java.util.Scanner;


public class APP {

    static ArrayList<Servico> servicos;
    static ArrayList<Cliente> clientes;
    static ArrayList<RegistroServico> registroServicos;
    private static Cliente cliente;


    static Scanner Entrada = new Scanner(System.in);
    private static Funcionario funcionario;
    private  static Servico servico;


    public static void main(String[] args) {

        servicos = new ArrayList<>();
        clientes = new ArrayList<>();
        registroServicos = new ArrayList<>();


        menu();
    }

    private static void menu() {

        System.out.println("1- cadastrarCliente\n2-cadastroServiço\n3-listarrServico\n4-removerServico\n5-alterarServicos\n6-removerCliente\n7-listar");

        int opcao = Entrada.nextInt();

        switch (opcao) {
            case 1:
                cadastroCliente();
            case 2:
                cadastroServicos();

            case 3:
                listarServicos();

            case 4:
                removerServico();

            case 5:
                alterarServicos();

            case 6:
                removerClientes();

            case 7:
                listarClientes();

            case 8:
                alterarClientes();

            case 9:
                regitroServico();


        }
    }

    private static void cadastroCliente() {
        System.out.println("nome do cliente: ");
        String nome = Entrada.next();
        System.out.println("email do cliente: ");
        String email = Entrada.next();
        System.out.println("sexo do cliente: ");
        String sexo = Entrada.next();
        System.out.println("uf do cliente: ");
        String uf = Entrada.next();
        System.out.println("cidade do cliente: ");
        String cidade = Entrada.next();
        System.out.println("Bairro do cliente: ");
        String bairro = Entrada.next();
        System.out.println("rua do cliente: ");
        String rua = Entrada.next();
        System.out.println("numero da casa do cliente: ");
        int numero = Entrada.nextInt();
        System.out.println("logradourodo cliente: ");
        String logradouro = Entrada.next();
        Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, rua, uf);
        Cliente cliente = new Cliente(nome, email, sexo, endereco);
        RegistroServico registroServico = new RegistroServico(cliente);
        cliente.Adicicona(cliente);
        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso");
        menu();
    }

    private static void cadastroServicos() {
        System.out.println("nome do serviço: ");
       String nomeServico = Entrada.next();
        System.out.println("Nome do Funcionario que faz o serviço: ");
        String funcionario = Entrada.next();
        System.out.println("valor do serviço: ");
        double valor = Entrada.nextDouble();
        System.out.println("Descriçao do serviço: ");
        String descricao = Entrada.next();
        Funcionario Funcionarioo = new Funcionario(funcionario);
        Servico servico = new Servico(nomeServico, descricao, valor,Funcionarioo);
        servicos.add(servico);
        RegistroServico registroServico = new RegistroServico(servico,Funcionarioo);
         servico.Adiciconaa(servico);
        System.out.println("Serviço cadastrado com sucesso");
  menu();
    }

    private static void listarServicos() {
        if (servicos.size() > 0) {
            for (Servico servico : servicos) {
                System.out.println(servico.print());
            }
        } else {
            System.out.println("nao ha serviços para listar");
        }
        menu();

    }

    private static Servico encontraServicos(int codigo) {
        Servico servico = null;
        if (servicos.size() > 0) {
            for (Servico s : servicos) {
                if (s.getCodigo() == codigo) {
                    servico = s;

                }
            }
        }

        return servico;
    }

    private static Cliente encontrarClientes(int codigo) {
        Cliente cliente = null;
        if (clientes.size() > 0) {
            for (Cliente c : clientes) {
                if (c.getCodigo() == codigo) {
                    cliente = c;

                }
            }
        }
        return cliente;
    }

    public static void removerServico() {
        System.out.println(" Digite o codigo para ser encontrado:  ");
        int codigo = Entrada.nextInt();
        Servico servico = encontraServicos(codigo);
        if (servico != null) {
            servico.remover(servico, codigo);

        }
        menu();
    }

    public static void alterarServicos() {


        System.out.println(" Digite o codigo do serviço para ser alterado :  ");
        int codigo = Entrada.nextInt();
        Servico servico = encontraServicos(codigo);
        if (servico != null) {
            System.out.println(" digite o novo nome do serviço:  ");
            String nomee = Entrada.next();
            System.out.println(" digite a novo nome do funcionario para ser alterado:  ");
            String nomefuncionario = Entrada.next();
            System.out.println(" digite o novo valor do servico que deseja alterar:  ");
            double novovalor = Entrada.nextDouble();
            System.out.println(" digite a nova descricao do servico que deseja alterar:  ");
            String descricao = Entrada.next();
            servico.alterar(servico, codigo, nomee, novovalor, descricao, nomefuncionario);


        }

        menu();
    }

    private static void removerClientes() {
        System.out.println("codigo do cliente: ");
        int codigo = Entrada.nextInt();
        Cliente cliente = encontrarClientes(codigo);
        if (cliente != null) {
            cliente.removerClientes(cliente, codigo);

        }

        menu();
    }

    private static void alterarClientes() {
        System.out.println("Digite o codigo do cliente que deseja alterar");
        int codigo = Entrada.nextInt();
        Cliente cliente = encontrarClientes(codigo);
        if (cliente != null) {
            System.out.println("Digite o novo nome para ser alterado: ");
            String nomeee = Entrada.next();
            System.out.println("Digite o novo email para ser alterado: ");
            String email = Entrada.next();
            System.out.println("sexo do cliente para ser alterado : ");
            String sexoo = Entrada.next();
            System.out.println("Digite o novo uf do cliente para ser alterado: ");
            String uf = Entrada.next();
            System.out.println("Digite a nova cidade do cliente para ser alterada: ");
            String cidade = Entrada.next();
            System.out.println("Digite o novo Bairro do cliente para ser alterado: ");
            String bairro = Entrada.next();
            System.out.println("Digite a nova rua do rua do cliente para ser alterado: ");
            String rua = Entrada.next();
            System.out.println("Digite o novo numero da casa do cliente para ser alterado: ");
            int numero = Entrada.nextInt();
            System.out.println("Digite o novo logradourodo cliente para ser alterado: ");
            String logradouro = Entrada.next();
            cliente.alterarClientes(cliente, codigo, nomeee, email, sexoo, numero, bairro, cidade, uf, logradouro, rua);
        } else {
            System.out.println("Não foi possivel fazer a alteração");
        }
        menu();
    }

    private static void listarClientes() {
        if (clientes.size() > 0) {
            for (Cliente cliente : clientes) {
                System.out.println(cliente.print());
            }
        } else {
            System.out.println("nao ha serviços para listar");
        }
        menu();

    }
    private static void regitroServico(){
        if(registroServicos.size() > 0){
            for(RegistroServico registroServico: registroServicos){
                System.out.println(registroServico);
            }
        }
        menu();
    }
    //private static void regitroServico(){
    //}

}