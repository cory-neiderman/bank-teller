
public class SavingsAccount extends BankAccount {
	private DollarAmount balance;
	public SavingsAccount(String name, String accountNumber, DollarAmount amount) {
		super(name, accountNumber, amount);
		balance = amount;
		// TODO Auto-generated constructor stub
	}
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		if(balance.minus(amountToWithdraw).minus(new DollarAmount(200)).isNegative()){
			return balance;  //dont take anything out
		}
		else if(balance.minus(amountToWithdraw).isLessThan(new DollarAmount(15000))){  //if balance is less than 150, then take a 2 dollar charge.
			return balance.minus(amountToWithdraw).minus(new DollarAmount(200));
		}
		return balance.minus(amountToWithdraw);
	} 

}
