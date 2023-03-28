public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	
	//Construtor
	public Veiculo(String placa, String marca, String modelo) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	//Get para cada parametro
	public String getPlaca() {
		return placa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	//Set para cada parametro
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String toString() {
		return "Placa: " + placa + "\n" + "Marca: " + marca + "\n" + "Modelo: " + modelo + "\n";
	}
	
}