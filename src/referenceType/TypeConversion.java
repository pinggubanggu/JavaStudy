package referencetype;

public class TypeConversion {

	public static void main(String[] args) {
		String str = "3";
		
		System.out.println(str.charAt(0) -'0');			// 숫자 3
		System.out.println('3' - '0' + 1); 				// 숫자 4
		System.out.println(Integer.parseInt("3") + 1);	// 숫자 4
		System.out.println("3" + 1); 					// 문자열 31
		System.out.println((char)(3 + '0')); 			// 문자 3 
		
		// 연산이나 대입시 타입이 일치하지 않으면,
		// 둘 중에 보다 더 큰 타입으로 두 타입을 일치시킨다.
		// int + char -> int > char -> int + int
		

	}

}
