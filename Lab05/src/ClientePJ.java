import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientePJ extends Cliente {
    private final String CNPJ;
    private LocalDate dataFundacao;
    private ArrayList<Frota> listaFrotas;

    //Construtor
    public ClientePJ(String nome, String endereco, String telefone, String email, String CNPJ, LocalDate dataFundacao) {
        super(nome, telefone, endereco, email);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.listaFrotas = new ArrayList<Frota>();
    }

    //Getters e setters
    public String getCnpj() {
        return deixaCNPJarrumado(CNPJ);
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public ArrayList<Frota> getListaFrotas() {
        return listaFrotas;
    }

    public void setListaFrotas(ArrayList<Frota> listaFrotas) {
        this.listaFrotas = listaFrotas;
    }


    //Deixa so numeros no CNPJ
    public String deixaCNPJarrumado(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");
        return cnpj;
    }

    //Cadastrar uma frota
    public boolean cadastrarFrota(Frota nova_frota) {
        for (Frota frota:listaFrotas) {
            if (frota.equals(nova_frota))
                return false;
        }
        listaFrotas.add(nova_frota);
        System.out.println("\nFrota de code " + nova_frota.getCode() + " adicionada com sucesso\n");
        return true;
    }

    //Cadastrar veiculo em uma frota
    private void cadastrarVeiculoEmFrota(Scanner scanner, Frota frota) {

        //Placa
        System.out.print("Digite a placa do veiculo:");
        String placa = scanner.nextLine();
        
        //Marca
        System.out.print("Digite a marca do veiculo:");
        String marca = scanner.nextLine();
        
        //Modelo
        System.out.print("Digite o modelo do veiculo:");
        String modelo = scanner.nextLine();
        
        //Ano de fabricação
        System.out.print("Digite o ano de fabricacao do veiculo:");
        int anoFabricacao = Integer.parseInt(scanner.nextLine());
        System.out.print("\n");
        
        //Criar e adcionar um veiculo  na lista de veículos do cliente, se não ta adicionado ainda
        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao); 
        frota.addVeiculo(veiculo);
    }

    //Metodo para atualizar uma frota
    public boolean atualizarFrota(Scanner scanner) {
        System.out.println("Selecione uma frota: ");
        int i = 1;
        for (Frota frota:listaFrotas) {
            System.out.println(i + " - " + frota.getCode());
            i++;
        }
        int j = scanner.nextInt();
        System.out.println("Selecione uma opcao:\n1- Adicionar veiculo\n2- Remover veiculo\n3- Remover frota");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        switch (opcao) {
            case 1:
                cadastrarVeiculoEmFrota(scanner, listaFrotas.get(j-1));
                break;
            case 2:
                listaFrotas.get(j-1).removeVeiculo(scanner);
                break;
            case 3:
                listaFrotas.remove(listaFrotas.get(j-1));
                System.out.println("\nFrota removida\n");
                break;
            default:
                System.out.println("Resposta invalida. Digite 1, 2 ou 3");
        }
        return true;
    }

    //Metodo de listar os veiculos por frota
    public boolean getVeiculosPorFrota(Scanner scanner) {
        System.out.println("Selecione uma frota: ");
        int i = 1;
        for (Frota frota:listaFrotas) {
            System.out.println(i + " - " + frota.getCode());
            i++;
        }
        int j = scanner.nextInt();
        System.out.println("Veiculos da frota " + listaFrotas.get(j-1).getCode() + ":");
        for (Veiculo veiculo:listaFrotas.get(j-1).getListaVeiculos()) 
            System.out.println(veiculo.getMarca() + " " + veiculo.getMarca() + " (placa: " + veiculo.getPlaca() + ")");
        return true; 
    }


    //Metodo toString de ClientePJ para imprimir
    public String toString() {
        String str = "Dados do ClientePJ\nNome: " + super.getNome() + "\nTelefone: " + super.getTelefone() + "\nEndereco: " + super.getEndereco() + 
                        "\nCNPJ: " + deixaCNPJarrumado(CNPJ) + "\nEmail: " + super.getEmail() + "\nData de fundacao: " + dataFundacao +  " (Ano-Mes-Dia)\n";
        return str;
    }
}