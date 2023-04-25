import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main 
{

	public static void visualizaDados(Seguradora seguradora) 
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("o que tu quer ver?\n(1) Endereco da seguradora \n(2) Telefone da seguradora");
		int op = sc.nextInt();
		switch (op) {
		
		case 1:
			System.out.println(seguradora.getEndereco());
		break;
		case 2:
			System.out.println(seguradora.getTelefone());
		break;
		}
		
	}
	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		List<Cliente> listaCliente = new ArrayList<>();
		

		// Cadastrar cliente
		
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		System.out.println("Endereco: ");
		String endereco = sc.nextLine();
		System.out.println("Quantidade de veiculos: ");
		int qtdVeiculos = sc.nextInt();
		
		List<Veiculo> listaVeiculos = new ArrayList<>();
		
		int i = 0;
		while (i < qtdVeiculos) {
			System.out.println("Veiculo #" + (i + 1) + ":");
			System.out.println("Placa: ");
			String placa = sc.next();
			System.out.println("Marca: ");
			String marca = sc.next();
			System.out.println("Modelo: ");
			String modelo = sc.next();
			System.out.println("Ano de fabricacao: ");
			int anoFabricacao = sc.nextInt();
			
			Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
			listaVeiculos.add(veiculo);
			i++;
		}

		// Cadastrar cliente PF
		
		System.out.println("CPF: ");
		String cpf = sc.next();
		System.out.println("Genero: ");
		String genero = sc.next();
		System.out.println("Data licenca (dd/mm/aaaa): ");
		LocalDate dataLicenca = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Educacao: ");
		sc.nextLine();
		String educacao = sc.nextLine();
		System.out.println("Data de nascimento (dd/mm/aaaa): ");
		LocalDate dataNascimento = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Classe economica: ");
		String classeEconomica = sc.next(); 
			
			
		ClientePF x = new ClientePF(nome, endereco, listaVeiculos, cpf, genero,dataLicenca,educacao, dataNascimento, classeEconomica);
		listaCliente.add(x);
		if (x.validarCPF() == true) {
			System.out.println("CPF válido");
		}
		else {
			System.out.println("CPF INVÁLIDO!!!");
		}

		System.out.println(x);
		
		// OU Cadastrar cliente PJ
		System.out.println("CNPJ");
		String cnpj = sc.next();
		System.out.println("Data de fundacao (dd/mm/aaaa): ");
		LocalDate dataFundacao = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		ClientePJ y = new ClientePJ(nome, endereco, listaVeiculos, cnpj, dataFundacao);
		listaCliente.add(y);
		if (y.validarCnpj() == true) {
			System.out.println("CNPJ válido");
		}
		else {
			System.out.println("CNPJ INVÁLIDO!!!");
		}
			
		System.out.println(y);

	
		// Remocao Cliente
		listaCliente.remove(x);
		
		Seguradora seguradora1 = new Seguradora();
	
		
		Sinistro sinistro = new Sinistro(1, "22/10/1998", "qualquer coisa", seguradora1, x.getListaVeiculos().get(0), x);
		List<Sinistro> listaSinistro = new ArrayList<>();
		listaSinistro.add(sinistro);
		Seguradora seguradora2 = new Seguradora("Segura", "11999999999", "segura@gmail.com", "Rua seila n 666", listaSinistro, listaCliente);
		visualizaDados(seguradora2);
		System.out.println(seguradora2);
		
		sc.close();
	}

}