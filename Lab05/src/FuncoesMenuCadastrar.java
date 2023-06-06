import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncoesMenuCadastrar {

    //Cadastrar clientePF
    public static ClientePF cadastrarClientePF(Scanner scanner, ArrayList<Seguradora> listaSeguradora, int indexSeguradora) {
    	
        //Receber dados de um clientePF pela System.in e o cria
        System.out.println("Cadastro de Pessoa Fisica");
        scanner.nextLine();
        
        //Nome
        String nome = "";
        boolean auxiliar = true;
        while (auxiliar) {
            System.out.print("Digite o nome do cliente: ");
            nome = scanner.nextLine();
            if (Validacao.validarNome(nome))
                auxiliar = false;
            else    
                System.out.print("Nome invalido ");
        }
        
        //Endereço
        System.out.print("Digite o endereco do cliente: ");
        String endereco = scanner.nextLine();
        
        //CPF
        String CPF = "";
        boolean auxiliar2 = true;
        while (auxiliar2) {
            System.out.print("Digite o CPF do cliente: ");
            CPF = scanner.nextLine();
            if (Validacao.validarCPF(CPF))
                auxiliar2 = false;
            else    
                System.out.print("CPF invalido ");
        }
        
        //Genero
        System.out.print("Digite o genero do cliente: ");
        String genero = scanner.nextLine();
        
        //Email
        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();
        
        //Educação
        System.out.print("Digite o nivel de educação do cliente: ");
        String educacao = scanner.nextLine();
        
        //Data de Nascimento
        System.out.print("Digite o ANO da data de nascimento do cliente: ");
        String anoN = scanner.nextLine();
        System.out.print("Digite o MES da data de nascimento do cliente: ");
        String mesN = scanner.nextLine();
        System.out.print("Digite o DIA da data de nascimento do cliente: ");
        String diaN = scanner.nextLine();    
        LocalDate dataNascimento = LocalDate.parse(anoN+"-"+mesN+"-"+diaN);
        
        //Telefone
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        
        //Gera um clientePF
        ClientePF cliente = new ClientePF(nome, endereco, CPF, telefone, email, genero, educacao, dataNascimento);
        listaSeguradora.get(indexSeguradora).cadastrarCliente(cliente);
        
        //Retorna esse cliente
        return cliente;
    }

    //Cadastra clientePJ
    public static ClientePJ cadastrarClientePJ(Scanner scanner, ArrayList<Seguradora> listaSeguradora, int indexSeguradora) {
    	
        //Receber dados de um clientePJ pela System.in e o cria
        System.out.println("Cadastro de Pessoa Juridica");
        scanner.nextLine();
        
        //Nome
        String nome = "";
        boolean auxiliar = true;
        while (auxiliar) {
            System.out.print("Digite o nome do cliente: ");
            nome = scanner.nextLine();
            if (Validacao.validarNome(nome))
                auxiliar = false;
            else    
                System.out.print("Nome invalido");
        }
        
        //Endereco
        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        
        //CNPJ
        String CNPJ = "";
        boolean auxiliar2 = true;
        while (auxiliar2) {
            System.out.print("Digite o CNPJ do cliente: ");
            CNPJ = scanner.nextLine();
            if (Validacao.validarCNPJ(CNPJ))
                auxiliar2 = false;
            else    
                System.out.print("CNPJ invalido");
        }
        
        //Data de fundacao
        System.out.print("Digite o ANO da data de fundacao do cliente: ");
        String anoF = scanner.nextLine();
        System.out.print("Digite o MES da data de fundacao do cliente: ");
        String mesF = scanner.nextLine();
        System.out.print("Digite o DIA da data de fundacao do cliente: ");
        String diaF = scanner.nextLine();    
        LocalDate dataFundacao = LocalDate.parse(anoF+"-"+mesF+"-"+diaF);
        
        //Telefone
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        
        //Email
        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();
        System.out.print("\n");
        
        //Gerar um clientePJ
        ClientePJ cliente = new ClientePJ(nome, endereco, telefone, email, CNPJ, dataFundacao);
        listaSeguradora.get(indexSeguradora).cadastrarCliente(cliente);
        
        //Retorna o cliente
        return cliente;
    }

    //Reunir cadastrarClientePF e cadastrarClientePJ para cadastrar UM cliente
    public static void cadastrarCliente(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        scanner.nextLine();
        System.out.print("Qual o tipo de cliente que deseja cadastrar? PF ou PJ ");
        String tipo = scanner.nextLine();       
        int indexSeguradora = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        if (tipo.equals("PF"))
            cadastrarClientePF(scanner, listaSeguradora, indexSeguradora);
        else if (tipo.equals("PJ"))
            cadastrarClientePJ(scanner, listaSeguradora, indexSeguradora);
        else {
            System.out.println("Resposta invalida");
            cadastrarCliente(scanner, listaSeguradora);
        }
    }
    
    //Metodo de adicao de veiculo
    public static boolean cadastrarVeiculo(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
    	
        int i = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int j = AppMain.selecionarCliente(scanner, listaSeguradora.get(i));
        scanner.nextLine();
        
        //Placa
        System.out.print("Digite a placa do veiculo:");
        String placa = scanner.nextLine();
        
        //Marca
        System.out.print("Digite a marca do veiculo:");
        String marca = scanner.nextLine();
        
        //Modelo
        System.out.print("Digite o modelo do veiculo:");
        String modelo = scanner.nextLine();
        
        //Ano de fabricacao
        System.out.print("Digite o ano de fabricacao do veiculo:");
        int anoFabricacao = Integer.parseInt(scanner.nextLine());
        System.out.print("\n");
        
        //Cria e adiciona um veiculo na lista de veículos do cliente, se nao ta adicionado ainda
        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao); 
        if (listaSeguradora.get(i).getListaClientes().get(j) instanceof ClientePF) {
            ((ClientePF) listaSeguradora.get(i).getListaClientes().get(j)).cadastrarVeiculo(veiculo);
            return true;
        }
        else if (listaSeguradora.get(i).getListaClientes().get(j) instanceof ClientePJ) {
            int c = AppMain.selecionarFrota(scanner, listaSeguradora.get(i).getListaClientes().get(j));
            ((ClientePJ) listaSeguradora.get(i).getListaClientes().get(j)).getListaFrotas().get(c).addVeiculo(veiculo);
        }
        return true;
    }
    
    //Cadastra uma seguradora
    public static Seguradora cadastrarSeguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
    	
        //Receber dados de uma seguradora pela System.in e o cria
        System.out.println("Cadastro de Seguradora");
        scanner.nextLine();
        
        //Nome
        String nome = "";
        boolean auxiliar = true;
        while (auxiliar) {
            System.out.print("Digite o nome da seguradora: ");
            nome = scanner.nextLine();
            if (Validacao.validarNome(nome))
                auxiliar = false;
            else    
                System.out.print("Nome invalido");
        }
        
        //Endereço
        System.out.print("Digite o endereco da seguradora:");
        String endereco = scanner.nextLine();
        
        //Telefone
        System.out.print("Digite o telefone da seguradora:");
        String telefone = scanner.nextLine();
        
        //Email
        System.out.print("Digite o email da seguradora:");
        String email = scanner.nextLine();
        
        //CNPJ
        String CNPJ = "";
        boolean auxiliar2 = true;
        while (auxiliar2) {
            System.out.print("Digite o CNPJ da seguradora:");
            CNPJ = scanner.nextLine();
            if (Validacao.validarCNPJ(CNPJ))
                auxiliar2 = false;
            else    
                System.out.print("CNPJ invalido");
        }
        
        //Criar e adcionar seguradora na lista de seguradoras
        Seguradora seguradora = new Seguradora(nome, telefone, email, endereco, CNPJ);
        listaSeguradora.add(seguradora);
        System.out.println("\nSeguradora cadastrada com sucesso\n");
        
        //Retorna a seguradora
        return seguradora;
    }

    //Cadastrar um seguro
    public static void cadastrarSeguro(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int i = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        scanner.nextLine();
        listaSeguradora.get(i).gerarSeguro(scanner);
    }

    //Cadastrar uma frota
    public static boolean cadastrarFrota(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        System.out.println("Cadastro de Frota:");
        int i = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int j = AppMain.selecionarCliente(scanner, listaSeguradora.get(i));
        scanner.nextLine();
        if (listaSeguradora.get(i).getListaClientes().get(j) instanceof ClientePJ) {
            System.out.print("Digite o code da frota: ");
            String code = scanner.nextLine();
            Frota novaFrota = new Frota(code);
            for (Frota frota:((ClientePJ) listaSeguradora.get(i).getListaClientes().get(j)).getListaFrotas()) {
                if (frota.getCode().equals(novaFrota.getCode())) {
                    System.out.println("Uma frota com code " + novaFrota.getCode() + " já esta cadastrada");
                    cadastrarFrota(scanner, listaSeguradora);
                    return false;
                }
            }
            ((ClientePJ) listaSeguradora.get(i).getListaClientes().get(j)).getListaFrotas().add(novaFrota);
        }
        return true;
    }

    //Metodo para cadastrar condutor
    public static boolean cadastrarCondutor(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int i = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int j = AppMain.selecionarSeguro(scanner, listaSeguradora.get(i));
        scanner.nextLine();
        //CPF
        String CPF = "";
        boolean auxiliar = true;
        while (auxiliar) {
            System.out.print("Digite o CPF do(a) condutor(a): ");
            CPF = scanner.nextLine();
            if (Validacao.validarCPF(CPF))
                auxiliar = false;
            else    
                System.out.print("CPF invalido! ");
        }
        //Nome
        String nome = "";
        boolean auxiliar2 = true;
        while (auxiliar2) {
            System.out.print("Digite o nome do(a) condutor(a): ");
            nome = scanner.nextLine();
            if (Validacao.validarNome(nome))
                auxiliar2 = false;
            else    
                System.out.print("Nome invalido");
        }
        //Telefone
        System.out.print("Digite o telefone do condutor:");
        String telefone = scanner.nextLine();
        //Endereco
        System.out.print("Digite o endereco do condutor:");
        String endereco = scanner.nextLine();        
        //Email
        System.out.print("Digite o email do condutor:");
        String email = scanner.nextLine();
        //Data de nascimento
        System.out.print("Digite o ANO da data de nascimento do condutor:");
        String ano = scanner.nextLine();
        System.out.print("Digite o MES da data de nascimento do condutor:");
        String mes = scanner.nextLine();
        System.out.print("Digite o DIA da data de nascimento do condutor:");
        String dia = scanner.nextLine();    
        LocalDate data = LocalDate.parse(ano+"-"+mes+"-"+dia);

        //Criar e cadastrar condutor
        Condutor novoCondutor = new Condutor(CPF, nome, telefone, endereco, email, data);
        if (listaSeguradora.get(i).getListaSeguros().get(j) instanceof SeguroPF)
            ((SeguroPF) listaSeguradora.get(i).getListaSeguros().get(j)).autorizarCondutor(novoCondutor);
        else if (listaSeguradora.get(i).getListaSeguros().get(j) instanceof SeguroPJ)
            ((SeguroPJ) listaSeguradora.get(i).getListaSeguros().get(j)).autorizarCondutor(novoCondutor);
        return true;
    }

}