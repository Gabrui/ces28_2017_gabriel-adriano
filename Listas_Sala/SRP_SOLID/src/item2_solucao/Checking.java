package item2_solucao;

public class Checking extends BankAccount {
	public void Transfer(double amount, BankAccount toAccount) {
		this.Withdraw(amount);
		toAccount.Deposit(amount);
	};
}