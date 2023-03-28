public class Main {
	
	public static void main(String[] args){
		
		//Criando o objeto para CLiente
		Cliente cli = new Cliente("Lula", "070.680.938-68", "06/10/1945", 77, "Rua Vermelha 13");
		
		//Verificar cpf
		if(cli.validarCPF(cli.getCpf())){
			System.out.println("CPF valido!\n");
		}
		else {
			System.out.println("CPF invalido!\n");
		}
		
		//Exibir parametros do objeto Cliente
		System.out.println(cli);

		//Criando o objeto para Seguradora
		Seguradora seg = new Seguradora("Só Confia", "13913131313", "soconfia@gmail.com", "Rua Roxa 171");	
		//Exibir parametros
		System.out.println(seg);

		//Criando o objeto para Veiculo
		Veiculo vei = new Veiculo("LUL-1313", "Volkswagen", "Fusca");
		//Exibir parametros
		System.out.println(vei);
		
		//Criando o objeto Sinistro
		Sinistro sin = new Sinistro("31/10/2022", "Rua Verde e Amarela 22");
		//Exibir parametros
		System.out.println(sin);
	}
}