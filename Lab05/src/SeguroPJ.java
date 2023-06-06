import java.time.LocalDate;
import java.util.Scanner;
import java.time.temporal.*;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;
    
    //Construtor
    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFim, seguradora);
        this.frota = frota;
        this.cliente = cliente;
    }

    //Getters e setters
    public Frota getFrota() {
        return frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public ClientePJ getCliente() {
        return cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }
    
    //Metodo para desautorizar condutor
    public boolean desautorizarCondutor(Scanner scanner) {
    	
    //Os condutores sao apresentados e o usuario seleciona UM para remover de listaCondutores 
        System.out.println("Selecione condutor: ");
        int i = 1;
        for (Condutor condutor:super.getListaCondutores()) {
            System.out.println(i + " - " + condutor.getNome() + " (CPF " + condutor.getCpf() + ")");
            i++;
        }
        int j = scanner.nextInt();
        System.out.println("\nCondutor " + super.getListaCondutores().get(j-1).getNome() + " desautorizado\n");
        super.getListaCondutores().remove(j-1);
        calcularValor();
        return true;
    }

    //Metodo para adicionar sinistro
    public void gerarSinistro(Scanner scanner) {

        //Data
        System.out.print("Digite o ANO da data do sinistro: ");
        String anoS = scanner.nextLine();
        System.out.print("Digite o MES da data do sinistro: ");
        String mesS = scanner.nextLine();
        System.out.print("Digite o DIA da data do sinistro: ");
        String diaS = scanner.nextLine();    
        LocalDate data = LocalDate.parse(anoS+"-"+mesS+"-"+diaS);
        
        //Endereço
        System.out.print("Digite o endereco do sinistro: ");
        String endereco = scanner.nextLine();
        
        //Condutor
        System.out.println("Selecione um condutor: ");
        int i = 1;
        for (Condutor condutor:super.getListaCondutores()) {
            System.out.println(i + " - " + condutor.getNome() + " (CPF " + condutor.getCpf() + ")");
            i++;
        }
        int j = scanner.nextInt();

        //Criando e adicionando em listaSinistros do seguro e do condutor
        Sinistro novoSinistro = new Sinistro(data, endereco, super.getListaCondutores().get(j-1), this);
        super.getListaSinistros().add(novoSinistro); 
        super.getListaCondutores().get(j-1).getListaSinistros().add(novoSinistro);
        calcularValor();
        System.out.println("\nSinistro adicionado\n");   
        scanner.nextLine();      
    }

    //Metodo para autorizar condutor
    public boolean autorizarCondutor(Condutor novo_condutor) {
        for (Condutor condutor:super.getListaCondutores()) {
            if (condutor.equals(novo_condutor))
                return false;
        }
        super.getListaCondutores().add(novo_condutor);
        calcularValor();
        System.out.println("\nCondutor " + novo_condutor.getNome() + " autorizado\n");
        return true;
    }

    // Parametros para Funcao calculavor
    public double calcularValor() {  
        long idade = ChronoUnit.YEARS.between(cliente.getDataFundacao(), LocalDate.now());
        int AnosPosFundacao = Math.toIntExact(idade);
        int quantidadeSinistrosCondutores = 0;//Quantidade de sinistros de todos os condutores desse seguro
        int quantidadeSinistrosCliente = super.getListaSinistros().size(); //Quantidade de sinistros desse cliente
        for (Condutor condutor:super.getListaCondutores()) {
            quantidadeSinistrosCondutores += condutor.getListaSinistros().size();
        }

        double valor = CalcValor.VALOR_BASE.getValor() * (10 + super.getListaCondutores().size()/10) * (1 + 1/(frota.getListaVeiculos().size()+2)) *
                            (1 + 1/(AnosPosFundacao+2)) * (2 + quantidadeSinistrosCliente/10) * (5 + quantidadeSinistrosCondutores/10);
        super.setValorMensal(valor);
        return valor;
    }  

    //Método toString de SeguroPJ
    public String toString() {
        String str = super.toString() + "\nFrota " + frota.getCode() + ":\n";
        for (Veiculo veiculo:frota.getListaVeiculos()) 
            str = str + veiculo.getMarca() + " " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ") |\n";
        str = str + "Cliente: " + cliente.getNome() + " (CNPJ: " + cliente.getCnpj() + ")\n";
        return str;
    }
}