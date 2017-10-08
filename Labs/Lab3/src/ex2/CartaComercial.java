package ex2;

class CartaComercial extends Carta {
	
	public CartaComercial(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		super(remetente, destinatario, data, idioma);
	}
	
	@Override
	public String modelo() {
		return super.modelo() + informacoesFinais();
	}
	
	@Override
	protected String cabecalho() {
		return _remetente.getNomeEmpresa() + "\n" + super.cabecalho();
	}
	
	protected String informacoesFinais() {
		return "\n\n            __________________\n            "
				+ _remetente.getNome() + "\n            " + _remetente.getEmprego()
				+ "\n            "+ _remetente.getFone(_idioma)
				+ "\n            email:" + _remetente.getEmail();
	}
	
	
	

}
