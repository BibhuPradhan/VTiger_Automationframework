package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	@Test
	public void assertionsPractice (){
		
		SoftAssert sa = new  SoftAssert();
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		sa.assertEquals(false, true);
		System.out.println("step 4");
		System.out.println("step 5");
		System.out.println("step 6");
		sa.assertAll();

	}

	

}
