package src.javastudy06;

/**
 * 게시판 기본 설계도
 * */

public interface MemberService {
	
	// execute method
	void init();
	
	// menu 출력하여 화면에 보여주어서 기능 선택
	void menu();
	
	// 회원가입
	// 숫자 id 중복확인
	// 예외처리 : 숫자 id에 문자를 기입했을 시 
	void insert();
	
	// 게시글 작성
	// 아이디 확인 후 그 게시판에 작성한 글 저장
	void write();
	
	// 게시글 삭제
	// 아이디 비밀번호 확인 후 게시글 삭제
	// 멤버 아이디별 게시판에 저장되어 있는 게시글 제목 보여주고 삭제 할 글 고르기?
	void delete();

	// 멤버 아이디별 게시글 보여주기
	// 예외처리 : 없는 사용자일때 
	void findBy();
	
	// 프로그램 종료
	void quit();
}
