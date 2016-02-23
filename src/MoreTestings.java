
public class MoreTestings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankCustomer testCust = new BankCustomer("john doe", "address", "phone");
		SavingsAccount testAccount = new SavingsAccount(testCust, "accct#", new DollarAmount(20000));
		System.out.println(testAccount.getBalance().getTotalAmountInCents());
	}

}
