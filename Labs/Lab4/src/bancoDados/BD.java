package bancoDados;

public interface BD {
	public ProdutoAbstrato getProdutoServico(String nome);
	public Cliente getCliente(String CPF);
}