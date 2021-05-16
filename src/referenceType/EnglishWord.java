package referenceType;

import java.util.Scanner;

public class EnglishWord {

	public static void main(String[] args) {
		
		// 영단어 만들기
		String[][] words = {
				{"chair","의자"},
				{"computer","컴퓨터"},
				{"integer","정수"}
				
		};
		
		// 사용자가 쓴 입력값을 스캐너로 받기
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<words.length; i++) {
			System.out.printf("Q%d.%s의 뜻은?", i+1, words[i][0]);
			
			String tmp = scanner.nextLine();
			
			if(tmp.equals(words[i][1])) {
				System.out.printf("정답입니다.%n%n");
			} else {
				System.out.printf("정답이 아닙니다. 정답은 %s입니다.%n", words[i][1]);
			}
		} // for

	} // main

}
