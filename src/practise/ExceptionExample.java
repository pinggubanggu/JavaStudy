package practise;

import java.util.InputMismatchException;

public class ExceptionExample {
	public static void main(String[] args) {
		System.out.println("예외처리 시작\n");
		
		try {
//			 1. 산술계산 예외 : 0으로 나눌 수 없다.
//			System.out.println(5/0);	
			
			// 2. 형변환 예외 : 객체의 형을 변환할 때 객체 타입 변환이 적절하지 않을 때 발생함.
			// 참조변수의 형변환은 상위 클래스와 하위 클래스 간에 발생하고 구현 클래스와 인터페이스 간에도 발생한다.
			// 이러한 관계가 아니면 클래스는 다른 클래스로 타입 변환할 수 없다.
			
//			SmartTv s = new SmartTv();
//			changeSmartTv(s);
//			
//			MobileTv m = new MobileTv();
//			changeSmartTv(m);
			
			// 3. 숫자로타입변환시 예외
//			String correctData = "100";
//			String wrongData = "a100";
//			
//			int correctValue = Integer.parseInt(correctData);
//			int wrongValue = Integer.parseInt(wrongData);
			
			// 4. 배열에서 인덱스 범위 초과해서 사용 할 경우 예외발생
//			System.out.println(args[0]);
			
			// 5. 객체 참조가 없는 상태, 
			// 즉 null 값을 갖는 참조 변수로 객체 접근 연산자인 도트(.)를 사용했을 때 발생
			
//			String data = null;
//			System.out.println(data.toString());
			
			// 6. 배열 유형이 허락하지 않는 객체를 객체를 배열에 저장하려는 경우 예외발생
//			Object x[] = new String[3];
//		    x[0] = new Integer(0);
		    
		    // 7. InputMismatchException -> Scanner 사용시 이 예외 많이 발생
//		    boolean run = true;
//			
//			while(run) {
//				Scanner scanner = new Scanner(System.in);
//				System.out.println("입력  : ");
//			
//				try {
//				
//					int i;
//				
//					i = scanner.nextInt();
//				
//					System.out.println(i);
//					
//					run = false;
//				
//				} catch (Exception e) {
//					System.out.println("숫자를 입력해주세요. \n");
//					e.printStackTrace();
//				}
//			}	//while문

		} catch(ArithmeticException a) {
			System.out.println("ArithmeticException이 발생하였습니다.");
		} catch(ClassCastException b) {
			System.out.println("ClassCastException이 발생하였습니다.");
		} catch(NumberFormatException c) {
			System.out.println("NumberFormatException이 발생하였습니다.");
		} catch(ArrayIndexOutOfBoundsException d) {
			System.out.println("ArrayIndexOutOfBoundsException이 발생하였습니다.");
		} catch(NullPointerException e) {
			System.out.println("NullPointerException이 발생하였습니다.");
		} catch(ArrayStoreException e) {
			System.out.println("ArrayStoreException이 발생하였습니다.");
		} catch(InputMismatchException e) {
			System.out.println("InputMismatchException이 발생하였습니다.");
		} catch(Exception e) {
			System.out.println("Exception이 발생하였습니다.");
		}
		
	}
	private static void changeSmartTv(Tv tv) {
		 SmartTv s = (SmartTv)tv;
	} 

}


