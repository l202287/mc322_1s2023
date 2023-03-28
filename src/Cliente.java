public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	//Construtor
	public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	//Get para cada parametro
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	//Set para cada parametro
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	//ToString, para quando for exibir os parametros utilizar apenas uma linha de comando
	public String toString() {
		return "Nome: " + nome + "\n" + "Cpf: " + cpf + "\n" + "DataNascimento: " + dataNascimento + "\n"
				+ "Idade: " + idade + "\n" + "Endereco: " + endereco + "\n";
	}
	
	//Verificacao do cpf
	public boolean validarCPF(String cpf) {
		//transformando o cpf em apenas numeros
		cpf = cpf.replaceAll("[^0-9]", "");
		//verificar se tem os 11 digitos
		if(cpf.length() != 11) {
			return false;
		}
		//verificar se todos os digitos sao iguais
		int cont = 0;
		while( cont < cpf.length()) {
			if(cont < 10 && cpf.charAt(cont) != cpf.charAt(cont+1)) {
				break;
			}
			else {
				return false;
			}
		}
		//Calculos para o primeiro digito verificador
		int cont2 = 0;
		int soma = 0;
		cont = 10;
		while( cont > 1) {
			soma += Character.getNumericValue(cpf.charAt(cont2))*cont;
			cont2++;
			cont--;
		}
		int digito1;
		int resto = soma%11;
		if(resto >= 2) {
			digito1 = 11 - resto;
		}
		else {
			digito1 = 0;
		}
		//Calculos para o segundo digito verificador
		cont2 = 0;
		soma = 0;
		cont = 11;
		while( cont > 2) {
			soma += Character.getNumericValue(cpf.charAt(cont2))*cont;
			cont2++;
			cont--;
		}
		soma += digito1*2;
		int digito2;
		resto = soma%11;
		if(resto >= 2) {
			digito2 = 11 - resto;
		}
		else {
			digito2 = 0;
		}
		//verificacao se os digitos verificadores sao iguais
		if( digito1 == Character.getNumericValue(cpf.charAt(9)) && digito2 == Character.getNumericValue(cpf.charAt(10)) ) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}