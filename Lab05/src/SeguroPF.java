import java.time.LocalDate;
import java.util.Scanner;
import java.time.temporal.*;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;
    
    //Construtor
    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
        super(dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //Getters e setters
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    //Método para desautorizar condutor
    public boolean desautorizarCondutor(Scanner scanner) {
    	
        //Os condutores são apresentados e o usuário seleciona UM para remover de listaCondutores 
        System.out.println("Selecione o condutor: ");
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

    //Parametros para Funcao calculaValor
    public double calcularValor() {  
        long idade1 = ChronoUnit.YEARS.between(cliente.getDataNascimento(), LocalDate.now());
        int idade = Math.toIntExact(idade1);
        int quantidadeSinistrosCondutores = 0;//Quantidade de sinistros de todos os condutores desse seguro
        int quantidadeSinistrosCliente = 0; //Quantidade de sinistros apenas desse cliente
        for (Condutor condutor:super.getListaCondutores()) {
            quantidadeSinistrosCondutores += condutor.getListaSinistros().size();
            if (condutor.getCpf() == cliente.getCpf())
                quantidadeSinistrosCliente = condutor.getListaSinistros().size();
        }
        double valor = 0;
        if (idade < 30) {
            valor = CalcValor.VALOR_BASE.getValor() * CalcValor.FATOR_0_30.getValor() * (1 + 1/(cliente.getListaVeiculos().size()+2))
                        * (2 + quantidadeSinistrosCliente/10) * (5 + quantidadeSinistrosCondutores/10);
        }
        else if (idade >= 30 && idade < 60) {
            valor = CalcValor.VALOR_BASE.getValor() * CalcValor.FATOR_30_60.getValor() * (1 + 1/(cliente.getListaVeiculos().size()+2))
                        * (2 + quantidadeSinistrosCliente/10) * (5 + quantidadeSinistrosCondutores/10);          
        }
        else if (idade >=60) {
            valor = CalcValor.VALOR_BASE.getValor() * CalcValor.FATOR_0_30.getValor() * (1 + 1/(cliente.getListaVeiculos().size()+2))
                        * (2 + quantidadeSinistrosCliente/10) * (5 + quantidadeSinistrosCondutores/10);
        }
        super.setValorMensal(valor);
        return valor;
    }  
    
    //Método toString de SeguroPF
    public String toString() {
        String str = super.toString() + "\nVeiculo: " + veiculo.getMarca() + " " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + 
                        ")\nCliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")\n"; 
        return str;
    }
}