package javastudy06_2;

public class Book{
	
	String title;	// 책 제목
	String author;	// 지은이 
	int number;	// 등록번호
	int state;	//  현재 빌려간 책인지 아닌지 여부 판단. state : 0 (빌리기 가능) , state : 1(빌려간 상태임)
	Long date;	// 책 빌려간 날짜
	Long dDate;  // 책 반납날짜
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	public Long getdDate() {
		return dDate;
	}
	public void setdDate(Long dDate) {
		this.dDate = dDate;
	}


	// int state의 숫자표현을 문자열 표현으로 바꾸는 배열
	final String[] CHECK_OUT_BOOK = {"대출가능", "대출 불가능"};
	
	public String toString() {
		return " [ " + number + ".책 제목 :\'" + title + "\' 지은이 :\'" + author + "\' 대출 여부 :\'" + CHECK_OUT_BOOK[state] +"\']";
	}
	
}
