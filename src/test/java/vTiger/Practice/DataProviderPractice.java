package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider="getData")
	public void dataProviderPractice(String name,String model, int price, int qty) {
		
		System.out.println("test run => "+name+" "+model+" "+price+" "+qty);
		
	}
	@DataProvider(name="phoneData")
	public Object[][] getData(){
		
		Object[][] data=new Object[3][4];
		
		data[0][0] = "samsung";
		data[0][1] = "A40";
		data[0][3] = "10000";
		data[0][4] = "12";
		
		data[1][0] = "Iphone";
		data[1][1] = "S13";
		data[1][3] = "30000";
		data[1][4] = "15";
		
		data[2][0] = "nokia";
		data[2][1] = "1100";
		data[2][3] = "5000";
		data[2][4] = "10";
		
		data[3][0] = "oppo";
		data[3][1] = "k20";
		data[3][3] = "20000";
		data[3][4] = "7";
		
		return data;
				
	}
}
