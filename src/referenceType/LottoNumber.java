package referencetype;

public class LottoNumber {

	public static void main(String[] args) {
		
		int[] ball = new int[45];		// 45개의 정수값을 저장하기 위한 배열 생성.
		
		// 배열의 각 요소에 1~45의 값을 저장한다.
		for(int i=0; i<ball.length; i++) {
			ball[i] = i+1;	// ball[0]에 1이 저장된다.
		}
		
		int tmp = 0;	// 두 값을 바꾸는데 사용할 임시변수
		int j = 0;		// 임의의 값을 얻어서 저장할 변수
		
		for(int i=0; i<6; i++) {
			j = (int)(Math.random()*45); 	// (index)0~44 범위의 임의의 값을 얻는다.
			
			tmp = ball[i];					// ball[i]와 ball[j]의 값을 서로 바꾼다.
			ball[i] = ball[j];
			ball[j] = tmp;
		}
		
		// 배열 ball의 앞에서 부터 6개의 요소를 출력한다.
		for(int i=0; i<6; i++) {
			System.out.printf("ball[%d]=%d%n", i, ball[i] );
		}
		
		// printf()는 '지시자(specifier)'를 통해 변수의 값을 여러가지 형식으로 변환하여 출력하는 기능을 가지고 있다.
		// '지시자'는 값을 어떻게 출력할 것인지를 지시해주는 역할을 한다.
		
		

		

	}

}
