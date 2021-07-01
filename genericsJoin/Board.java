package genericsJoin;

public class Board {
    int boardNo;
    String title;
    String contents;
    Member member;

    Board() { }

    Board(Member member) {
        this.member = member;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
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
        return "["+ boardNo +". 제목:" + title + ", 내용:" + contents + ']';
    }

}
