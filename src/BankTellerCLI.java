
import com.techelevator.util.Terminal;

public class BankTellerCLI {

	private Bank theBank;
	
	public BankTellerCLI() {
		theBank = new Bank();
	}
	
	
	public static void main(String[] args) {
		
		BankTellerCLI application = new BankTellerCLI();
		application.run();
	}
	
	public void run() {
		while(true) {
			String choice = getChoiceFromMainMenu();
			if(choice.equals("1")) {
				addBankCustomer();
			}else if (choice.equals("2")){
				addAccount();
			}else if (choice.equals("3")){
				deposit();
			}
			else if(choice.equals("6")) {
				exit();
			} 
		}
		
	}
	
	private String getChoiceFromMainMenu() {
		printBanner("MAIN MENU");
		
		System.out.println("Please choose from the following options:\n");
		
		System.out.println("1) Add BankCustomer");
		System.out.println("2) Add Account");
		System.out.println("3) Deposit");
		System.out.println("4) Withdrawal");
		System.out.println("5) Transfer");
		System.out.println("6) Exit");
		System.out.println();
		
		return getUserInput("Enter number");
	}
	
	public void addBankCustomer() {
		printBanner("ADD BankCustomer");
		
		String name = getUserInput("Enter name");
		String address = getUserInput("Enter address");
		String phoneNumber = getUserInput("Enter phone number");
		BankCustomer newBankCustomer = new BankCustomer(name, address, phoneNumber);
		theBank.addBankCustomer(newBankCustomer);
		System.out.println("\n*** "+newBankCustomer.getName()+" added as a BankCustomer ***");
	}
	
	private void addAccount(){
		
		printBanner("ADD ACCOUNT");
		displayCustomer();
		
		
		int choice = Integer.parseInt(getUserInput("Enter number"));
		
		int accountChoice = Integer.parseInt(getUserInput("\nChoose an account type:\n\n1)Checking\n2)Savings\n\nEnter number"));
		String accountNumber = getUserInput("\nEnter number");
		if(accountChoice==1){
			CheckingAccount newCheckingAccount = new CheckingAccount(theBank.getBankCustomers().get(choice-1), accountNumber, new DollarAmount(5000));
			theBank.getBankCustomers().get(choice-1).addBankAccount(newCheckingAccount);
			System.out.println("\n*** Checking account "+accountNumber+" has been created for "+theBank.getBankCustomers().get(choice-1).getName()+" ***");

		}
		else{
			SavingsAccount newSavingsAccount = new SavingsAccount(theBank.getBankCustomers().get(choice-1), accountNumber, new DollarAmount(5000));
			theBank.getBankCustomers().get(choice-1).addBankAccount(newSavingsAccount);
			System.out.println("\n*** SavingsAccount "+accountNumber+" has been created for "+theBank.getBankCustomers().get(choice-1).getName()+" ***");

		}
	}
	
	private void deposit(){
		printBanner("DEPOSIT");
		displayCustomer();
		
		int choice = Integer.parseInt(getUserInput("Enter number"));
		System.out.println("\nChoose an account:\n");		
		for(int i=0; i<theBank.getBankCustomers().get(choice-1).getAccountList().size(); i++){
			System.out.println(i+1+") "+theBank.getBankCustomers().get(choice-1).getAccountList().get(i).getAccountType()+"		"+theBank.getBankCustomers().get(choice-1).getAccountList().get(i).getAccountNumber());
		}
		int accountChoice= Integer.parseInt(getUserInput("Enter number"));
		DollarAmount amountToDeposit = new DollarAmount(Long.parseLong(getUserInput("Enter deposit amount")));
		theBank.getBankCustomers().get(choice-1).getAccountList().get(accountChoice-1).deposit(amountToDeposit);
		System.out.println("***"+amountToDeposit.toString()+" deposited into "+
		theBank.getBankCustomers().get(choice-1).getAccountList().get(accountChoice-1).getAccountType()+" "+
		theBank.getBankCustomers().get(choice-1).getAccountList().get(accountChoice-1).getAccountNumber()+" ***");
		System.out.println("*** "+theBank.getBankCustomers().get(choice-1).getAccountBalance(theBank.getBankCustomers().get(choice-1).getAccountList().get(accountChoice-1)));		
	}
	
	private void printBanner(String bannerText) {
		System.out.println("\n###### "+bannerText+" ######\n");
	}
	
	private String getUserInput(String prompt) {
		System.out.print(prompt+" >>> ");
		return Terminal.readLine();
	}
	
	public void displayCustomer(){
		System.out.println("\nChoose a BankCustomer:\n");
		
		for(int i=0; i<theBank.getBankCustomers().size(); i++){
			System.out.println(i+1+") "+theBank.getBankCustomers().get(i).getName()+"		"+theBank.getBankCustomers().get(i).getAddress());
		}
	}
	
	public void exit() {
		System.out.println("\n***Exiting...Have a nice day.***");
		System.exit(0);
	}
}
