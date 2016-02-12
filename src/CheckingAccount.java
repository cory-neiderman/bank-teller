
public class CheckingAccount extends BankAccount {
	
	
	public CheckingAccount(BankCustomer customer, String accountNumber, DollarAmount amount) {
		super(customer, accountNumber, amount);
		
	}
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		if(this.getBalance().minus(amountToWithdraw).isNegative()){
			if(this.getBalance().minus(amountToWithdraw).minus(new DollarAmount(1000)).isLessThan(new DollarAmount(-10000))){
				return this.getBalance();  //if withdrawal plus $10 leaves the account below -100, then no transaction occurs
			}
			else{						
				super.withdraw(amountToWithdraw);
				super.withdraw(new DollarAmount(1000));  //if withdrawal leaves the account negative, then a $10 fee is imposed
				return getBalance();
			}
		}
		super.withdraw(amountToWithdraw);
		return getBalance();
	} 

}
