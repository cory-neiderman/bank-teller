
public class CheckingAccount extends BankAccount {
	
	private DollarAmount balance;
	
	public CheckingAccount(String name, String accountNumber, DollarAmount amount) {
		super(name, accountNumber, amount);
		balance = amount;
		// TODO Auto-generated constructor stub
	}
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		if(balance.minus(amountToWithdraw).isNegative()){
			if(balance.minus(amountToWithdraw).minus(new DollarAmount(1000)).isLessThan(new DollarAmount(-10000))){
				return balance;  //if withdrawal plus 10.00 fee is less than 100.00 then no transaction occurs and balance is returned unchanged
			}
			else{
				return balance.minus(amountToWithdraw).minus(new DollarAmount(1000));
			}
		}
		return balance.minus(amountToWithdraw);
	} 

}
