import java.time.LocalDate;
import java.util.List;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private LocalDate dataFundacao;
	
	// Construtor
	
	public ClientePJ(String nome, String endereco, List<Veiculo> listaVeiculos, String cnpj, LocalDate dataFundacao) {
		super(nome, endereco, listaVeiculos);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}
	
	// Gets and Sets
	
	public String getCnpj() {
		return cnpj;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	// Metodos para validar o cnpj de um cliente
	
	public boolean validarCnpj()
	{
		// Deixar so numeros do Cnpj
		String regex  = "\\D";
		String numerosCnpj = cnpj.replaceAll(regex, "");
		
		// Verifica quantidade de digitos, se nao tiver retorna false
		if (numerosCnpj.length() != 14)
			return false;
		
		// Vdigitos sao iguais?
		
		boolean todosDigitosIguais = true;
		
		
		int i = 0;
		while(i < 10) {
			
			// Procura digito diferente
			if (numerosCnpj.charAt(i) != numerosCnpj.charAt(i + 1)) {
				todosDigitosIguais = false;		
				break;
			}
			i++;
		}
		if (todosDigitosIguais == true) {
			return false;
		}

		// Calcula o primeiro digito verificador do cnpj
		int soma = 0;
		int multiplicador1[] = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		
		i = 0;
		while(i < 12) {
			int peso = (numerosCnpj.charAt(i) - 48) * multiplicador1[i];
			soma += peso;
			i++;
		}
		int resto = soma % 11;
		int primeiroVerificador;
		
		if (resto < 2) 
			primeiroVerificador = 0;
		else
			primeiroVerificador = 11 - resto;
		
		// Calcula o segundo digito verificador do cnpj
		
		soma = 0;
		int multiplicador2[] = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		
		i = 0;
		while(i < 13) {
			int peso = (numerosCnpj.charAt(i) - 48) * multiplicador2[i];
			soma += peso;
			i++;
		}
		resto = soma % 11;
		int segundoVerificador;
		
		if (resto < 2) 
			segundoVerificador = 0;
		else 
			segundoVerificador = 11 - resto;
		
		// Verifica se os digitos verificadores sao iguais aos digitos verificadores do cnpj inserido
			
		if ((primeiroVerificador == (numerosCnpj.charAt(9) - 48)) && (segundoVerificador == (numerosCnpj.charAt(10) - 48))) 
			return true;
		else
			return false;
	}

	// toString
	@Override
	
	public String toString() {
		return super.toString() + "ClientePJ [cnpj=" + cnpj + ", dataFundacao=" + dataFundacao + "]";
	}	
}