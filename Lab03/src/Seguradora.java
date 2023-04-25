import java.util.List;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private List<Sinistro> listaSinistros;
	private List<Cliente> listaClientes;
	
	// Construtor
	
	public Seguradora() {
	}

	public Seguradora(String nome, String telefone, String email, String endereco, List<Cliente> listaClientes) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaClientes = listaClientes;
	}

	public Seguradora(String nome, String telefone, String email, String endereco, List<Sinistro> listaSinistros,
			List<Cliente> listaClientes) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = listaSinistros;
		this.listaClientes = listaClientes;
	}	

	// Getters e setters 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}


	public void setListaSinistros(List<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}


	public List<Cliente> getlistaClientes() {
		return listaClientes;
	}


	public void setlistaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
	// Cadastrar cliente: cliente cadastrado com sucesso retorna True.

	public boolean cadastrarCliente(Cliente cliente) {
		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getNome() == cliente.nome)
				return false;

		}
		listaClientes.add(cliente);
		return true;
	}
	
	// Remover cliente
	
	public boolean removerCliente(String cliente) {
		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getNome() == cliente) {
				listaClientes.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Seguradora [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", listaSinistros=" + listaSinistros + ", listaClientes=" + listaClientes + "]";
	}
	
	
}