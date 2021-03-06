/**
 * LAB-1 CES-28
 * Data: 01/08/2017
 * @author - Dylan Nakandakari Sugimoto
 * @author - Gabriel Adriano de Melo
 * 
 * Esse pacote contem as classes de teste
 */
package testeLab01;
import static org.junit.Assert.*;
import org.junit.Test;

import lab01.Currency;
import lab01.Money;
import lab01.MoneyBag;

import org.junit.Before;

/**
 * Class TesteMoney: Possui metodos que testam a classe Money
 * Passo 2,3,4 e 6 e teste da implementacao do Passo 1, 5 e 10.
 *
 */
public class TesteMoney {
	
	//Declarando atributos privados
	
	private Money BRL7;
	private Money USD11;
	private Money EUR19;
	private Money GBP7;
	private Money BRL0;
	private Money BRLmax;
	private Money BRLempty;
	private Money EUR0;
	private int maxint;
	private Currency BRL;
	private Currency USD;
	private Currency EUR;
	private Currency GBP;
	//Fim da declaracao
	
	/**
	 * Este metodo realiza algumas preparacoes para realizacao do teste
	 * Passo 4
	 */
	@Before
	//Definindo alguns objetos Money para usar nos testes
	public void setUp() {
		BRL = new Currency("BRL");
		USD = new Currency("USD");
		EUR = new Currency("EUR");
		GBP = new Currency("GBP");
		BRL7 = new Money(7,BRL);
		USD11 = new Money(11,USD);
		EUR19 = new Money(19,EUR);
		GBP7 = new Money(7,GBP);
		maxint = 2147483647;
		Currency empty = new Currency("   ");
		BRL0 = new Money(0,BRL);
		BRLmax = new Money(maxint,BRL);
		BRLempty = new Money(12,empty);
		EUR0 = new Money(0,EUR);
	}
	/**
	 * Esse metodo compara money iguais
	 * Passo 6
	 */
	@Test
	public void VerificarMetodoEqualDaClasseMoney_QuandoCompararMoneyIguaisDevemSerIguais() {
		//Criando objetos para usar no Teste
		Money GBP07 = new Money(7,GBP);
		Money GBP0 = new Money(0,GBP);
		Money GBPmax = new Money(maxint,GBP);
		Money EUR019 = new Money(19,EUR);
		//Fim da Criacao de Objetos
		
		//Verificando se sao iguais pelo metodo Equals
		assertEquals(GBP7,GBP07);
		assertEquals(GBP0,GBP0);
		assertEquals(GBP7,GBP7);
		assertEquals(GBPmax,GBPmax);
		assertEquals(EUR019,EUR019);
		assertEquals(EUR19,EUR019);
		//repetindo
		assertTrue(GBP7.equals(GBP07));
		assertTrue(GBP7.equals(GBP7));
		assertTrue(GBP0.equals(GBP0));
		assertTrue(EUR019.equals(EUR019));
		assertTrue(EUR019.equals(EUR19));
		assertTrue(GBPmax.equals(GBPmax));
		
	}
	/**
	 * Esse metodo compara money diferentes
	 * Passo 6
	 */
	@Test
	public void VerificarMetodoEqualDaClasseMoney_QuandoComparaMoneyDiferenteDevemSerDiferentes() {
		//Criando objetos para usar no Teste
				Money GBP0 = new Money(0,GBP);
				Money GBPmax = new Money(maxint,GBP);
				Money EUR019 = new Money(19,EUR);
				Money EUR7 = new Money(7,EUR);
				//Fim da Criacao de Objetos
				
		//conferindo quando sao diferentes
				assertTrue(!(GBP7.equals(GBP0)));
				assertTrue(!(GBP7.equals(EUR7)));
				assertTrue(!(EUR019.equals(GBP7)));
				assertTrue(!(GBP7.equals(GBPmax)));
				assertTrue(!(GBPmax.equals(EUR19)));
		
	}
	/**
	 * Esse metodo realiza o teste da soma entre mesma moeda.
	 * Passo 2, 3 e 6, e testa a implementacao do passo 1 e 5
	 * 
	 */
	@Test
	public void VerificarMetodoAddDaClasseMoney_SomaDaMesmaMoeda() {
		//Criando alguns objetos Money para usar no teste.
		Money BRL0 = new Money(0,BRL);
		Money BRL1 = new Money(1,BRL);
		Money BRL07 = new Money(7,BRL);
		Money BRL00 = new Money(0, BRL);
		Money BRLmax = new Money(maxint, BRL);
		Money USD0 = new Money(0,USD);
		Money USD1 = new Money(1,USD);
		Money USDmax = new Money(maxint,USD);
		//Fim da Criacao de objetos
		
		//Testando com BRL
		assertTrue(BRL7.add(BRL0).getAmount() == 7);
		assertTrue(BRL0.add(BRL1).getAmount() == 1);
		assertTrue(BRL07.add(BRL7).getAmount() == 14);
		assertTrue(BRL00.add(BRL0).getAmount() == 0);
		assertTrue(BRLmax.add(BRL0).getAmount() == maxint);
		//Testando com USD
		assertTrue(USD11.add(USD0).getAmount() == 11);
		assertTrue(USD0.add(USD1).getAmount() == 1);
		assertTrue(USD0.add(USD0).getAmount() == 0);
		assertTrue(USDmax.add(USD0).getAmount() == maxint);
		
		//Usando Equals
		assertEquals(USD0.add(USD1),USD1);
		assertEquals(USD0.add(USD0),USD0);
		assertEquals(USDmax.add(USD0),USDmax);
	}
	/**
	 * Este Metodo testa o metodo add quando recebe Money diferentes
	 * Teste da implementacao do Passo 10
	 */
	@Test
	public void VerificarMetodoAddDaClasseMoney_QuandoSomaMoneyDiferentesRetornaMoneyBag() {
		
		MoneyBag bagBRL7EUR19 = new MoneyBag();
		MoneyBag bagBRLemptyUSD11 = new MoneyBag();
		MoneyBag bagEUR19BRLmax = new MoneyBag();
		MoneyBag bagBRL0GBP7 = new MoneyBag();
		MoneyBag bagBRL0EUR0 = new MoneyBag();
		//Fim da declaracao
		
		//Montando Moneybags
		bagBRL7EUR19.add(BRL7);
		bagBRL7EUR19.add(EUR19);
		bagBRLemptyUSD11.add(BRLempty);
		bagBRLemptyUSD11.add(USD11);
		bagEUR19BRLmax.add(EUR19);
		bagEUR19BRLmax.add(BRLmax);
		bagBRL0GBP7.add(BRL0);
		bagBRL0GBP7.add(GBP7);
		bagBRL0EUR0.add(EUR0);
		bagBRL0EUR0.add(BRL0);
		//Fim da montagem
		
		//Teste
		assertEquals(BRL7.add(EUR19),bagBRL7EUR19);
		assertFalse(BRL7.add(EUR19).equals(BRL7));
		assertFalse(BRL7.add(EUR19).equals(EUR19));
		assertEquals(USD11.add(BRLempty),bagBRLemptyUSD11);
		assertFalse(BRLempty.add(USD11).equals(BRLempty));
		assertFalse(BRLempty.add(USD11).equals(USD11));
		assertEquals(EUR19.add(BRLmax),bagEUR19BRLmax);
		assertFalse(BRLmax.add(EUR19).equals(BRLmax));
		assertFalse(BRLmax.add(EUR19).equals(EUR19));
		assertEquals(BRL0.add(GBP7),bagBRL0GBP7);
		assertFalse(GBP7.add(BRL0).equals(GBP7));
		assertFalse(GBP7.add(BRL0).equals(BRL0));
		assertEquals(BRL0.add(EUR0),bagBRL0EUR0);
		assertFalse(EUR0.add(BRL0).equals(BRL0));
		assertFalse(BRL0.add(EUR0).equals(BRL0));
		//Fim do Teste
	}
	/**
	 * Este metodo verifica o tamanho da Moneybag que o metodo add da Money retorna
	 * Teste da implementacao do Passo 10
	 */
	public void VerificarMetodoAddDaClasseMoney_QuandoAddRecebeMoneyDiferentesRetornaMoneyBagDeTamanho2() {

			assertEquals(((MoneyBag) BRL7.add(EUR19)).getSize(), 2);
			assertFalse(((MoneyBag) BRL7.add(EUR19)).getSize() <= 1);
			assertEquals(((MoneyBag) USD11.add(BRLempty)).getSize(), 2);
			assertFalse(( (MoneyBag) BRLempty.add(USD11)).getSize() <= 1);
			assertEquals(( (MoneyBag) EUR19.add(BRLmax)).getSize(),2);
			assertFalse(( (MoneyBag) BRLmax.add(EUR19)).getSize() <= 1);
			assertEquals(( (MoneyBag) BRL0.add(GBP7)).getSize(),2);
			assertFalse(( (MoneyBag) GBP7.add(BRL0)).getSize() <= 1);
			assertEquals(( (MoneyBag) BRL0.add(EUR0)).getSize(),2);
			assertFalse(( (MoneyBag) EUR0.add(BRL0)).getSize() <= 1);
			assertFalse(( (MoneyBag) BRL7.add(GBP7)).getSize() >= 3);
	}
	/**
	 * Este Metodo testa o metodo add quando recebe Money diferentes
	 * Teste da implementacao do Passo 10
	 */
	@Test
	public void VerificarMetodoAddDaClasseMoney_QuandoSomaMoneyDiferentesRetornaMoneyBagComOsDoisMoneys() {
		//Declarando variaveis para usar neste teste
		MoneyBag bagBRL7EUR19 = new MoneyBag();
		MoneyBag bagBRLemptyUSD11 = new MoneyBag();
		MoneyBag bagEUR19BRLmax = new MoneyBag();
		MoneyBag bagBRL0GBP7 = new MoneyBag();
		MoneyBag bagBRL0EUR0 = new MoneyBag();
		//Fim da declaracao
		
		//Montando Moneybags
		bagBRL7EUR19 = ((MoneyBag) BRL7.add(EUR19));
		bagBRLemptyUSD11 = (MoneyBag) USD11.add(BRLempty);
		bagEUR19BRLmax = (MoneyBag) EUR19.add(BRLmax);
		bagBRL0GBP7 = (MoneyBag) BRL0.add(GBP7);
		bagBRL0EUR0 = (MoneyBag) BRL0.add(EUR0);
		//Fim da montagem
		
		//Teste
		assertTrue(bagBRL7EUR19.hasMoney(BRL7));
		assertTrue(bagBRL7EUR19.hasMoney(EUR19));
		assertFalse(bagBRL7EUR19.hasMoney(BRL0));
		assertFalse(bagBRL7EUR19.hasCurrency(USD));
		assertTrue(bagBRLemptyUSD11.hasMoney(USD11));
		assertTrue(bagBRLemptyUSD11.hasMoney(BRLempty));
		assertFalse(bagBRLemptyUSD11.hasMoney(EUR0));
		assertFalse(bagBRLemptyUSD11.hasCurrency(GBP));
		assertTrue(bagEUR19BRLmax.hasMoney(EUR19));
		assertTrue(bagEUR19BRLmax.hasMoney(BRLmax));
		assertFalse(bagEUR19BRLmax.hasMoney(EUR0));
		assertFalse(bagEUR19BRLmax.hasCurrency(USD));
		assertTrue(bagBRL0GBP7.hasMoney(BRL0));
		assertTrue(bagBRL0GBP7.hasMoney(GBP7));
		assertFalse(bagBRL0GBP7.hasCurrency(EUR));
		assertFalse(bagBRL0GBP7.hasMoney(USD11));
		assertTrue(bagBRL0EUR0.hasMoney(BRL0));
		assertTrue(bagBRL0EUR0.hasMoney(EUR0));
		assertFalse(bagBRL0EUR0.hasMoney(BRLempty));
		assertFalse(bagBRL0EUR0.hasCurrency(GBP));
		//Fim do Teste
	}
	/**
	 * Este Metodo testa se o setAmount da Classe Money impede a atribuicao de inteiros negativos
	 * Testa implementacao do Passo 1
	 */
	@Test (expected = RuntimeException.class)
	public void VerificarMetodoSetAmountDaClasseMoney_QuandoAtribuiNegativoEnviaRunTimeException(){
		// Ao criar o objeto exceptionMoney atribuiu-se um valor inteiro negativo para a amount
		//Espera-se que uma excecao seja gerada e capturada por esse teste validando o metodo.
		@SuppressWarnings("unused")
		Money exceptionMoney = new Money(-1,BRL);
	}
}
