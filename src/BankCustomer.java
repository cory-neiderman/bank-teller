import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
	
	private String name;
	private String address;
	private String phoneNumber;
	//private SavingsAccount customerSavingsAccount;
	//private CheckingAccount customerCheckingAccount;
	
	private List<BankAccount> accountsList = new ArrayList<>();
	
	public BankCustomer(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		//this.customerSavingsAccount = customerSavingsAccount;
		//this.customerCheckingAccount = customerCheckingAccount;
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
	}
	public boolean isVIP(){
		if(customerSavingsAccount.getBalance().plus(customerCheckingAccount.getBalance()).isGreaterThan(new DollarAmount(2500000))){
			return true;
		}
		else{
			return false;
		}
	}*/
	
	public void addBankAccount(BankAccount account){
		accountsList.add(account);
	}
	
	//following methods werent required but their functionality seems appropriate and they could help with testing
	public DollarAmount getAccountBalance(BankAccount account){
		return account.getBalance();
	}
	
	public DollarAmount getAccountBalanceTotal(){
		DollarAmount total= new DollarAmount(0);
		for(int i=0; i<accountsList.size(); i++){
			total=accountsList.get(i).getBalance().plus(total);
		}
		return total;
	}  
	
	public List<BankAccount> getAccountList(){
		return accountsList;
	}
	
	public boolean isVIP(){
		DollarAmount VIPAmount = new DollarAmount(2500000);
		if(getAccountBalanceTotal().isGreaterThan(VIPAmount))
			return true;
		else
			return false;
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
	
	
	
	

}
