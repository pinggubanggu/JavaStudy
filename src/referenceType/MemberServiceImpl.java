package referencetype;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberServiceImpl implements MemberService {

	private boolean run = true;
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Member> members = new ArrayList<>();
	
	
	@Override
	public void init() {
		while(run) {
			menu();
		}
		
	}
	
	@Override
	public void menu() {
		
		System.out.println("****메뉴****");
		System.out.println(" 1. 회원등록");
		System.out.println(" 2. 회원찾기");
		System.out.println(" 3. 회원목록");
		System.out.println(" 4. 회원삭제");
		System.out.println(" 5. 회원수정");
		System.out.println("***********");
		
		String input = scanner.next();
		switch(input) {
		case "1" : 
			insert();
			break;
		case "2" : 
			find();
			break;
		case "3" :
			findAll();
			break;
		case "4" :
			delete();
			break;
		case "5" :
			update();
			break;
		default : 
			System.out.println("잘못 눌렀습니다. 다시 입력해주세요.");
		}
	}
	

	@Override
	public void insert() {
		
		// 저장할 Member 인스턴스 생성
		Member member = new Member();
		boolean run2 = true;
		String id = "";
		
		while(run2) {
			System.out.println("1.회원등록");
			System.out.println("아이디 : ");
		
		// 아이디 중복확인
			id = scanner.next();
			for(int i=0; i<members.size(); i++) {
//				System.out.println(members.get(i).getMemberNo());
//				System.out.println(id.equals(members.get(i).getMemberNo()));
				if(id.equals(members.get(i).getMemberNo())) {
					System.out.println("이미 있는 아이디입니다.");
					break;
					
				// else if 조건문 목적 : 이 조건문의 실행을 한번만 하기 위해
			    // 전체 데이터베이스를 확인했는데도 중복된게 없으면 while문을 빠져나가는 조건문
				} else if(i == members.size()-1) {
					run2 = false;
				}
//				else {
//					run2 = false;
//				}

				
			}	// for
			
		}	// while
		
		member.setMemberNo(id);
//		member.setMemberNo(scanner.next());
		
		
		System.out.println("이름 : ");
		member.setName(scanner.next());
		
		System.out.println("나이 : ");
		member.setAge(scanner.nextInt());
		
		System.out.println("연락처 : ");
		member.setTel(scanner.next());
		
		
		// ArrayList에 저장
		members.add(member);
		
		System.out.println("등록 완료\n");
//		System.out.println(members.size());
		
	}

	@Override
	public void find() {
		System.out.println("아이디 입력 :");
		String input = scanner.next();
		
//		System.out.println(members.size());
		
		for(int i=0; i<members.size(); i++) {
//			System.out.println(members.get(i).getMemberNo());
			if(input.equals(members.get(i).getMemberNo())) {
				System.out.println(members.get(i));
			} 
			
		} // for
		
	} // find

	@Override
	public void findAll() {
		for(Object i : members) {
			System.out.println(i);
		}
		
	}

	@Override
	public void delete() {
		System.out.println("아이디 입력 :");
		String input = scanner.next();
		
		for(int i=0; i<members.size(); i++) {
			if(input.equals(members.get(i).getMemberNo())) {
				members.remove(i);
				System.out.println("삭제 완료");
			} 
			
		} // for
		
	}

	@Override
	public void update() {
		System.out.println("아이디 입력 :");
		String input = scanner.next();
		
		for(int i=0; i<members.size(); i++) {
			if(input.equals(members.get(i).getMemberNo())) {
				
				System.out.println("이름 : ");
				members.get(i).setName(scanner.next());
				
				System.out.println("나이 : ");
				members.get(i).setAge(scanner.nextInt());
				
				System.out.println("연락처 : ");
				members.get(i).setTel(scanner.next());
				
				System.out.println("수정 완료");
				
			} 
			
		} // for
		
	} // update

	@Override
	public void quit() {
		run = false;
		System.out.println("시스템을 종료합니다.");
		
	}
	
	
} // MemberServiceImpl



