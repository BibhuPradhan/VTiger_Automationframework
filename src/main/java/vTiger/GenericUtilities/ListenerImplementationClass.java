package vTiger.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
  * This class provides implementation to the IListener interface of TestNG
  * @author Bibhu Prasad
  *
  */
public class ListenerImplementationClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----> test execution started");
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----> test execution is successful");     
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----> test execution is failed");     
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----> test execution is skipped");     
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----> test execution is successful");     
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
		System.out.println("Execution started");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		System.out.println("Execution finished");
	}

}
