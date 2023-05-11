import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seguradora
{
	//variáveis pedidas
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Cliente> listaClientes;
	
	@Override
	public String toString() {
		return "\nnome: " + nome + "\ntelefone: " + telefone + "\nemail: " + email + "\nendereco: " + endereco + 
				"\nlistaSinistros: " + imprimirListaSinistros(listaSinistros) + 
				"\nlistaClientes: " + imprimirListaClientes(listaClientes);
	}
	
	//construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		
		//criar listas para sinistro e clientes
		listaSinistros = new ArrayList<Sinistro>();
		listaClientes = new ArrayList<Cliente>();
	}
	
	//imprimir usando toString()
	public String imprimirListaSinistros(ArrayList<Sinistro> lista) {
		String s = "\nINICIO-LISTA-SINISTRO";
		for(int i = 0; i < lista.size(); i++) {
			s = s + "\nSinistro número: " + i + "\n";
			s = s + lista.get(i).getId();
		}
		s =  s + "\nfinal-LISTA-SINISTRO";
		return s;
	}
	
	public String imprimirListaClientes(ArrayList<Cliente> lista) {
		String s = "\nINÍCIO-LISTA-CLIENTES";
		for(int i = 0; i < lista.size(); i++) {
			s = s + "\nCliente número: " + i + "\n";
			s = s + lista.get(i).getID();    //Ids dos clientes 
		}
		s = s + "\nFINAL-LISTA-CLIENTES";
		return s;
	}
	
	//getters 
	public String getNome() {
		return nome;	
	}
	
	public String getTelefone(){
		return telefone;
	}
	
	public String getEmail() {
		return email;	
	}
	
	public String getEndereco() {
		return endereco;	
	}
	
	public ArrayList<Sinistro> getListaSinistros(){
		return listaSinistros;
	}
	
	public ArrayList<Cliente> getListaClientes(){
		return listaClientes;
	}
	
	//setters 
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	//adicionar cliente em listaClientes
	public boolean cadastrarCliente(Cliente cliente) {
		boolean rep = false;
		for(int i = 0; i < listaClientes.size(); i++) {
			if(listaClientes.get(i).getID() == cliente.getID()) //verificar se o cliente já se encontra na lista
				rep = true;
		}
		if (!rep) {
			listaClientes.add(cliente);     //entao adiciona na lista
			return true;
		}
		return false;
	}
	
	//remover cliente em listaClientes a partir do ID CNPJ CPF
	public boolean removerCliente(String cliente) {
		boolean removeu = false;
		for(int i = 0; i < listaClientes.size(); i++) {
			if((listaClientes.get(i).getID() == cliente)) {
				listaClientes.remove(i);
				removeu = true;
			}
		}	
		return removeu; //falso, entao nao ta na lista 
	}
	
	//criar uma nova lista apenas com ClientePF ou ClientePJ,conforme parametros
	public ArrayList<Cliente> listarClientes(String tipoCliente){
		
		if(tipoCliente.compareTo("ClientePF") == 0) {
			ArrayList<Cliente> listaClientesPF = new ArrayList<Cliente>();
			for(int i = 0; i < listaClientes.size(); i++) {
				if(listaClientes.get(i) instanceof ClientePF) { //se PF adiciona na lista nova
					listaClientesPF.add(listaClientes.get(i));
				}
			}
			return listaClientesPF;
			
		}else if (tipoCliente.compareTo("ClientePJ") == 0) {
			ArrayList<Cliente> listaClientesPJ = new ArrayList<Cliente>();
			
			for(int i = 0; i < listaClientes.size(); i++) {
				if(listaClientes.get(i) instanceof ClientePJ) {//se PJ adiciona na lista nova
					listaClientesPJ.add(listaClientes.get(i));
				}
			}
			return listaClientesPJ;
		}
		System.out.println("Cliente inválido");
		
		return null; // nao tem lista
	}
	
	public boolean cadastrarSinistro(Sinistro sinistro) {
		boolean rep = false;
		for(int i = 0; i < listaSinistros.size(); i++) {
			if(listaSinistros.get(i).getId() == sinistro.getId()) //verifica se o sinistro está na lista
				rep = true;
		}
		if (!rep) {
			listaSinistros.add(sinistro);     //adiciona na lista, se nao estiver na lista
			return true;
		}
		return false;
	}
	
	//imprimir todos os Sinistro de um cliente a partir do parametro
	
	public boolean visualizarSinistro(String cliente) {
		boolean achado = false;
		for(int i = 0; i < listaSinistros.size(); i++) {
			if(listaSinistros.get(i).getCliente().getID().compareTo(cliente) == 0) { //achou o cliente
				System.out.println(listaSinistros.get(i).toString());                //imprimi todos Sinistros
				achado = true;
			}
		}
		return achado;
	}
	
	public void listarSinistros(){  //retorna a propria lista
		System.out.println("Listando todos os sinistros:");
		for (Sinistro si : this.listaSinistros) {
			System.out.println(si.getId());
		}    
	}
	
	public double calcularPrecoSeguroCliente(String cliente) {
		double score = 0;
		int quantidadeSinistros = 0;
		for(Cliente c : listaClientes) {
			if (c.getID().compareTo(cliente) == 0) {
				score = c.calculaScore() ;
			}
		}
		for(Sinistro s : listaSinistros) {
			if (s.getCliente().getID().compareTo(cliente) == 0) {
				quantidadeSinistros += 1;
			}
		}
		return score * (1 + quantidadeSinistros); 
		
	}
	
	public double calcularReceita() {
		double receita = 0;
		for(Cliente c : listaClientes) {
			receita += calcularPrecoSeguroCliente(c.getID());
		}
		return receita;
	}

}