

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {
	
	private SavingsAccount theAccount;
	
	@Before
	public void setup(){
		DollarAmount zeroDollars = new DollarAmount(0);
		BankCustomer theCustomer = new BankCustomer("John Doe", "123 Main St.", "123-46-7890");
		this.theAccount = new SavingsAccount(theCustomer, "123456789", zeroDollars);
	}

	@Test
	public void new_accounts_start_with_a_zero_balance() {
		DollarAmount zero = new DollarAmount(0);
		DollarAmount currentBalance = theAccount.getBalance();
		Assert.assertEquals(zero, currentBalance);
		
	}
	@Test
	public void deposit_increases_the_account_balance_by_the_amount_deposited(){
		DollarAmount amountToDeposit = new DollarAmount(12345678);
		DollarAmount newBalance = theAccount.deposit(amountToDeposit);
		Assert.assertEquals(amountToDeposit, newBalance);
		Assert.assertEquals(amountToDeposit, theAccount.getBalance());
	}
	
	
	
	@Test
	public void withdraw_decreases_the_amount_balance_below_zero_so_there_is_no_transaction(){
		DollarAmount amountToWithdraw = new DollarAmount(12345);
		DollarAmount newBalance = theAccount.withdraw(amountToWithdraw);
		DollarAmount newBalanceAfter = new DollarAmount(0);
		Assert.assertEquals(newBalanceAfter, newBalance);
		Assert.assertEquals(newBalanceAfter, theAccount.getBalance());
	}
	
	@Test
	public void withdraw_decreases_the_amount_balance(){
		theAccount.deposit(new DollarAmount(50000));
		DollarAmount amountToWithdraw = new DollarAmount(12345);
		DollarAmount newBalance = theAccount.withdraw(amountToWithdraw);
		DollarAmount newBalanceAfter = new DollarAmount(37655);
		Assert.assertEquals(newBalanceAfter, newBalance);
		Assert.assertEquals(newBalanceAfter, theAccount.getBalance());
	}
	
	@Test
	public void withdraw_decreases_the_amount_balance_and_takes_a_two_dollar_charge_when_below_150(){
		theAccount.deposit(new DollarAmount(50000));
		DollarAmount amountToWithdraw = new DollarAmount(40000);
		DollarAmount newBalance = theAccount.withdraw(amountToWithdraw);
		DollarAmount newBalanceAfter = new DollarAmount(9800);
		Assert.assertEquals(newBalanceAfter, newBalance);
		Assert.assertEquals(newBalanceAfter, theAccount.getBalance());
	}
	
	@Test
	public void transfer_deposits_amount_into_account_and_withdraws_from_another_account(){
		DollarAmount amountToTransfer = new DollarAmount(14000);
		BankCustomer transferCustomer = new BankCustomer("Joe Schmoe", "123 first St.", "111-46-7890");
		SavingsAccount transferAccount = new SavingsAccount(transferCustomer, "1122334455", new DollarAmount(30000));
		transferAccount.transfer(theAccount, amountToTransfer);
		DollarAmount transferAccountNewBalance = new DollarAmount(16000);
		Assert.assertEquals(transferAccountNewBalance, transferAccount.getBalance());
		DollarAmount theAccountNewBalance = new DollarAmount(14000);
		Assert.assertEquals(theAccountNewBalance, theAccount.getBalance());

	}

	@Test
	public void getAccountType_returns_savings_account(){
		Assert.assertEquals("Savings Account", theAccount.getAccountType());
	}
	
	@Test
	public void getAccountNumber_returns_account_number(){
		Assert.assertEquals("123456789", theAccount.getAccountNumber());
	}
}
	