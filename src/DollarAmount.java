
public class DollarAmount {
	
	private static long totalAmountInCents;
	
	public DollarAmount(long totalAmountInCents) {
		this.totalAmountInCents = totalAmountInCents;
	}
	public long getCents() {
		return totalAmountInCents;
	}
	public long getDollars() {
		return totalAmountInCents/100;
	}
	
	public boolean isEqualTo(long amountToCompare) {
	if(totalAmountInCents == amountToCompare) 
		return true;
	
	else
		return false; 
	}
	public boolean isLessThan(long amountToCompare) {
		if(totalAmountInCents < amountToCompare) 
			return true;
		
		else
			return false; 
	}
		public boolean isGreaterThan(long amountToCompare) {
			if(totalAmountInCents > amountToCompare) 
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
		public void plus(long amountToAdd) {
			 totalAmountInCents = totalAmountInCents + amountToAdd;
		}
		public void minus(long amountToSubtract) {
			 totalAmountInCents = totalAmountInCents - amountToSubtract;
}
}
