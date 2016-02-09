
public class BankAccount {
	
	private String name;
	private String accountNumber;
	private DollarAmount balance;
	
	public BankAccount(String name, String accountNumber, DollarAmount amount){
		this.name=name;
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
		balance = balance.minus(amountToTransfer);
		//accountReceivingTransfer.balance=accountReceivingTransfer.balance.plus(amountToTransfer);
		//either works
		accountReceivingTransfer.balance=accountReceivingTransfer.getBalance().plus(amountToTransfer);
		
	}
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		//return balance after withdrawal
		balance = balance.minus(amountToWithdraw);
		return balance;
	}
	
	
	
	
	
}