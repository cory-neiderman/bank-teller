
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.techelevator.util.Terminal;

public class BankTellerCLI {

	private Bank theBank;
	
	public BankTellerCLI() {
		theBank = new Bank();
	}
	
	public static void main(String[] args) throws IOException{
		
		BankTellerCLI application = new BankTellerCLI();
		application.run();
	}
	 
	public void run() throws IOException {
		while (true) {
			String choice = getChoiceFromMainMenu();
			switch (choice) {
				case "1":
					addBankCustomer();
					break;
				case "2":
					addAccount();
					break;
				case "3":
					deposit();
					break;
				case "4":
					withdraw();
					break;
				case "5":
					transfer();
					break;
				case "6":
					exportData();
					break;
				case "7":
					importData();
				case "8":
					exit();
					break;
				default:
					invalidEntry();
					break;

			}

		}
	}
	public void invalidEntry(){
		System.out.println("Invalid Entry, please try again");
	}
	
	public void importData() throws IOException{
		printBanner("IMPORT DATA");
		System.out.print("Enter the path to import a file from >>> ");
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		String fileName = userInput.readLine();
		int customerImportCount=0;
		int accountImportCount=0;
		try(FileReader reader = new FileReader(fileName)) {
			BufferedReader lineReader = new BufferedReader(reader);
			String line = lineReader.readLine();
			while(line!=null){
				if(line.startsWith("C")){
					customerImportCount+=1;
					String[] customerInfo = line.substring(2).split("\\|");
					BankCustomer newCustomer = new BankCustomer(customerInfo[0], customerInfo[1], customerInfo[2]);
					theBank.addBankCustomer(newCustomer);
					line=lineReader.readLine();
					boolean sameCustomer = true;
					while(sameCustomer && line!=null){
						if(line.startsWith("A|C")){
							String[] accountInfo = line.substring(2).split("\\|");
							CheckingAccount newAccount = new CheckingAccount(newCustomer, accountInfo[1], new DollarAmount(Long.parseLong(accountInfo[2])));
							newCustomer.addBankAccount(newAccount);
							line=lineReader.readLine();
							accountImportCount += 1;
						}
						else if(line.startsWith("A|S")){
							String[] accountInfo = line.substring(2).split("\\|");
							SavingsAccount newAccount = new SavingsAccount(newCustomer, accountInfo[1], new DollarAmount(Long.parseLong(accountInfo[2])));
							newCustomer.addBankAccount(newAccount);
							line=lineReader.readLine();
							accountImportCount += 1;
						}
						else{
							sameCustomer=false;
						}
					}

				}
			}
		}
		
		System.out.println("\n*** "+customerImportCount+" customers and "+accountImportCount+" accounts imported from "+fileName+"\n");
		//importTest();
	}
	
	/* 
	 * public void importTest(){
		for(int i=0; i<theBank.getBankCustomers().size(); i++){
			System.out.println(theBank.getBankCustomers().get(i).getName()+" "+theBank.getBankCustomers().get(i).getAddress()+" "
					+theBank.getBankCustomers().get(i).getPhoneNumber());
			for(int j=0; j<theBank.getBankCustomers().get(i).getAccountList().size(); j++){
				System.out.println(theBank.getBankCustomers().get(i).getAccountList().get(j).getAccountType()+" "+
						theBank.getBankCustomers().get(i).getAccountList().get(j).getAccountNumber()+" "+
						theBank.getBankCustomers().get(i).getAccountList().get(j).getBalance());
			}
		}
	}*/


	
	public void exportData() throws IOException {
		printBanner("EXPORT DATA");
		
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the path to export a file >>> ");
		String fileName = userInput.readLine();
		File f = new File(fileName);
		if (!f.exists()) {
			f.createNewFile();
		}

		try (PrintWriter writer = new PrintWriter(f)) {
			for (int i = 0; i < theBank.getBankCustomers().size(); i++) {
				writer.println("C|" + theBank.getBankCustomers().get(i).getName() + "|"
						+ theBank.getBankCustomers().get(i).getAddress() + "|"
						+ theBank.getBankCustomers().get(i).getPhoneNumber());
				for (int j = 0; j < theBank.getBankCustomers().get(i).getAccountList().size(); j++) {
					writer.println("A|"
							+ theBank.getBankCustomers().get(i).getAccountList().get(j).getAccountType().substring(0, 1)
							+ "|" + theBank.getBankCustomers().get(i).getAccountList().get(j).getAccountNumber() + "|"
							+ theBank.getBankCustomers().get(i).getAccountList().get(j).getBalance()
									.getTotalAmountInCents());
				}
			}
		}
		
		
		int accountCount = 0;
		for(int i=0; i<theBank.getBankCustomers().size(); i++){
			accountCount= accountCount+theBank.getBankCustomers().get(i).getAccountList().size();
		}
		System.out.println("\n*** "+theBank.getBankCustomers().size()+" Customers and "+accountCount+" accounts were exported to "+fileName);
	}	
		
	
	
	
	private String getChoiceFromMainMenu() {
		printBanner("MAIN MENU");
		
		System.out.println("Please choose from the following options:\n");
		
		System.out.println("1) Add BankCustomer");
		System.out.println("2) Add Account");
		System.out.println("3) Deposit");
		System.out.println("4) Withdrawal");
		System.out.println("5) Transfer");
		System.out.println("6) Export");
		System.out.println("7) Import");
		
		System.out.println("8) Exit");
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
		int choice=chooseCustomer();		
		int accountChoice = Integer.parseInt(getUserInput("\nChoose an account type:\n\n1)Checking\n2)Savings\n\nEnter number"));
		String accountNumber = getUserInput("\nEnter account number");   
		if(accountChoice==1){
			CheckingAccount newCheckingAccount = new CheckingAccount(custChoice(choice), accountNumber, new DollarAmount(5000)); //new accounts get a free $50!
			custChoice(choice).addBankAccount(newCheckingAccount);
			System.out.println("\n*** Checking account "+accountNumber+" has been created for "+custChoice(choice).getName()+" ***");

		}
		else{
			SavingsAccount newSavingsAccount = new SavingsAccount(custChoice(choice), accountNumber, new DollarAmount(5000));
			custChoice(choice).addBankAccount(newSavingsAccount);
			System.out.println("\n*** SavingsAccount "+accountNumber+" has been created for "+custChoice(choice).getName()+" ***");

		}
	}

	private BankCustomer custChoice(int choice) {
		return theBank.getBankCustomers().get(choice-1);
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
			custChoice(choice).getAccountList().get(accountChoice-1).deposit(amountToDeposit);
			
			System.out.println("***"+amountToDeposit.toString()+" deposited into "+
					custChoice(choice).getAccountList().get(accountChoice-1).getAccountType()+" "+
					custChoice(choice).getAccountList().get(accountChoice-1).getAccountNumber()+" ***");
			System.out.println("*** New balance is "+custChoice(choice).getAccountBalance(custChoice(choice).getAccountList().get(accountChoice-1))+" ***");		
			control = false;
		}
		catch(NumberFormatException e){
			System.out.println("Invalid Entry, Please try again");
		}
		}
	}

	private void withdraw() {
		printBanner("WITHDRAW");
		int choice = chooseCustomer();
		int accountChoice = chooseCustomerAccount(choice, "Choose an account");
		boolean control = true;
		while (control) {
			try {
				DollarAmount amountToWithdraw = new DollarAmount(
						Long.parseLong(getUserInput("Enter withdrawal amount")));
				if (amountToWithdraw.isNegative() || amountToWithdraw.equals(new DollarAmount(0))) {
					throw new NumberFormatException();
				}
				custChoice(choice).getAccountList().get(accountChoice - 1).withdraw(amountToWithdraw);
				System.out.println("***" + amountToWithdraw.toString() + " withdrawn from "
						+ custChoice(choice).getAccountList().get(accountChoice - 1).getAccountType() + " "
						+ custChoice(choice).getAccountList().get(accountChoice - 1).getAccountNumber() + " ***");
				System.out.println("*** New balance is " + custChoice(choice)
						.getAccountBalance(custChoice(choice).getAccountList().get(accountChoice - 1)) + " ***");
				control = false;
			} catch (NumberFormatException e) {
				System.out.println("Invalid Entry, Please try again");
			}
		}
	}
	
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
			custChoice(choice).getAccountList().get(sourceChoice-1).transfer(custChoice(choice).getAccountList().get(destinationChoice-1), amountToTransfer);
			System.out.println("***"+amountToTransfer.toString()+" withdrawn from "+
				custChoice(choice).getAccountList().get(sourceChoice-1).getAccountType()+" "+
				custChoice(choice).getAccountList().get(sourceChoice-1).getAccountNumber()+" ***");
			System.out.println("*** New balance is "+custChoice(choice).getAccountBalance(custChoice(choice).getAccountList().get(sourceChoice-1))+" ***");	
			System.out.println("***"+amountToTransfer.toString()+" deposited into "+
				custChoice(choice).getAccountList().get(destinationChoice-1).getAccountType()+" "+
				custChoice(choice).getAccountList().get(destinationChoice-1).getAccountNumber()+" ***");
			System.out.println("*** New balance is "+custChoice(choice).getAccountBalance(custChoice(choice).getAccountList().get(destinationChoice-1))+" ***");		
			control=false;
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
		for(int i=0; i<custChoice(choice).getAccountList().size(); i++){
			System.out.println(i+1+") "+custChoice(choice).getAccountList().get(i).getAccountType()+"		"+custChoice(choice).getAccountList().get(i).getAccountNumber());
		}
		return Integer.parseInt(getUserInput("\nEnter number"));  //handle case where user chooses invalid account
		
	}

	
	public void exit() {
		System.out.println("\n***Exiting...Have a nice day.***");
		System.exit(0);
	}
}
