package ex1;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 * Classe para guardar enderecos
 */
public class Endereco {
	
	private String _rua;
	private String _cidade;
	private String _estado;
	private String _pais;
	
	public Endereco(String rua,String cidade,String estado,String pais) {
		
		_rua = rua;
		_cidade = cidade;
		_estado = estado;
		_pais = pais;
		
	}
	public Endereco getEndereco() {
		return new Endereco(_rua,_cidade,_estado,_pais);
	}
	public String toString() {
		return _rua +", "+ _cidade+ ", " + _estado + ", "+_pais;
	}
}
