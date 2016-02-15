

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {
	
	private SavingsAccount theAccount;
	
	@Before
	public void setup(){
		DollarAmount zeroDollars = new DollarAmount(0);

		BankCustomer theCustomer = new BankCustomer("John Doe", "123 Main St.", "123-46-7890");
		SavingsAccount theAccount=new SavingsAccount(theCustomer, "123456789", zeroDollars);
	}

	@Test
	public void new_accounts_start_with_a_zero_balance() {
		
		DollarAmount currentBalance = theAccount.getBalance();
		DollarAmount zeroDollars = new DollarAmount(0);
		Assert.assertEquals(zeroDollars, currentBalance);
		
	}
	@Test
	public void deposit_increases_the_account_balance_by_the_amount_deposited(){
		
		DollarAmount amountToDeposit = new DollarAmount(12345);
		DollarAmount newBalance = theAccount.deposit(amountToDeposit);
		Assert.assertEquals(amountToDeposit, newBalance);
		Assert.assertEquals(amountToDeposit, theAccount.getBalance());
	}

}
