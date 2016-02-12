
public abstract class BankAccount {
	
	private BankCustomer customer;
	private String accountNumber;
	private DollarAmount balance;
	
	public BankAccount(BankCustomer customer, String accountNumber, DollarAmount amount){
		this.customer=customer;
		this.accountNumber=accountNumber;
		balance = amount;
	}
	
	public DollarAmount deposit(DollarAmount amountToDeposit){
		balance=balance.plus(amountToDeposit);
		return balance;

		
	}
	
	
	
	public DollarAmount getBalance(){
		return balance;
	}
	
	public void transfer(BankAccount accountReceivingTransfer, DollarAmount amountToTransfer){
		this.withdraw(amountToTransfer);
		//3 ways to deposit into account receiving transfer
		//accountReceivingTransfer.balance=accountReceivingTransfer.balance.plus(amountToTransfer);
		//accountReceivingTransfer.balance=accountReceivingTransfer.getBalance().plus(amountToTransfer);
		accountReceivingTransfer.deposit(amountToTransfer);
		
		
	}
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		//return balance after withdrawal
		balance = balance.minus(amountToWithdraw);
		return balance;
	}
	
	public abstract String getAccountType();
	public abstract String getAccountNumber();
	
	
}
