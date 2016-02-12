
public class SavingsAccount extends BankAccount {
	public SavingsAccount(BankCustomer customer, String accountNumber, DollarAmount amount) {
		super(customer, accountNumber, amount);
		// TODO Auto-generated constructor stub
	}
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		if(this.getBalance().minus(amountToWithdraw).minus(new DollarAmount(200)).isNegative()){
			return this.getBalance();  //dont take anything out
		}
		else if(this.getBalance().minus(amountToWithdraw).isLessThan(new DollarAmount(15000))){  //if balance is less than 150, then take a 2 dollar charge.
			
			super.withdraw(amountToWithdraw);
			super.withdraw(new DollarAmount(200));
			
			return this.getBalance();
		}
		
		super.withdraw(amountToWithdraw);
		return this.getBalance();
	} 

}
