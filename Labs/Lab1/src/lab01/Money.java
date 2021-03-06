/**
 * LAB-1 CES-28
 * Data: 01/08/2017
 * @encoding UTF-8
 * @author - Dylan Nakandakari Sugimoto
 * @author - Gabriel Adriano de Melo
 * 
 * Esse pacote contem as classes principais, isto é, implementadas
 */
package lab01;


/**
 * PASSO 1 - CLASSE MONEY E SETTERS PÚBLICOS CRIADOS
 * Representa a classe Money conforme especificado
 * Possui PASSO 1.
 */
public class Money implements Pocket {
	private int _amount;
	private Currency _currency;
	/**
	 * 
	 * @param amount A quantidade de dinheiro
	 * @param currency O tipo do dinheiro
	 */
	public Money(int amount, Currency currency) {
		setAmount(amount);
		setCurrency(currency);
	}
	
	/**
	 * Modifica a quantidade de dinheiro.
	 * @throws Erro se amount for negativo
	 * @param amount Quantidade sempre positiva
	 */
	public void setAmount(int amount) {
		if(amount < 0) {
			
			throw new ArithmeticException("amount não deve ser negativo!");
		}
		this._amount = amount;
	}
	
	/**
	 * Modifica a moeda do dinheiro.
	 * @param currency Novo tipo de moeda.
	 */
	public void setCurrency(Currency currency) {
		this._currency = currency;
	}
	
	
	@Override
	public Pocket add(Money money) {
		if(this.getCurrency().equals(money.getCurrency())){
			return new Money(this.getAmount() + money.getAmount(), this.getCurrency());
		}
		return new MoneyBag(this, money);
	}
	
	
	@Override
	public int getAmount() {
		return this._amount;
	}
	
	/**
	 * Retorna um novo objeto Currency respectivo
	 * @return Um clone do Currency desda moeda
	 */
	public Currency getCurrency() {
		return this._currency.clonar();
	}
	
	/**
	 * Cria uma cópia deste objeto
	 * @return Retorna um clone.
	 */
	public Money clonar() {
		return new Money(this.getAmount(), this.getCurrency());
	}
	
	
	@Override
	public boolean equals(Object money) {
		if (money instanceof Money) {
			Money m = (Money) money;
			return this._currency.equals(m._currency) && this.getAmount() == m.getAmount();
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return this.getAmount() + " " + this.getCurrency().toString();
	}
}
