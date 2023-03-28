import java.util.Random;
public class Sinistro {

		private int id;
		private String data;
		private String endereco;
	
		//Construtor
		public Sinistro(String data, String endereco) {
			// Gerar um numero inteiro positivo aleatorio entre 1 e 999999
			Random random = new Random();
			int randomico = random.nextInt(999999);
			this.id = randomico;
			this.data = data;
			this.endereco = endereco;
		}
		
		//Get para cada parametro
		public int getId() {
			return id;
		}

		public String getData() {
			return data;
		}

		public String getEndereco() {
			return endereco;
		}
		
		//Set para cada parametro
		public void setId(int id) {
			this.id = id;
		}
		
		public void setData(String data) {
			this.data = data;
		}
		
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public String toString() {
			return "Id: " + id + "\n" + "Data: " + data + "\n" + "Endereco: " + endereco + "\n";
		}
		
		
		}
