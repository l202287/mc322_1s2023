import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
	//variáveis pedidas
	private String nome;
	private String endereco;
	protected ArrayList<Veiculo> listaVeiculos;
	private double valorSeguro;
	
	@Override
	public String toString() {
		return "\nnome: " + nome + "\nendereco: " + endereco + 
				"\nlistaVeiculos: " + imprimirListaVeiculos(listaVeiculos) +
				"\nvalorSeguro: " + valorSeguro; //imprime as placas na lista
	}
		
	//construtor
	public Cliente(String nome, String endereco) 
	{
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new ArrayList<Veiculo>(); 
		this.valorSeguro = 0;
	
	}
	//Override nas sub-classes
	public String getID() {
		return "";
	}
		
	//getters 
	public String getNome(){
		return nome;
	}
		
	public String getEndereco(){
		return endereco;
	}
	
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	
	public double getValorSeguro() {
		return valorSeguro;
	}
		
	//setters 
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	
	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	
	//imprimir para o toString()
	public String imprimirListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		String s = "\nINICIO-LISTA-VEICULOS";
		for (int i = 0; i < listaVeiculos.size(); i++) {
			s = s + "\nVeiculo numero: " + i + "\n";
			s = s + listaVeiculos.get(i).getPlaca();
		}
		s = s + "\nFINAL-LISTA-VEICULOS";
		return s;
	}
	
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		listaVeiculos.add(veiculo);
		return true;
	}
	
	public double calculaScore() {
		return 0.0;
	}
		
}