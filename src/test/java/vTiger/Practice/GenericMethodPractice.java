package vTiger.Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
	
		int sum=add(345,5);
		System.out.println(sum);
	}
	//generic method
	public static int add(int a,int b) {
		int c=a+b;
		return c;
	}

}
