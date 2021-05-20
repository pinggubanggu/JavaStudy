package referenceType;

public class Variable_And_Method_Call {

		int iv;			// 인스턴스 변수
		static int cv;	// 클래스 변수
		
		void instanceMethod() {			// 인스턴스 메서드
			System.out.println(iv);
			System.out.println(cv);		// 클래스변수 사용가능
		}
		
		static void staticMethod() {	// static 메서드
			System.out.println(iv);		// 에러!! 인스턴스 변수를 사용할 수 없다.
			System.out.println(cv);
		}

		
	

}
