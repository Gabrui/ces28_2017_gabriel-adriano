/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex1;

/**
 * 
 * Classe para representar a carta do tipo Pessoal
 */
public class CartaPessoal extends Carta{
	
	
	
	public CartaPessoal(Pessoa remetente, Pessoa destinatario,Data data) {
		_remetente = remetente;
		_destinatario = destinatario;
		_data = data;
		_enderecoRemetente = remetente.getEndereco();
		_enderecoDestinatario = destinatario.getEndereco();
	}
	
	public String modeloPortugues(String vocativo,String mensagem,String despedida) {
		return cabecarioPortugues() + corpoPortugues(vocativo,mensagem) + despedida(despedida) + assinaturaPortugues();
	}
	protected String cabecarioPortugues() {
		return _enderecoRemetente.toString() + ", "+_data.getDataPortugues(" de ") + "\n\n";
	}
	protected String corpoPortugues(String vocativo, String mensagem) {
		return vocativo + _destinatario.getNome()+", " +"\n\n"
				+ mensagem +"\n\n";
	}
	protected String despedida(String despedida){
		return despedida +"\n\n";
	}
	protected String assinaturaPortugues() {
		return  _remetente.getNome()+"\n\n";
	}
}
