
public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//manual tests
		DollarAmount firstAmount = new DollarAmount(250);
		BankAccount firstAccount = new BankAccount("Cory", "12345", firstAmount);
		
		System.out.print(firstAccount.getBalance().getDollars()); 
		System.out.println(firstAccount.getBalance().getCents());
		
		DollarAmount depositAmount = new DollarAmount(125);
		DollarAmount finalAmount = new DollarAmount(375);
		if(firstAccount.deposit(depositAmount).equals(finalAmount))
			System.out.println("Amounts are equal. Success");
		
		if(firstAccount.getBalance().equals(finalAmount))
			System.out.println("Amounts are equal. Success");

		
		DollarAmount transferAccountBalance = new DollarAmount(411);
		BankAccount transferAccount = new BankAccount("Joe", "112233", transferAccountBalance);
		
		DollarAmount transferAmount = new DollarAmount(200);
		
		firstAccount.transfer(transferAccount, transferAmount);
		
		DollarAmount firstAccountBalanceAfterTransfer = new DollarAmount(175);
		DollarAmount transferAccountBalanceAfterTransfer = new DollarAmount(611);
		
		if(firstAccount.getBalance().equals(firstAccountBalanceAfterTransfer))
			System.out.println("Success");
		else
			System.out.println("Fail");
		
		if(transferAccount.getBalance().equals(transferAccountBalanceAfterTransfer))
			System.out.println("Success");
		else{
			System.out.println("Fail.  balance is "+transferAccount.getBalance().getDollars()+transferAccount.getBalance().getCents());
		}
		
		//automated tests
		System.out.println();
		System.out.println();
		System.out.println("Automated tests start here");
		System.out.println();
		boolean allTestsPassed=true;
		
		DollarAmount myAmount = new DollarAmount(350);	//bank account needs a starting dollar amount
		BankAccount myBankAccount = new BankAccount("Vict0ar", "111111", myAmount);  	//initialize new BankAccount
		if(!myBankAccount.getBalance().equals(new DollarAmount(350))){				//test the starting balance using getBalance
			allTestsPassed=false;
			System.out.println("Test 1 FAIL. Balance should be equal to DollarAmount(350) but is not.");
		}
		DollarAmount amountToDeposit = new DollarAmount(212);		//now lets test the deposit method.  we need a DollarAmount to deposit
		DollarAmount amountAfterDeposit = new DollarAmount(562);	//we need a final DollarAmount and 350+212=562.
																	//use the deposit method which returns a DollarAmount object and compare to
																	//our final DollarAmount object amountAfterDeposit ie DollarAmount(562)
		if(!myBankAccount.deposit(amountToDeposit).equals(amountAfterDeposit)){
			allTestsPassed=false;
			System.out.println("Test 2 FAIL. deposit method should return a DollarAmount equal to amountAfterDeposit.Instead balance is +");
			System.out.print(myBankAccount.getBalance().getDollars()); 
			System.out.println(myBankAccount.getBalance().getCents());
		}
		//check withdraw method in same fashion
		DollarAmount amountToWithdraw=new DollarAmount(147);
		DollarAmount amountAfterWithdrawal = new DollarAmount(415);			//562-147=415
		if(!myBankAccount.withdraw(amountToWithdraw).equals(amountAfterWithdrawal)){
			allTestsPassed=false;
			System.out.println("Test 2 FAIL. deposit method should return a DollarAmount equal to amountAfterDeposit.Instead balance is +");
			System.out.print(myBankAccount.getBalance().getDollars()); 
			System.out.println(myBankAccount.getBalance().getCents());
		}
		//now test the transfer method.  we need a new bank account and a DollarAmount to transfer and a starting balance
		DollarAmount transferAccountAmount = new DollarAmount(720);
		BankAccount accountToTransferTo = new BankAccount("James","2468", transferAccountAmount);
		DollarAmount amountToTransfer = new DollarAmount(78); 
		DollarAmount myAccountAmountAfterTransfer = new DollarAmount(337);			//415-78=337
		DollarAmount transferAccountAmountAfterTransfer = new DollarAmount(798);	//720+78=798
		myBankAccount.transfer(accountToTransferTo, amountToTransfer);				//call the transfer method
		//now make sure myBankAccount has the proper balance and accountToTransferTo has the proper balance
		if(!myBankAccount.getBalance().equals(myAccountAmountAfterTransfer)){
			allTestsPassed=false;
			System.out.println("Test 3 FAIL. Balance of myAccount should be equal to myAccountAmountAfterTransfer instead it is +");
			System.out.print(myBankAccount.getBalance().getDollars()); 
			System.out.println(myBankAccount.getBalance().getCents());
		}
		if(!accountToTransferTo.getBalance().equals(transferAccountAmountAfterTransfer)){
			allTestsPassed=false;
			System.out.println("Test 4 FAIL. accountToTransferTo Balance should be equal to transferAccountAmountAfterTransfer instead it is +");
			System.out.print(accountToTransferTo.getBalance().getDollars()); 
			System.out.println(accountToTransferTo.getBalance().getCents());
		}
		
		//test savings account
		
		
		if(allTestsPassed) {		
			System.out.println("All tests PASSED!");
		}
		
		SavingsAccount mySavingsAccount = new SavingsAccount("Cory", "2468", new DollarAmount(50000));
		System.out.println(mySavingsAccount.getBalance().getDollars()+"."+mySavingsAccount.getBalance().getCents()); 
		System.out.println(mySavingsAccount.withdraw(new DollarAmount(40000)));
		System.out.println(mySavingsAccount.withdraw(new DollarAmount(52000)));
		System.out.println(mySavingsAccount.withdraw(new DollarAmount(49999)));
		
		CheckingAccount myCheckingAccount = new CheckingAccount("CVN", "442233", new DollarAmount(30000));
		System.out.println(myCheckingAccount.getBalance());
		System.out.println(myCheckingAccount.withdraw(new DollarAmount(35000)));
		System.out.println(myCheckingAccount.withdraw(new DollarAmount(39500)));
		System.out.println(myCheckingAccount.withdraw(new DollarAmount(45000)));

		

	}

}
