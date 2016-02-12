
import java.util.ArrayList;
import java.util.List;

 class Bank {
	
	private List<BankCustomer> customers;
	
	public Bank() {
		customers = new ArrayList<>();
	}
	
	public void addBankCustomer(BankCustomer newCustomer) {
		customers.add(newCustomer);
	}
	
	public List<BankCustomer> getBankCustomers() {
		return customers;
	}
}
