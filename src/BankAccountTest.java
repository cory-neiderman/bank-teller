
public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//manual tests
		DollarAmount firstAmount = new DollarAmount(250);
		BankCustomer firstCustomer = new BankCustomer("Cory", "cleveland", "4");
		//BankAccount firstAccount = new BankAccount(firstCustomer, "12345", firstAmount);
		CheckingAccount firstAccount = new CheckingAccount(firstCustomer, "12345", firstAmount);

		System.out.print(firstAccount.getBalance().getDollars()); 
		System.out.println(firstAccount.getBalance().getCents());
		
		DollarAmount depositAmount = new DollarAmount(125);
		DollarAmount finalAmount = new DollarAmount(375);
		if(firstAccount.deposit(depositAmount).equals(finalAmount))
			System.out.println("Amounts are equal. Success");
		
		if(firstAccount.getBalance().equals(finalAmount))
			System.out.println("Amounts are equal. Success");

		
		DollarAmount transferAccountBalance = new DollarAmount(411);
		//BankAccount transferAccount = new BankAccount(firstCustomer, "112233", transferAccountBalance);
		CheckingAccount transferAccount = new CheckingAccount(firstCustomer, "112233", transferAccountBalance);
		
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
		//BankAccount myBankAccount = new BankAccount(firstCustomer, "111111", myAmount);  	//initialize new BankAccount
		CheckingAccount myBankAccount = new CheckingAccount(firstCustomer, "111111", myAmount);
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
		//BankAccount accountToTransferTo = new BankAccount(firstCustomer,"2468", transferAccountAmount);
		CheckingAccount accountToTransferTo = new CheckingAccount(firstCustomer,"2468", transferAccountAmount);

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
		
		
		
		
		
		if(allTestsPassed) {		
			System.out.println("All tests PASSED!");
		}
		
		System.out.println();
		System.out.println();
		
		//test SavingAccount class
		SavingsAccount mySavingsAccount = new SavingsAccount(firstCustomer, "2468", new DollarAmount(50000));
		
		System.out.println(mySavingsAccount.getBalance().getDollars()+"."+mySavingsAccount.getBalance().getCents()); 
		System.out.println(mySavingsAccount.getBalance());
		System.out.println(mySavingsAccount.withdraw(new DollarAmount(50000)));
		System.out.println(mySavingsAccount.withdraw(new DollarAmount(20000)));
		System.out.println(mySavingsAccount.getBalance());
		System.out.println(mySavingsAccount.withdraw(new DollarAmount(20000)));
		mySavingsAccount.deposit(new DollarAmount(3000));
		System.out.println(mySavingsAccount.getBalance());

		System.out.println();
		System.out.println();
		
		//now test checking acount
		CheckingAccount myCheckingAccount = new CheckingAccount(firstCustomer, "2468", new DollarAmount(50000));
		System.out.println(myCheckingAccount.getBalance());
		System.out.println(myCheckingAccount.withdraw(new DollarAmount(50000))+", "+myCheckingAccount.getBalance());
		System.out.println(myCheckingAccount.withdraw(new DollarAmount(60000))+", "+myCheckingAccount.getBalance());
		System.out.println(myCheckingAccount.withdraw(new DollarAmount(5000))+", "+myCheckingAccount.getBalance());
		System.out.println(myCheckingAccount.withdraw(new DollarAmount(1000))+", "+myCheckingAccount.getBalance());
		System.out.println(myCheckingAccount.deposit(new DollarAmount(50000))+", "+myCheckingAccount.getBalance());
		System.out.println(myCheckingAccount.withdraw(new DollarAmount(1000))+", "+myCheckingAccount.getBalance());
		
		System.out.println();
		System.out.println();
		
		/*BankCustomer testCustomer = new BankCustomer("Rich Man", "(555) 555-5555", "Cleveland");
		CheckingAccount testCustomerCheckingAccount = new CheckingAccount(testCustomer, "12345", new DollarAmount(2000000)); 
		SavingsAccount testCustomerSavingsAccount = new SavingsAccount(testCustomer, "77777", new DollarAmount(1000000));
		testCustomer.setSavingsAccount(testCustomerSavingsAccount);
		testCustomer.setCheckingAccount(testCustomerCheckingAccount);
		System.out.println(testCustomer.isVIP());
		System.out.println(testCustomer.getCheckingAccount().getBalance());
		
		BankCustomer secondCustomer = new BankCustomer("Rich Man", "(555) 555-5555", "Cleveland");
		CheckingAccount secondCustomerCheckingAccount = new CheckingAccount(secondCustomer, "12345", new DollarAmount(50000)); 
		SavingsAccount secondCustomerSavingsAccount = new SavingsAccount(secondCustomer, "77777", new DollarAmount(20000));
		secondCustomer.setSavingsAccount(secondCustomerSavingsAccount);
		secondCustomer.setCheckingAccount(secondCustomerCheckingAccount);
		System.out.println(secondCustomer.isVIP());
		
		System.out.println(secondCustomer.getCheckingAccount().withdraw(new DollarAmount(5000)));
		System.out.println(secondCustomer.getCheckingAccount().getBalance());
		System.out.println(secondCustomer.getCheckingAccount().deposit(new DollarAmount(2000000)));
		System.out.println(secondCustomer.getSavingsAccount().getBalance());
		System.out.println(secondCustomer.isVIP());
		System.out.println(secondCustomer.getSavingsAccount().deposit(new DollarAmount(500000)));
		System.out.println(secondCustomer.isVIP());
		System.out.println(secondCustomer.getCheckingAccount().withdraw(new DollarAmount(2100000)));
		System.out.println(secondCustomer.getCheckingAccount().withdraw(new DollarAmount(2000000)));
		System.out.println(secondCustomer.getCheckingAccount().withdraw(new DollarAmount(50000)));
		
		System.out.println(secondCustomer.getSavingsAccount().withdraw(new DollarAmount(6000000)));
		System.out.println(secondCustomer.getSavingsAccount().withdraw(new DollarAmount(505000)));
		System.out.println(secondCustomer.getSavingsAccount().withdraw(new DollarAmount(1)));
		System.out.println(secondCustomer.getSavingsAccount().withdraw(new DollarAmount(4)));
		*/
		
		BankCustomer dude = new BankCustomer("dude", "(111)867-5309", "the land");
		
		CheckingAccount dudesCheckingAccount1 = new CheckingAccount(dude, "12345", new DollarAmount(500000));
		CheckingAccount dudesCheckingAccount2 = new CheckingAccount(dude, "12345", new DollarAmount(1000000));
		CheckingAccount dudesCheckingAccount3 = new CheckingAccount(dude, "12345", new DollarAmount(7000));
		SavingsAccount dudesSavingsAccount1 = new SavingsAccount(dude, "12345", new DollarAmount(4));
		SavingsAccount dudesSavingsAccount2 = new SavingsAccount(dude, "12345", new DollarAmount(1575000));
		SavingsAccount dudesSavingsAccount3 = new SavingsAccount(dude, "12345", new DollarAmount(56700));
		
		dude.addBankAccount(dudesCheckingAccount1);
		dude.addBankAccount(dudesSavingsAccount1);

		if(dude.isVIP()){
			System.out.println("Customer is a VIP.  His total balance is "+dude.getAccountBalanceTotal());
		}
		else{
			System.out.println("Customer is NOT a VIP.  His total balance is "+dude.getAccountBalanceTotal());

		}
		dude.addBankAccount(dudesCheckingAccount2);
		dude.addBankAccount(dudesSavingsAccount2);
		dude.addBankAccount(dudesCheckingAccount3);
		dude.addBankAccount(dudesSavingsAccount3);

		if(dude.isVIP()){
			System.out.println("Customer is a VIP.  His total balance is "+dude.getAccountBalanceTotal());
		}
		else{
			System.out.println("Customer is NOT a VIP.  His total balance is "+dude.getAccountBalanceTotal());

		}
		System.out.println(new DollarAmount(500000).plus(new DollarAmount(1000000)).plus(new DollarAmount(7000)).plus(new DollarAmount(4)).plus(new DollarAmount(1575000)).plus(new DollarAmount(56700)));

		

	}

}
