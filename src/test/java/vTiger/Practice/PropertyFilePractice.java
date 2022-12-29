package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		
		//Step1: Load the file location into file input stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	    //step2: create object of Properties from java.util package
		Properties pObj=new Properties();
		
		//load FIleInputStraem into Properties
		pObj.load(fis);
		
		//read the value using key
		String value=pObj.getProperty("url");
		System.out.println(value);
	}

}
