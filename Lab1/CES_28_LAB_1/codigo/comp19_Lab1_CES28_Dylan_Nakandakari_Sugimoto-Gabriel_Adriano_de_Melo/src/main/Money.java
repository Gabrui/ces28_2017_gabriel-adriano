/**
 * LAB-1 CES-28
 *@date   01/08/2017
 *@author Dylan N. Sugimoto
 *@author Gabriel Adriano de Melo
 * 
 * Esse pacote guarda a classe Money e a classe MoneyBag
 */
package main;

/**
 * @version 1.0, 01/08/2017
 * @param {_amount} representa a quantidade da moeda (inteiro positivo) 
 * @param {_currency} representa o tipo da moeda (string de tres letras)
 * 
 * metodo setAmount: estabelece o valor da variavel _amount
 * metodo setCurrency: estabelece o valor da variavel _currency
 * metodo add: adiciona uma Money
 * metodo getAmount: retorna o valor de _amount
 * metodo getCurrency: retorna o valor de _currency
 */
class Money {
	private int _amount;
	private String _currency;
	public Money(int amount, String currency) {
		setAmount(amount);
		setCurrency(currency);
	}
	public void setAmount(int amount) {
		if(amount < 0) {
			
			throw new ArithmeticException("_amount negativo!");
		}
		this._amount = amount;
	}
	public void setCurrency(String currency) {
		if(currency.length() != 3) {
			throw new ArithmeticException("Tamanho de _currency diferente de 3!");
		}
		this._currency = currency;
	}
	public Money add(Money money) {
		if(getCurrency().equals(money.getCurrency())){
			money.setAmount(this._amount + money.getAmount());
			
		}
		return money;
	}
	public int getAmount() {
		return this._amount;
	}
	public String getCurrency() {
		return this._currency;
	}
}
