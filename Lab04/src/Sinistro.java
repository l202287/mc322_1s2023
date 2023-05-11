import java.time.LocalDate;
import java.util.Random;

public class Sinistro 
{
	//variáveis pedidas
	private final int id;
	private LocalDate data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	// gerar ID aleatório
	Random gerador = new Random();
	
	@Override
	public String toString() {
		return "\nid: " + id + "\ndata: " + data + "\nendereco: " + endereco +
				"\nseguradora: " + seguradora.getNome() + 
				"\nveiculo: " + veiculo.getPlaca() +	  
				"\ncliente: " + cliente.getID();		 
	}
	
	//construtor
	public Sinistro(LocalDate data, String endereco, Seguradora seguradora, 
			Veiculo veiculo, Cliente cliente) 
	{
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
		
		// gerar id entre 1 100000
		this.id = gerador.nextInt(100000); 
	}
	
	// getters 
	public int getId() {
		return id;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public Seguradora getSeguradora() {
		return seguradora;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	
	// setters 
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}