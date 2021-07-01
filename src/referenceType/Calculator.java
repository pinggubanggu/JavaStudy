package referencetype;

class Cal {
	int add(int a, int b) {
		return a + b; 
	}
	
	int subtract(int a, int b) {
		return a - b;
	}
	
	int multiply(int a, int b) {
		return a * b;
	}
	
	int divide (int a, int b) {
		return a/b;
	}
}
public class Calculator {

	public static void main(String[] args) {
		Cal c = new Cal();
		int result = c.add(3,5);
		System.out.println(result);
		
		int result2 = c.subtract(5,6);
		System.out.println(result2);
		
		int result3 = c.multiply(6,2);
		System.out.println(result3);
		
		int result4 = c.divide(10,4);
		System.out.println(result4);
	}

}
