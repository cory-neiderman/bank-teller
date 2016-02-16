

public class DollarAmount implements Comparable<DollarAmount>{
	
	private long totalAmountInCents;
	
	public DollarAmount(long totalAmountInCents) {
		this.totalAmountInCents = totalAmountInCents;
	}
	
	public DollarAmount(long dollars, int cents){   //2nd constructor so we can create a DollarAmount with dollars and cents like so DollarAmount(100, 42)
		totalAmountInCents=dollars*100+cents;
	}
	
	public int getCents() {
		int cents=(int)(totalAmountInCents%100);	//need parantheses around totalAmountInCents%100 otherwise it wont work for long numbers
		return cents;								//(int)totalAmountInCents%100 wont work.  It must do the modulo operation on the long first
		
	}
	public long getDollars() {
		return totalAmountInCents/100;
	}
	
	
	/*public boolean isEqualTo(DollarAmount amount) {			//this method is replaced by the equals method below
		if(totalAmountInCents == amount.totalAmountInCents) 
			return true;
	
		else
			return false; 
	}*/
	
	public boolean equals(Object obj){
		if(totalAmountInCents == ((DollarAmount)obj).totalAmountInCents)
			return true;
		else
			return false;
		
	}
	public boolean isLessThan(DollarAmount amount) {
		if(totalAmountInCents < amount.totalAmountInCents) 
			return true;
		
		else
			return false; 
	}
	public boolean isGreaterThan(DollarAmount amount) {
		if(totalAmountInCents > amount.totalAmountInCents) 
			return true;
		else
			return false; 
	}
	public boolean isNegative() {
		if(totalAmountInCents < 0) 
			return true;
		else
			return false; 
	}
	public DollarAmount plus(DollarAmount amountToAdd) {
		DollarAmount sum = new DollarAmount(totalAmountInCents+amountToAdd.totalAmountInCents);
		return sum;
	}
	public DollarAmount minus(DollarAmount amountToSubtract) {
		 DollarAmount subtract = new DollarAmount(totalAmountInCents - amountToSubtract.totalAmountInCents);
		 return subtract;
	}
	
	public int compareTo(DollarAmount otherDollarAmount){
		if(this.totalAmountInCents == otherDollarAmount.totalAmountInCents)
			return 0;
		else if(totalAmountInCents >= otherDollarAmount.totalAmountInCents)
			return 1;
		else
			return -1;
	}
	

	@Override
	public String toString() {
		//return "$"+Long.toString(this.getDollars())+"."+Integer.toString(this.getCents());
		if(this.getCents()<10){
			return "$"+this.getDollars()+".0"+this.getCents();
		}
		else
			return "$"+this.getDollars()+"."+this.getCents();

		//return "DollarAmount [totalAmountInCents=" + totalAmountInCents + "]";
	}
	
	public int hashCode(){
		return (int)this.totalAmountInCents;
		//return (int) (this.totalAmountInCents^(this.totalAmountInCents>>>32));  //stack overflow solution.  returns same as above

	}
	
	
}
