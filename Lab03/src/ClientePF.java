import java.time.LocalDate;
import java.util.List;

public class ClientePF extends Cliente{
	private final String cpf;
	private String genero;
	private LocalDate dataLicenca;
	private String educacao;
	private LocalDate dataNascimento;
	private String classeEconomica;
	
	// Construtor
	
	public ClientePF(String nome, String endereco, List<Veiculo> listaVeiculos, String cpf, String genero,
			LocalDate dataLicenca, String educacao, LocalDate dataNascimento, String classeEconomica) {
		super(nome, endereco, listaVeiculos);
		this.cpf = cpf;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
	}
	
	// Getters e setters

	public String getCpf() {
		return cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(LocalDate dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	
	// Metodos para validar o cpf de um cliente
	
	public boolean validarCPF() {
		// Remove os caracteres nao numericos do CPF
		String regex  = "\\D";
		String numerosCpf = cpf.replaceAll(regex, "");
		
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
	
	// toString()
	

	@Override
	public String toString() {
		return super.toString() + "ClientePF [cpf=" + cpf + ", genero=" + genero + ", dataLicenca=" + dataLicenca + ", educacao="
				+ educacao + ", dataNascimento=" + dataNascimento + ", classeEconomica=" + classeEconomica + "]";
	}

}
