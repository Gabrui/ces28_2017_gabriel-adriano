/**
 * Codificação UTF-8
 * Gabriel Adriano
 * Dylan Sugimoto
 */

package notaFiscal;

import java.util.LinkedList;
import bancoDados.*;

public class NotaFiscal {
	
	protected LinkedList<ItemVenda> listaItens;
	protected BD bancoRemoto;
	protected Cliente comprador; //NotaFiscal tem os dados do cliente
	protected String _dataEntrega; //NotaFiscal sabe a data de entrega
	protected String _cEntrada; //NotaFiscal sabe as condicoes de entrega
	
	public NotaFiscal(BD bancoRemoto, VerificadorCPF verificador, 
			String CPF, String item, int quant) {
		this.bancoRemoto = bancoRemoto;
		this.comprador = bancoRemoto.getCliente(CPF);
		if (comprador == null)
			throw new IllegalArgumentException("Cliente não cadastrado no sistema.");
		if (!verificador.validaCPF(comprador.getCPF()))
			throw new IllegalArgumentException("CPF não é válido!");
		listaItens = new LinkedList<>();
		adicionaItem(item, quant);//Requisito 1. NotaFiscal tem pelo menos 1 Item de Venda.
	}
	
	
	//Requisito 6. Somente NotaFiscal em elaboracao pode alterar lista de ItemVenda
	protected void adicionaItem(String item, int quant) {
		if (quant <= 0)//Requisito 1. NotaFiscal tem pelo menos 1 Item de Venda.
			throw new IllegalArgumentException("A quantidade não pode ser nula ou negativa.");
		listaItens.add(new ItemVenda(bancoRemoto, item, quant)); 
		//Se o P/S nao existir o BD deve lancar uma excecao.
		//Logo, NotaFiscal sempre tem pelo menos um item de venda (Requisito 1).
		//ItemVenda recebe P/S do BD. Só o BD cria P/S.
		//Todo Item de Venda é criado dentro da NotaFiscal na hora de adicionar
		//E o construtor de Item de Venda é protected compartilhando a mesma pkg que NotaFiscal
		//Logo, Cada Item de venda pertence apenas a uma NotaFiscal.
	}
	
	//Requisito 13. Metodo apropriado de acesso da lista
	//Requisito 17. calcula o preco percorrendo a arvore de todos itens de venda e 
	//soma todos os nós.
	public int getValor() {
		int valor = 0;
		for (ItemVenda i : listaItens)
			valor += i.getValor();
		return valor;
	}
	
	
	//Requisito 13. Metodo apropriado de acesso da quantidade de um item
	/**
	 * Retorna a quantidade de um item
	 * @param nomeItem
	 * @return A quantidade de produtos de um item
	 */
	@SuppressWarnings("unlikely-arg-type")
	public int getQuantidade(String nomeItem) {
		for (ItemVenda i : listaItens)
			if (i.equals(nomeItem))
				return i.getQuantidade();
		return 0;
	}
	
	//Requisito 13. Metodo apropriado de acesso aos nomes dos itens
	public String nomeItens() {
		String nomeSet ="";
		for (ItemVenda i : listaItens)
				nomeSet += i.nome();
		return nomeSet;
	}
}
