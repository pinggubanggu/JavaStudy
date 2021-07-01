package javastudy06;

import java.util.Scanner;

public class StringException {

	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("입력  : ");
		
			try {
			
				int i;
			
				i = scanner.nextInt();
			
				System.out.println(i);
				
				run = false;
			
			} catch (Exception e) {
				System.out.println("숫자를 입력해주세요. \n");
				e.printStackTrace();
			}
		}	//while문
	}

}
