
public enum MenuOperacoes {
	SAIR(0),
	CADASTRAR(1),
	LISTAR(2),
	EXCLUIR(3),
	GERAR_SINISTRO(4),
	TRANSFERIR_SEGURO(5),
	CALCULAR_RECEITA_SEGURADORA(6),
	CADASTRAR_CLIENTE_PF(11), // 1 referente ao cadastrar e outro digito
	CADASTRAR_CLIENTE_PJ(12),
	CADASTRAR_VEICULO(13),
	CADASTRAR_SEGURADORA(14),
	LISTAR_CLIENTES_PF_SEGURADORA(21), // 2 referente ao listar e outro digito
	LISTAR_CLIENTES_PJ_SEGURADORA(22),
	LISTAR_SINISTROS_SEGURADORA(23),
	LISTAR_SINISTROS_CLIENTE(24),
	LISTAR_VEICULOS_CLIENTE(25),
	LISTAR_VEICULOS_SEGURADORA(26),
	EXCLUIR_CLIENTE(31), // 3 referente ao excluir e outro digito
	EXCLUIR_VEICULO(32),
	EXCLUIR_SINISTRO(33),
	VOLTAR(9);
	
	public final int operacao;
	
	MenuOperacoes(int operacao){
		this.operacao = operacao;
	}
	
	public int getOperacao() {
		return this.operacao;
	}
}