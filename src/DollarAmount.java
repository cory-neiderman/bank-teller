
public class DollarAmount implements Comparable<DollarAmount>{
	
	private long totalAmountInCents;
	
	public DollarAmount(long totalAmountInCents) {
		this.totalAmountInCents = totalAmountInCents;
	}
	public DollarAmount(long dollars, int cents){
		totalAmountInCents=dollars*100+cents;
	}
	public int getCents() {
		int cents=(int)totalAmountInCents%100;
		return cents;
		
	}
	public long getDollars() {
		return totalAmountInCents/100;
	}
	
	
	public boolean isEqualTo(DollarAmount amount) {
		if(totalAmountInCents == amount.totalAmountInCents) 
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
}
