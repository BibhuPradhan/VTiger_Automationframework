package vTiger.Practice;

import java.io.IOException;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {

		PropertyFileUtility pUtil=new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("browser");
		System.out.println(value);
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String data = eUtil.readDataFromExcel("organizations", 1, 2);
		System.out.println(data);
		System.out.println(eUtil.getRowCount("Organizations"));
		
		eUtil.writeDataIntoExcel("organizations", 1, 6, "chiku");
		System.out.println("data written");
	}

}
