package src.referenceType;

public class Member {

	// 멤버변수
	String memberNo;
	String name;
	int age;
	String tel;
	
	// getter setter 메서드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	
	public String toString() {
		return
		"아이디 : " + getMemberNo() + "\n" +
		"이름 : " + getName() + "\n" +
		"나이 : " + getAge() + "\n" +
		"연락처 : " + getTel() + "\n";
	}
	
	
}
