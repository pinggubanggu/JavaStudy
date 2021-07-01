package genericsJoin;

public class Member {
    String memberId;
    String password;

    Member() {}

    Member(String id, String password) {
        this.memberId = id;
        this.password = password;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
