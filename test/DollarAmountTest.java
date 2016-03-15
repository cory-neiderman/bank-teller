
import org.junit.Assert;
import org.junit.Test;


public class DollarAmountTest {
	
	@Test
	public void getCents_returns_the_number_of_cents(){
		DollarAmount anAmount = new DollarAmount(1234);
		long numberOfCents = anAmount.getCents();
		Assert.assertEquals(34, numberOfCents);
		
		DollarAmount anotherAmount = new DollarAmount(105, 65);
		long anotherNumberOfCents = anotherAmount.getCents();
		Assert.assertEquals(65, anotherNumberOfCents);
	}
	
	@Test
	public void getDollars_returns_the_number_of_whole_dollars(){
		DollarAmount anAmount = new DollarAmount(1234);
		long numberOfDollars=anAmount.getDollars();
		Assert.assertEquals(12, numberOfDollars);
		
		DollarAmount anotherAmount = new DollarAmount(105, 65);
		long anotherNumberOfDollars = anotherAmount.getDollars();
		Assert.assertEquals(105, anotherNumberOfDollars);
	}

	@Test
	public void equals_returns_true_for_equal_amounts(){
		DollarAmount firstAmount = new DollarAmount(1234);
		DollarAmount secondAmount = new DollarAmount(1234);
		Assert.assertTrue(firstAmount.equals(secondAmount));
	}
	
	@Test
	public void equals_returns_false_for_unequal_amounts(){
		DollarAmount firstAmount = new DollarAmount(1234);
		DollarAmount secondAmount = new DollarAmount(1233);
		Assert.assertFalse(firstAmount.equals(secondAmount));
	}
	
	@Test
	public void isLessThan_returns_true_for_lesser_amuonts(){
		DollarAmount firstAmount = new DollarAmount(1232);
		DollarAmount secondAmount = new DollarAmount(1233);
		Assert.assertTrue(firstAmount.isLessThan(secondAmount));
	}
	
	@Test
	public void isLessThan_returns_false_for_greater_amuonts(){
		DollarAmount firstAmount = new DollarAmount(1232);
		DollarAmount secondAmount = new DollarAmount(1233);
		Assert.assertFalse(secondAmount.isLessThan(firstAmount));
	}
	
	@Test
	public void isGreaterThan_returns_true_for_greater_amuonts(){
		DollarAmount firstAmount = new DollarAmount(1234);
		DollarAmount secondAmount = new DollarAmount(1233);
		Assert.assertTrue(firstAmount.isGreaterThan(secondAmount));
	}
	
	@Test
	public void isGreaterThan_returns_false_for_lesser_amuonts(){
		DollarAmount firstAmount = new DollarAmount(1234);
		DollarAmount secondAmount = new DollarAmount(1233);
		Assert.assertFalse(secondAmount.isGreaterThan(firstAmount));
	}
	
	@Test
	public void isNegative_returns_true_for_negative_balance(){
		DollarAmount negAmount = new DollarAmount(-1234);
		Assert.assertTrue(negAmount.isNegative());
	}
	
	@Test
	public void isNegative_returns_false_for_nonnegative_balance(){
		DollarAmount positiveAmount = new DollarAmount(1234);
		Assert.assertFalse(positiveAmount.isNegative());
		DollarAmount zeroAmount = new DollarAmount(0);
		Assert.assertFalse(zeroAmount.isNegative());
	}
	
	@Test
	public void plus_returns_true_amount_if_equal_to_added_amounts(){
		DollarAmount firstAmount = new DollarAmount(1234);
		DollarAmount secondAmount = new DollarAmount(1233);
		DollarAmount thirdAmount = new DollarAmount(2467);

		Assert.assertTrue(firstAmount.plus(secondAmount).equals(thirdAmount));

		
	}
	@Test
	public void minus_returns_true_amount_if_equal_to_added_amounts(){
		DollarAmount firstAmount = new DollarAmount(1234);
		DollarAmount secondAmount = new DollarAmount(1233);
		DollarAmount thirdAmount = new DollarAmount(1);
		Assert.assertTrue(firstAmount.minus(secondAmount).equals(thirdAmount));
	}
	
	@Test 
	public void compareTo_returns_0_for_equal_amounts(){
		DollarAmount firstAmount = new DollarAmount(1234);
		DollarAmount secondAmount = new DollarAmount(1234);
		Assert.assertEquals(0, firstAmount.compareTo(secondAmount));
	}
	
	@Test
	public void compareTo_returns_1_for_greater_amounts(){
		DollarAmount firstAmount = new DollarAmount(1234);
		DollarAmount secondAmount = new DollarAmount(1233);
		Assert.assertEquals(1, firstAmount.compareTo(secondAmount));
	}
	
	@Test
	public void compareTo_returns_negative_1_for_lesser_amounts(){
		DollarAmount firstAmount = new DollarAmount(1234);
		DollarAmount secondAmount = new DollarAmount(1233);
		Assert.assertEquals(-1, secondAmount.compareTo(firstAmount));
	}
	
	@Test
	public void toString_returns_DollarAmount_as_string(){
		DollarAmount firstAmount = new DollarAmount(1234);
		Assert.assertEquals("$12.34", firstAmount.toString());
		DollarAmount otherAmount = new DollarAmount(1201);
		Assert.assertEquals("$12.01", otherAmount.toString());

	}
	
	@Test
	public void hashCode_returns_proper_hash_code(){
		DollarAmount firstAmount = new DollarAmount(1234);
		int firstAmountInt = 1234;
		Assert.assertEquals(firstAmountInt, firstAmount.hashCode());
		
		DollarAmount secondAmount = new DollarAmount(50000);
		int secondAmountInt = 50000;
		Assert.assertEquals(secondAmountInt, secondAmount.hashCode());
	}
	
}