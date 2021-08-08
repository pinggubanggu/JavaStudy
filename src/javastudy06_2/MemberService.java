package src.javastudy06_2;

public interface MemberService {
	
	// 프로그램 실행하기
	void init();
	
	// 책 입력하기
	void input();
	
	// 책 조회하기
	void search();
	
	// 책 빌리기
	void borrow();
	
	// 책 반납하기
	void returnBook();
	
	// 종료하기
	void quit();
}
