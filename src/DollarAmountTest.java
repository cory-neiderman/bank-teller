
public class DollarAmountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean allTestsPassed=true;
		
		DollarAmount newAmount = new DollarAmount(123);			//create DollarAmount object
		if(newAmount.getCents()!=23){							//test getCents() method
			allTestsPassed = false;
			System.out.println("FAIL.  Cents should be 23 but instead is "+newAmount.getCents());
		}
		
		if(newAmount.getDollars()!=1){							//test getDollars() method
			allTestsPassed = false;
			System.out.println("FAIL.  Dollars should be 1 but instead is "+newAmount.getDollars());
		}
		
		DollarAmount equalAmount = new DollarAmount(1, 23);  //lets try the dollar and cent constructor
		if(!newAmount.isEqualTo(equalAmount)){
			allTestsPassed = false;
			System.out.println("FAIL.  newAmount should eaual equalAmount");
		}
		DollarAmount equalAmount2 = new DollarAmount(123); 		//test isEqualTo() method
		if(!newAmount.isEqualTo(equalAmount2)){
			allTestsPassed = false;
			System.out.println("FAIL.  newAmount should eaual equalAmount2");
		}
		
		DollarAmount greaterAmount = new DollarAmount(789);		//create DollarAmount objects to compare
		DollarAmount lesserAmount = new DollarAmount(103);		
		
		//test isEqualTo, isLessThan, and isGreaterThan methods
		if(newAmount.isEqualTo(greaterAmount) || newAmount.isEqualTo(lesserAmount)){
			allTestsPassed = false;
			System.out.println("FAIL.  newAmount should not eaual greaterAmount or lesserAmount");
		}
		if(!newAmount.isLessThan(greaterAmount)){
			allTestsPassed = false;
			System.out.println("FAIL.  newAmount should be less than greaterAmount");
		}
		if(newAmount.isLessThan(lesserAmount)){
			allTestsPassed = false;
			System.out.println("FAIL.  newAmount should be greater than lesserAmount");
		}
		
		if(newAmount.isGreaterThan(greaterAmount)){
			allTestsPassed = false;
			System.out.println("FAIL.  newAmount should be less than greaterAmount");
		}
		if(!newAmount.isGreaterThan(lesserAmount)){
			allTestsPassed = false;
			System.out.println("FAIL.  newAmount should be greater than lesserAmount");
		}
			
		//test isNegative method
		if(newAmount.isNegative() || greaterAmount.isNegative() || lesserAmount.isNegative()){
			allTestsPassed = false;
			System.out.println("FAIL.  all DollarAmount objects listed should be greater than 0");
		}
		
		DollarAmount addedAmount = new DollarAmount(378);		//test plus() method
		DollarAmount addedTotalAmount = new DollarAmount(501);
		if(!newAmount.plus(addedAmount).isEqualTo(addedTotalAmount)){
			allTestsPassed = false;
			System.out.println("FAIL.  DollarAmount objects should be equal but arent.");
		}
		
		DollarAmount subAmount = new DollarAmount(67);		//test minus() method
		DollarAmount subTotalAmount = new DollarAmount(56);
		if(!newAmount.minus(subAmount).isEqualTo(subTotalAmount)){
			allTestsPassed = false;
			System.out.println("FAIL.  DollarAmount objects should be equal but arent.");
		}
		
		//lets use a new DollarAmount object and the minus() method to create a negative DollarAmount object
		DollarAmount negativeMaker = new DollarAmount(150);			
		DollarAmount negativeAmount = newAmount.minus(negativeMaker);
		if(!negativeAmount.isNegative()){			//test to make sure isNegative returns true
			allTestsPassed = false;
			System.out.println("FAIL.  negativeAmount should be negative but is not.");
		}
		
		if(allTestsPassed) {
			System.out.println("All tests PASSED!");
		}

	}

}
