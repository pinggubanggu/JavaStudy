package javastudy06;

public class Board {

	int boardId;
	String title;
	String contents;
	Member member;
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public String toString() {
		return  "[ 게시글 번호: " + boardId + 
				",  제목: " + title + 
				",  내용: " + contents + "]";
	}
	
}
