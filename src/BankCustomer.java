import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
	
	private String name;
	private String address;
	private String phoneNumber;
	private SavingsAccount customerSavingsAccount;
	private CheckingAccount customerCheckingAccount;
	
	private List<BankAccount> accountsList = new ArrayList<>();
	
	public BankCustomer(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.customerSavingsAccount = customerSavingsAccount;
		this.customerCheckingAccount = customerCheckingAccount;
	}
	
	/*public void setSavingsAccount(SavingsAccount customerSavingsAccount){
		this.customerSavingsAccount=customerSavingsAccount;
	}
	
	public void setCheckingAccount(CheckingAccount customerCheckingAccount){
		this.customerCheckingAccount=customerCheckingAccount;
	}
	
	public SavingsAccount getSavingsAccount(){
		return customerSavingsAccount;
	}
	public CheckingAccount getCheckingAccount(){
		return customerCheckingAccount;
	}*/
	
	public void addBankAccount(BankAccount account){
		accountsList.add(account);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {		//address and phone number can be changed so they have setter methods.  
		this.address = address;						//name cant be changed.
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}
	
	public boolean isVIP(){
		if(customerSavingsAccount.getBalance().plus(customerCheckingAccount.getBalance()).isGreaterThan(new DollarAmount(2500000))){
			return true;
		}
		else{
			return false;
		}
	}
	
	

}
