
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
		if(!newAmount.equals(equalAmount)){
			allTestsPassed = false;
			System.out.println("FAIL.  newAmount should eaual equalAmount");
		}
		DollarAmount equalAmount2 = new DollarAmount(123); 		//test isEqualTo() method
		if(!newAmount.equals(equalAmount2)){
			allTestsPassed = false;
			System.out.println("FAIL.  newAmount should eaual equalAmount2");
		}
		
		DollarAmount greaterAmount = new DollarAmount(789);		//create DollarAmount objects to compare
		DollarAmount lesserAmount = new DollarAmount(103);		
		
		//test isEqualTo, isLessThan, and isGreaterThan methods
		if(newAmount.equals(greaterAmount) || newAmount.equals(lesserAmount)){
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
		if(!newAmount.plus(addedAmount).equals(addedTotalAmount)){
			allTestsPassed = false;
			System.out.println("FAIL.  DollarAmount objects should be equal but arent.");
		}
		
		DollarAmount subAmount = new DollarAmount(67);		//test minus() method
		DollarAmount subTotalAmount = new DollarAmount(56);
		if(!newAmount.minus(subAmount).equals(subTotalAmount)){
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
		
		DollarAmount testAmount = new DollarAmount(950);
		DollarAmount testAmount2 = new DollarAmount(540);
		if(testAmount.compareTo(testAmount2)!=1){
			allTestsPassed = false;
			System.out.println("FAIL.  Should return 1, but instead returns "+testAmount.compareTo(testAmount2));
		}
		if(testAmount2.compareTo(testAmount)!=-1){
			allTestsPassed = false;
			System.out.println("FAIL.  Should return -1, but instead returns "+testAmount2.compareTo(testAmount));
		}
		
		DollarAmount equalTestAmount = new DollarAmount(950);
		if(testAmount.compareTo(equalTestAmount)!=0){
			allTestsPassed = false;
			System.out.println("FAIL.  Should return 0, but instead returns "+testAmount.compareTo(equalTestAmount));
		}
		
		
		if(allTestsPassed) {
			System.out.println("All tests PASSED!");
		}
		DollarAmount oneCent = new DollarAmount(1);
		DollarAmount tenCent = new DollarAmount(10);

		System.out.println(newAmount);
		System.out.println(oneCent);
		System.out.println(oneCent.getCents());
		
		System.out.println(tenCent);
		System.out.println(tenCent.getCents());
		
		System.out.println(newAmount.hashCode());
		System.out.println(equalAmount2.hashCode());

	}

}
