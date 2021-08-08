package shoppingBasket;

 class Member {
    String id;
    String pw;

    Member() { }    // Member 기본 인스턴스 생성 할 수 있으니 기본 생성자 만들어놓기 -> 매개변수있는 생성자 있으면 컴파일러가 기본 생성자를 자동적으로 만들어주지 않는다.

    Member(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

}
