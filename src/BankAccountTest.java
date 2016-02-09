
public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DollarAmount firstAmount = new DollarAmount(250);
		BankAccount firstAccount = new BankAccount("Cory", "12345", firstAmount);
		System.out.print(firstAccount.getBalance().getDollars()); 
		System.out.println(firstAccount.getBalance().getCents());
		
		DollarAmount depositAmount = new DollarAmount(125);
		DollarAmount finalAmount = new DollarAmount(375);
		if(firstAccount.deposit(depositAmount).isEqualTo(finalAmount))
			System.out.println("Amounts are equal. Success");
		
		if(firstAccount.getBalance().isEqualTo(finalAmount))
			System.out.println("Amounts are equal. Success");

		
		DollarAmount transferAccountBalance = new DollarAmount(411);
		BankAccount transferAccount = new BankAccount("Joe", "112233", transferAccountBalance);
		
		DollarAmount transferAmount = new DollarAmount(200);
		
		firstAccount.transfer(transferAccount, transferAmount);
		
		DollarAmount firstAccountBalanceAfterTransfer = new DollarAmount(175);
		DollarAmount transferAccountBalanceAfterTransfer = new DollarAmount(611);
		
		if(firstAccount.getBalance().isEqualTo(firstAccountBalanceAfterTransfer))
			System.out.println("Success");
		else
			System.out.println("Fail");
		
		if(transferAccount.getBalance().isEqualTo(transferAccountBalanceAfterTransfer))
			System.out.println("Success");
		else{
			System.out.println("Fail.  balance is "+transferAccount.getBalance().getDollars()+transferAccount.getBalance().getCents());
		}
		
	}

}
