import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private LocalDate dataFundacao;
	private int quantidadeFuncionarios;

	public ClientePJ(String nome, String endereco, String cnpj, 
			LocalDate dataFundacao, int quantidadeFuncionarios)
	{
		super(nome, endereco);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}
	
	//getters
	public String getCnpj() {
		return cnpj;
	}
	
	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	
	public int getQntFuncionarios() {
		return quantidadeFuncionarios;
	}
	
	//setters
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public void setQntFuncionarios(int quantidadeFuncionarios) {
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}
	
	@Override   // refazer tostring para novos variaveis
	public String toString() {
		return super.toString() + "\ncnpj: " + cnpj + "\ndataFundacao: " + dataFundacao;
	}
	
	@Override  //retorna o cnpj para ClientePJ
	public String getID() {
		return cnpj;
		
	}
	
	@Override
	public double calculaScore() {
		return CalcSeguro.VALOR_BASE.getNumero() * (1 + (quantidadeFuncionarios)/100.0) * listaVeiculos.size();
	}
	
}