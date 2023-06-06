import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

class AppMain {

    //Mostra as seguradoras que poder ser selecionadas e retorna o indice em listaSeguradora
    public static int selecionarSeguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        System.out.println("Selecione uma seguradora: ");
        int cont = 1;
        for (Seguradora seguradora:listaSeguradora) {
            System.out.println(cont + " - " + seguradora.getNome());
            cont++;
        }
        int cont2 = scanner.nextInt();
        return (cont2-1);
    }

    //Mostra os clientes que podem ser selecionados e retorna o indice em listaClientes
    public static int selecionarCliente(Scanner scanner, Seguradora seguradora) {
        System.out.println("Selecione um cliente: ");
        int cont = 1;
        for (Cliente cliente:seguradora.getListaClientes()) {
            System.out.println(cont + " - " + cliente.getNome());
            cont++;
        }
        int cont2 = scanner.nextInt();
        return (cont2-1);
    }

    //Mostrar os sinistros que podem ser selecionados e retornar o indice em listaSinistros
    public static int selecionarSinistro(Scanner scanner, Condutor condutor) {
        System.out.println("Selecione um sinistro: ");
        int cont = 1;
        for (Sinistro sinistro:condutor.getListaSinistros()) {
            System.out.println(cont + " - " + sinistro.getId() + ", de " + sinistro.getCondutor().getNome() + " na data " + sinistro.getData() + "(ano-mes-dia)");
            cont++;
        }
        int cont2 = scanner.nextInt();
        return (cont2-1);
    }

    //Mostra os condutores que podem ser selecionados e retorna o indice em listaCondutores
    public static int selecionarCondutor(Scanner scanner, Seguro seguro) {
        System.out.println("Selecione um condutor: ");
        int cont = 1;
        for (Condutor condutor:seguro.getListaCondutores()) {
            System.out.println(cont + " - " + condutor.getNome() + " | CPF " + condutor.getCpf());
            cont++;
        }
        int cont2 = scanner.nextInt();
        return (cont2-1);
    }    

    //Mostra os veiculos que podem ser selecionados e retorna o indice em listaVeiculos
    public static int selecionarVeiculo(Scanner scanner, Cliente cliente) {
        System.out.println("Selecione um veiculo:");
        int cont = 1;
        if (cliente instanceof ClientePF) {
            for (Veiculo veiculo:((ClientePF) cliente).getListaVeiculos()) {
                System.out.println(cont + " - " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ")");
            }
            cont++;
        }
        else if (cliente instanceof ClientePJ) {
            int cont2 = selecionarFrota(scanner, cliente);
            for (Veiculo veiculo:((ClientePJ) cliente).getListaFrotas().get(cont2).getListaVeiculos()) {
                System.out.println(cont + " - " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ")");
            }
        }
        int cont3 = scanner.nextInt();
        return (cont3-1);        
    }

    //Mostra as frotas que podem ser selecionados e retorna o indice em listaFrota
    public static int selecionarFrota(Scanner scanner, Cliente cliente) {
        System.out.println("Selecione uma frota:");
        int cont = 1;
        for (Frota frota:((ClientePJ) cliente).getListaFrotas()) {
            System.out.println(cont + " - " + frota.getCode());
            cont++;
        }
        int cont2 = scanner.nextInt();
        return (cont2-1);        
    }    

    //Mostra os seguros que podem ser selecionados e retorna o indice em listaCondutores
    public static int selecionarSeguro(Scanner scanner, Seguradora seguradora) {
        System.out.println("Selecione um seguro:");
        int cont = 1;
        for (Seguro seguro:seguradora.getListaSeguros()) {
            if (seguro instanceof SeguroPF) {
                System.out.println(cont + " - ID " + seguro.getId() + " | Nome " + ((SeguroPF) seguro).getCliente().getNome() + " | CPF " + ((SeguroPF) seguro).getCliente().getCpf());
            }
            else if (seguro instanceof SeguroPJ) {
                System.out.println(cont + " - ID " + seguro.getId() + " | Nome " + ((SeguroPJ) seguro).getCliente().getNome() + " | CNPJ " + ((SeguroPJ) seguro).getCliente().getCnpj());
            }
            cont++;
        }
        int cont2 = scanner.nextInt();
        return (cont2-1);        
    }        


    public static void main(String[] args) {

        //Criar um objeto da classe Scanner, utilizado para realizar a leitura de dados
        Scanner scanner = new Scanner(System.in);

        //Criar uma lista com todas as seguradoras existentes
        ArrayList<Seguradora> listaSeguradora = new ArrayList<Seguradora>();

        //Instanciar um objeto da classe Seguradora
        Seguradora seguradora1 = new Seguradora("Seguradora 1", "19 99999-9999", "seguradora1@gmail,com", "Rua 1", "46.815.230/0001-00");

        //Instanciando objetos das classes ClientePF e ClientePJ
        ClientePF clientePF1 = new ClientePF("1 da Silva", "Rua 1", "453.410.718-83", "111111111", "email1@gmail.com", "Genero M", "Nivel 1", LocalDate.parse("2023-06-05"));
        ClientePF clientePF2 = new ClientePF("2 da Silva", "Rua 2", "730.404.607-49", "22222222222", "email2@gmail.com", "Genero F", "Nivel 2", LocalDate.parse("2009-02-02"));
        ClientePJ clientePJ1 = new ClientePJ("3 da Silva", "Rua 3", "33333333333", "email3@gmail.com", "52.558.916/0001-65", LocalDate.parse("2003-03-03"));
        ClientePJ clientePJ2 = new ClientePJ("4 da Silva", "Rua 4", "44444444444", "email4@gmail.com", "72.172.882/0001-83", LocalDate.parse("2004-04-04"));

        //Instanciar objetos da classe Veiculo
        Veiculo veiculo1 = new Veiculo("AAA1111", "Marca Uno", "Modelo 01", 2011);
        Veiculo veiculo2 = new Veiculo("BBB2222", "Marca Dos", "Modelo 02", 2012);
        Veiculo veiculo3 = new Veiculo("CCC3333", "Marca Tres", "Modelo 03", 2013);
        Veiculo veiculo4 = new Veiculo("DDD4444", "Marca Cuatro", "Modelo 04", 2014);
        Veiculo veiculo5 = new Veiculo("EEE5555", "Marca Cinco", "Modelo 05", 2015);
        Veiculo veiculo6 = new Veiculo("FFF6666", "Marca Seis", "Modelo 06", 2016);
        Veiculo veiculo7 = new Veiculo("GGG7777", "Marca Siete", "Modelo 07", 2017);
        Veiculo veiculo8 = new Veiculo("HHH8888", "Marca Ocho", "Modelo 08", 2018);
        Veiculo veiculo9 = new Veiculo("III9999", "Marca Nueve", "Modelo 09", 2019);

        //Instanciar objetos da classe Frota
        Frota frota1 = new Frota("Code 1");
        Frota frota2 = new Frota("Code 2");
        Frota frota3 = new Frota("Code 3");

        //Adicionando os veiculos/frotas aos clientes
        clientePJ1.cadastrarFrota(frota1);
        clientePJ1.cadastrarFrota(frota2);
        clientePJ2.cadastrarFrota(frota3);
        clientePF1.cadastrarVeiculo(veiculo1);
        clientePF2.cadastrarVeiculo(veiculo2);
        clientePF2.cadastrarVeiculo(veiculo3);
        clientePF1.cadastrarVeiculo(veiculo7);
        clientePF2.cadastrarVeiculo(veiculo8);
        frota1.addVeiculo(veiculo4);
        frota1.addVeiculo(veiculo6);
        frota2.addVeiculo(veiculo9);
        frota3.addVeiculo(veiculo5);

        //Cadastrar em seguradora1 os clientes que foram gerados 2 de cada
        seguradora1.cadastrarCliente(clientePF1);
        seguradora1.cadastrarCliente(clientePF2);
        seguradora1.cadastrarCliente(clientePJ1);
        seguradora1.cadastrarCliente(clientePJ2);

        //Instanciar objetos da classe Seguro
        seguradora1.gerarSeguro(scanner); //Recomendo que selecione ClientePF1 (Nome 1) como dono
        seguradora1.gerarSeguro(scanner); //Recomendo que selecione ClientePF2 (Nome 2) como dono
        seguradora1.gerarSeguro(scanner); //Recomendo que selecione ClientePJ1 (Nome 3) como dono

        //Instranciar objetos da classe Condutor
        Condutor condutor1 = new Condutor(clientePF1.getCpf(), clientePF1.getNome(), clientePF1.getTelefone(), clientePF1.getEndereco(), clientePF1.getEmail(), clientePF1.getDataNascimento());
        Condutor condutor2 = new Condutor(clientePF2.getCpf(), clientePF2.getNome(), clientePF2.getTelefone(), clientePF2.getEndereco(), clientePF2.getEmail(), clientePF2.getDataNascimento());
        Condutor condutor3 = new Condutor("77148613639", "5 da Silva", "55 555555555", "Rua 5", "email5@gmail.com", LocalDate.parse("2005-05-05"));
        Condutor condutor4 = new Condutor("64361784140", "6 da Silva", "66 666666666", "Rua 6", "email6@gmail.com", LocalDate.parse("2006-06-06"));
        Condutor condutor5 = new Condutor("286.385.848-30", "7 da Silva", "77 777777777", "Rua 7", "email7@gmail.com", LocalDate.parse("2007-07-07"));
        Condutor condutor6 = new Condutor("510.622.551-51", "8 da Silva", "88 888888888", "Rua 8", "email8@gmail.com", LocalDate.parse("2008-08-08"));
        Condutor condutor7 = new Condutor("224.357.466-79", "9 da Silva", "99 999999999", "Rua 9", "email9@gmail.com", LocalDate.parse("2009-09-09"));
        Condutor condutor8 = new Condutor("781.950.417-01", "10 da Silva", "10 101010101", "Rua 10", "email10@gmail.com", LocalDate.parse("2010-10-10"));

        //Adicionar condutores aos seguros
        ((SeguroPF) seguradora1.getListaSeguros().get(0)).autorizarCondutor(condutor1);
        ((SeguroPF) seguradora1.getListaSeguros().get(1)).autorizarCondutor(condutor2);
        ((SeguroPF) seguradora1.getListaSeguros().get(0)).autorizarCondutor(condutor3);
        ((SeguroPF) seguradora1.getListaSeguros().get(1)).autorizarCondutor(condutor4);
        ((SeguroPF) seguradora1.getListaSeguros().get(1)).autorizarCondutor(condutor5);
        ((SeguroPJ) seguradora1.getListaSeguros().get(2)).autorizarCondutor(condutor6);
        ((SeguroPJ) seguradora1.getListaSeguros().get(2)).autorizarCondutor(condutor7);
        ((SeguroPJ) seguradora1.getListaSeguros().get(2)).autorizarCondutor(condutor8);

        //Gerar sinistros
        ((SeguroPF) seguradora1.getListaSeguros().get(0)).gerarSinistro(scanner);
        ((SeguroPF) seguradora1.getListaSeguros().get(1)).gerarSinistro(scanner);
        ((SeguroPJ) seguradora1.getListaSeguros().get(2)).gerarSinistro(scanner);

        //Listar os clientes de seguradora1
        seguradora1.listarClientes("PF");
        seguradora1.listarClientes("PJ");

        //Calcular o valor da receita e atualizar o atributo valorSeguro de cada cliente cadastrado na seguradora
        System.out.println("Receita da Seguradora 1: " + seguradora1.calcularReceita() + "\n");

        //Imprimir os dados com método toString()
        System.out.println(clientePF1);
        System.out.println(clientePJ1);
        System.out.println(condutor1);
        System.out.println(frota1);
        System.out.println(seguradora1);
        System.out.println(seguradora1.getListaSeguros().get(0));
        System.out.println(seguradora1.getListaSeguros().get(2));
        System.out.println(seguradora1.getListaSeguros().get(0).getListaSinistros().get(0));
        System.out.println(veiculo1);

        //Adicionar seguradora1 na lista de seguradoras
        listaSeguradora.add(seguradora1);

        //Chamar o menu de operacoes
        MenuOperacoes op;
		do {
			FuncoesMenu.exibirMenuExterno(scanner, listaSeguradora);
			op = FuncoesMenu.lerOpcaoMenuExterno(scanner);
			FuncoesMenu.executarOpcaoMenuExterno(op, scanner, listaSeguradora);
		} while(op != MenuOperacoes.SAIR);
		System.out.println("Quitou do sistema\n");

    }
}
