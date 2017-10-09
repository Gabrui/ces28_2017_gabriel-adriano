/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 08/10/2017
 */
package ex3;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representa o modelo da carta comercial.
 */
public abstract class ModeloComercial extends Modelo{


	@Override
	public String corpo(Idioma idioma, Pessoa destinatario) {
		return idioma.vocativo() + destinatario.getNome()+": " +"\n\n"
			   +"\n\n";
	}

	@Override
	public String despedida(Idioma idioma) {
		// Idioma trata de traduzir a despedida
		return idioma.despedida() +",\n\n";
	}

}