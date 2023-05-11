import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientePF extends Cliente {
	private final String cpf;
	private String genero;
	private LocalDate dataLicenca;
	private String educacao;
	private LocalDate dataNascimento;
	private String classeEconomica;
	
	public ClientePF(String nome, String endereco, String cpf, String genero, LocalDate dataLicenca,
		String educacao, LocalDate dataNascimento, String classeEconomica)
	{
		
		super(nome, endereco);
		this.cpf = cpf; 
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
	}
	
	//getters
	public LocalDate getDataLicenca(){
		return dataLicenca;
	}
		
	public String getEducacao() {
		return educacao;
	}
		
	public String getGenero() {
		return genero;
	}
	
	public String getClasseEconomica() {
		return classeEconomica;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public LocalDate getdataNascimento() {
		return dataNascimento;
	}
	
	//setters
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setDataLicenca(LocalDate dataLicenca) {
		this.dataLicenca = dataLicenca;
	}
		
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
		
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	
	@Override   //refazendo o tostring para novas variaveis
	public String toString() {
		return super.toString() + "\ndataLicenca: " + dataLicenca + "\neducacao: " + educacao +
				"\ngenero: " + genero + "\nclasseEconomica: " + classeEconomica +
				 "\ncpf: " + cpf + "\ndataNascimento: " + dataNascimento;
	}
	
	@Override   //retorna CPF para clientePF
	public String getID() {
		return cpf;
	}
	
	@Override 
	public double calculaScore() {
		double fatIdade = 0;
		int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
		if (idade > 18 && idade < 30) {
			fatIdade = CalcSeguro.FATOR_18_30.getNumero();
		}else if (idade >= 30 && idade < 60) {
			fatIdade = CalcSeguro.FATOR_30_60.getNumero();
		}else if (idade >= 60) {
			fatIdade = CalcSeguro.FATOR_60_90.getNumero();
		}

		return CalcSeguro.VALOR_BASE.getNumero() * fatIdade * listaVeiculos.size();
	}
	
}