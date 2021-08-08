package src.javastudy06_2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class MemberServiceImpl implements MemberService {

	List<Book> list = new ArrayList<Book>();
	Scanner scanner = new Scanner(System.in);
	boolean run = true;
	int n = 0; 	// autoIncrease 적용
	
	
	@Override
	public void init() {
		while(run) {
			menu();
		}
	}

	public void menu() {
		System.out.println("*************");
		System.out.println("1. 책 입력하기");
		System.out.println("2. 책 조회하기");
		System.out.println("3. 책 빌리기");
		System.out.println("4. 책 반납하기");
		System.out.println("5. 종료하기");
		System.out.println("*************");
		
		String input = scanner.next();
		
		switch(input) {
			case "1" : input(); break;
			case "2" : search(); break;
			case "3" : borrow(); break;
			case "4" : returnBook(); break;
			case "5" : quit(); break;
			default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
		}
		
	}
	@Override
	public void input() {
		Book book = new Book();
		int i = 0;	//  state 설정 변수
		
		System.out.println("*************");
		System.out.println("책 제목 : ");
		
		book.setTitle(scanner.next());
		
		System.out.println("저자  : ");
		book.setAuthor(scanner.next());
		
		// 등록번호 AutoIncrease적용
		book.setNumber(n++);
		
		book.setState(i);
		
		list.add(book);
		
		System.out.println("책 등록이 완료되었습니다.\n");
		
	}

	@Override
	public void search() {
		System.out.println("*************");
		for ( Object i : list ) {
			System.out.println(i);
		}
		
	}

	@Override
	public void borrow() {
		System.out.println("*************");
		for ( Object i : list ) {
			System.out.println(i);
		}
		
		System.out.println("빌릴 책의 번호를 입력하세요. 숫자만 입력할것.");
		
		int i = scanner.nextInt();
		
		// 책 빌릴 때 현재 빌려간 책인지 아닌지 여부 판단
		// 1. 책 대여가 불가능한 상태
		if(list.get(i).getState() == 1) {
			System.out.println("이미 대출이 되어 책 대여가 불가능합니다.");
		} 
		// 2. 책 대여가 가능한 상태
			else {
					// 빌렸으니 state를 1로 변경하여 대출 불가 상태 만들기
					list.get(i).setState(1);
					
					// 책 빌릴때 현재 날짜 저장
					Calendar today = Calendar.getInstance();
					
//					String input ="";
//					input = today.get(Calendar.YEAR) + "년";
//					input = today.get(Calendar.MONTH) + "월";
//					input = today.get(Calendar.DATE) + "일";
					
//					list.get(i).setDate(input);
					
					// 현재 빌려간 날짜 1/1000초 단위로 저장
					list.get(i).setDate(today.getTimeInMillis());
					
					// 반납 날짜 구하기 위해 현재 날짜에서 3일 더하기
					today.add(Calendar.DATE, 3);
					
					// 3일 더한 반납날짜 1/1000초 단위로 저장
					list.get(i).setdDate(today.getTimeInMillis());
					
					System.out.println(" 반납은 " + toString(today) + " 까지 입니다.");
					System.out.println(" 책 대여가 완료되었습니다. ");
				
				}
	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) +"년 " + (date.get(Calendar.MONTH)+1) +"월 " 
				+ date.get(Calendar.DATE) + "일" ;
	}

	@Override
	public void returnBook() {
		System.out.println("*************");
		for ( Object i : list ) {
			System.out.println(i);
		}
		System.out.println("반납할 책의 번호를 입력하세요.");
		
		int i = scanner.nextInt();
		
		System.out.println("반납날짜(당일)를 입력하세요.");
		System.out.println("연도(네자리) : ");
		int y = scanner.nextInt();
		
		System.out.println("월(월 입력시 맨 앞에 0을 기입 할 수 없습니다.) : ");
		int m = scanner.nextInt()-1;	// month의 경우 0부터 시작하기 때문에
		
		System.out.println("일(일 입력시 맨 앞에 0을 기입 할 수 없습니다.): " );
		int d = scanner.nextInt();
		
		// 입력 받은 날짜를 셋팅
		Calendar date = Calendar.getInstance();
		date.clear();
		date.set(y,m,d);
		
		// 반납날짜보다 기입한 오늘 날짜가 더 크면 안내 메세지 출력
		if (list.get(i).getdDate() < date.getTimeInMillis()) {
			
			System.out.println("반납기한이 지났습니다.");
			
		}
		
		// state 대출 가능 상태로 바꾸기
		list.get(i).setState(0);
		
		System.out.println("책 반납이 완료되었습니다.");
		
	}

	@Override
	public void quit() {
		run = false;
		System.out.println("프로그램을 종료합니다.");
	}

	
}
