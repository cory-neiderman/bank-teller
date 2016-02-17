
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
	
	//add exception handling to the deposit, withdrawal, and transfer screens
	//that handles cases when a user inputs an invalid DollarAmount.  In these 
	//cases, the user should be prompted to enter a valid amount.
	 
	 
	 
	public void run() {
		while(true) {
			int choice = Integer.parseInt(getChoiceFromMainMenu());
			switch(choice){
			case 1:
				addBankCustomer();
				break;
			case 2:
				addAccount();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				transfer();
				break;
			case 6:
				exit();
				break;
			default:
				invalidEntry();			//handle invalid input from user by prompting them to enter a valid choice
				break;
			
			
			}
			
			/*
			String choice = getChoiceFromMainMenu();
			if(choice.equals("1")) {
				addBankCustomer();
			}else if (choice.equals("2")){
				addAccount();
			}else if (choice.equals("3")){
				deposit();
			}
			else if(choice.equals("6")) {  
				exit();*/
			} 
		}
	public void invalidEntry(){
		System.out.println("Invalid Entry, please try again");
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
		
		String name = getUserInput("Enter name");				//ensure that any value is entered for name, address and number
		String address = getUserInput("Enter address");			//if invalid entry, prompt for proper value.  
		String phoneNumber = getUserInput("Enter phone number");
		BankCustomer newBankCustomer = new BankCustomer(name, address, phoneNumber);
		theBank.addBankCustomer(newBankCustomer);
		System.out.println("\n*** "+newBankCustomer.getName()+" added as a BankCustomer ***");
	}
	
	private void addAccount(){
		
		printBanner("ADD ACCOUNT");
		int choice=chooseCustomer();		
		int accountChoice = Integer.parseInt(getUserInput("\nChoose an account type:\n\n1)Checking\n2)Savings\n\nEnter number"));
		String accountNumber = getUserInput("\nEnter account number");  //handle case where user chooses invalid account type 
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
		
		int choice = chooseCustomer();
		
		int accountChoice=chooseCustomerAccount(choice,"Choose an account");
		boolean control = true;
		while(control){
		try{
			DollarAmount amountToDeposit = new DollarAmount(Long.parseLong(getUserInput("Enter deposit amount")));
			if(amountToDeposit.isNegative()|| amountToDeposit.equals(new DollarAmount(0))){
				throw new NumberFormatException();
			}
			theBank.getBankCustomers().get(choice-1).getAccountList().get(accountChoice-1).deposit(amountToDeposit);
			System.out.println("***"+amountToDeposit.toString()+" deposited into "+
					theBank.getBankCustomers().get(choice-1).getAccountList().get(accountChoice-1).getAccountType()+" "+
					theBank.getBankCustomers().get(choice-1).getAccountList().get(accountChoice-1).getAccountNumber()+" ***");
			System.out.println("*** New balance is "+theBank.getBankCustomers().get(choice-1).getAccountBalance(theBank.getBankCustomers().get(choice-1).getAccountList().get(accountChoice-1))+" ***");		
			control = false;
		}
		catch(NumberFormatException e){
			System.out.println("Invalid Entry, Please try again");
		}
		}
	}
	private void withdraw(){
		printBanner("WITHDRAW");
		int choice = chooseCustomer();
		int accountChoice=chooseCustomerAccount(choice, "Choose an account");
		boolean control = true;
		while(control){
		try{
			DollarAmount amountToWithdraw = new DollarAmount(Long.parseLong(getUserInput("Enter withdrawal amount")));
			if(amountToWithdraw.isNegative() || amountToWithdraw.equals(new DollarAmount(0))){
				throw new NumberFormatException();
			}
			theBank.getBankCustomers().get(choice-1).getAccountList().get(accountChoice-1).withdraw(amountToWithdraw);
			System.out.println("***"+amountToWithdraw.toString()+" withdrawn from "+
				theBank.getBankCustomers().get(choice-1).getAccountList().get(accountChoice-1).getAccountType()+" "+
				theBank.getBankCustomers().get(choice-1).getAccountList().get(accountChoice-1).getAccountNumber()+" ***");
			System.out.println("*** New balance is "+theBank.getBankCustomers().get(choice-1).getAccountBalance(theBank.getBankCustomers().get(choice-1).getAccountList().get(accountChoice-1))+" ***");		
			control = false;
		}
		catch(NumberFormatException e){
			System.out.println("Invalid Entry, Please try again");
		}
		}
	}
	//deposit and withdraw:  choose an account
	//transfer: choose a source account, choose a destination account
	private void transfer(){
		printBanner("TRANSFER");
		int choice = chooseCustomer();
		int sourceChoice=chooseCustomerAccount(choice, "Choose a source account");
		int destinationChoice=chooseCustomerAccount(choice, "Choose a destination account");
		boolean control = true;
		while(control){
		try{
			DollarAmount amountToTransfer = new DollarAmount(Long.parseLong(getUserInput("Enter transfer amount")));
			if(amountToTransfer.isNegative() || amountToTransfer.equals(new DollarAmount(0))) {
				throw new NumberFormatException();
			}
			theBank.getBankCustomers().get(choice-1).getAccountList().get(sourceChoice-1).transfer(theBank.getBankCustomers().get(choice-1).getAccountList().get(destinationChoice-1), amountToTransfer);
			System.out.println("***"+amountToTransfer.toString()+" withdrawn from "+
				theBank.getBankCustomers().get(choice-1).getAccountList().get(sourceChoice-1).getAccountType()+" "+
				theBank.getBankCustomers().get(choice-1).getAccountList().get(sourceChoice-1).getAccountNumber()+" ***");
			System.out.println("*** New balance is "+theBank.getBankCustomers().get(choice-1).getAccountBalance(theBank.getBankCustomers().get(choice-1).getAccountList().get(sourceChoice-1))+" ***");	
			System.out.println("***"+amountToTransfer.toString()+" withdrawn from "+
				theBank.getBankCustomers().get(choice-1).getAccountList().get(destinationChoice-1).getAccountType()+" "+
				theBank.getBankCustomers().get(choice-1).getAccountList().get(destinationChoice-1).getAccountNumber()+" ***");
			System.out.println("*** New balance is "+theBank.getBankCustomers().get(choice-1).getAccountBalance(theBank.getBankCustomers().get(choice-1).getAccountList().get(destinationChoice-1))+" ***");		
		}
		catch(NumberFormatException e){
			System.out.println("Invalid Entry, Please try again");
		}
		}
		
	}
	
	private void printBanner(String bannerText) {
		System.out.println("\n###### "+bannerText+" ######\n");
	}
	
	private String getUserInput(String prompt) {
		System.out.print(prompt+" >>> ");
		return Terminal.readLine();
	}
	
	public int chooseCustomer(){
		System.out.println("Choose a customer:\n");
		
		for(int i=0; i<theBank.getBankCustomers().size(); i++){
			System.out.println(i+1+") "+theBank.getBankCustomers().get(i).getName()+"		"+theBank.getBankCustomers().get(i).getAddress());
		}
		System.out.println();
		return Integer.parseInt(getUserInput("Enter number"));	//handle case where the user chooses invalid customer
	}
	public int chooseCustomerAccount(int choice, String chooseAccountPrompt){
		System.out.println("\n"+chooseAccountPrompt+":\n");	
		for(int i=0; i<theBank.getBankCustomers().get(choice-1).getAccountList().size(); i++){
			System.out.println(i+1+") "+theBank.getBankCustomers().get(choice-1).getAccountList().get(i).getAccountType()+"		"+theBank.getBankCustomers().get(choice-1).getAccountList().get(i).getAccountNumber());
		}
		return Integer.parseInt(getUserInput("\nEnter number"));  //handle case where user chooses invalid account
		
	}

	
	public void exit() {
		System.out.println("\n***Exiting...Have a nice day.***");
		System.exit(0);
	}
}
