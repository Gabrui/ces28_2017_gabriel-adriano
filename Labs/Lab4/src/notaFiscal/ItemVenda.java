package notaFiscal;
import bancoDados.*;

public class ItemVenda {
	private BD bancoDadosRemoto;
	private ProdutoServico produto;//Cada Item de venda se refere apenas um P/S
	private String nome;
	private int quantidade;
	
	public ItemVenda (BD bancoRemoto, String nome, int quantidade) {
		this.bancoDadosRemoto = bancoRemoto;
		this.quantidade = quantidade;
		this.nome = nome;
		produto = bancoDadosRemoto.getProdutoServico(nome);
		//ItemVenda recebe P/S do BD. Só o BD cria P/S (Requisito 5).
		if (produto == null)
			throw new IllegalArgumentException("O produto não existe!");
			
	}
	
	public int getValor() {
		return produto.getPreco()*quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof ItemVenda) {
			return ((ItemVenda) o).nome.equals(nome);
		}
		return false;
	}
}
