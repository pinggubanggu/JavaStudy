package javastudy06;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MemberServiceImpl implements MemberService {

	boolean run = true;
	Scanner scanner = new Scanner(System.in);
	
	// ArrayList보다 비연속적인 데이터의 추가,삭제가 빠르다. 순차적인 추가삭제는 ArrayList가 더 빠름.
	List<Board> list = new LinkedList<Board>();
	
	@Override
	public void init() {
		while(run)
			menu();
		
	}

	@Override
	public void menu() {
		System.out.println("*************");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 삭제");
		System.out.println("3. 게시글 조회");
		System.out.println("4. 회원가입");
		System.out.println("*************");
		
		String input = scanner.next();
		
		switch(input) {
		
			case "1" :
				write();
				break;
			case "2" :
				delete();
				break;
			case "3" :
				findBy();
				break;
			case "4" :
				insert();
				break;
			default :
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
		}
		
	}

	@Override
	public void insert() {
		Member member = new Member();
		Board board = new Board();
		String id="";		// 빈문자열로 저장해야 쓸 수 있다.
		boolean run2 = true;
		
		
		while(run2) {
			System.out.println("*** 회원등록 ***");
			System.out.println(" 아이디 : ");
		
		try {
		// 아이디 중복확인
			id = scanner.next();
			
//		 숫자만 입력했을 시 일부러 예외발생(NumberFormatException)
			if(0 <= Integer.parseInt(id)) 
			
		// 처음에 list.size가 0이여서 for문이 돌지 않아서	
			if(list.size() == 0) {
				break;
			
				} else {
					
					for(int i=0; i<list.size(); i++) {
						if(id.equals(list.get(i).getMember().getMemberId())) {
							System.out.println("이미 있는 아이디입니다.");
							break;
					// break문은 자신이 포함된 가장 가까운 반복문을 벗어난다. -> for문 벗어남
					
				// else if 조건문 목적 : 이 조건문의 실행을 한번만 하기 위해
			    // 전체 데이터베이스를 확인했는데도 중복된게 없으면 while문을 빠져나가는 조건문
				} 		else if(i == list.size()-1 || i == list.size()) {
							run2 = false; 
				}
				
			}	// for 
		
			}  // else
				
			}	catch (Exception e) {
				System.out.println("숫자만 입력 할 수 없습니다.");
			}
		}	// while
			
		
		// 1. member 인스턴스에 저장
		member.setMemberId(id);
		
		System.out.println(" 이름 : ");
		member.setUserName(scanner.next());
		
		System.out.println(" 비밀번호 : ");
		member.setPassword(scanner.next());
		
		// 2. board 인스턴스에 저장
		board.setMember(member);
		
		// 3. ArrayList에 저장
		list.add(board);
		
		System.out.println(" 회원가입이 완료되었습니다.\n");
		
	}

	@Override
	public void write() {
		
		Board board = new Board();
		String password ="";
		
		System.out.println("*** 게시글 작성 ***");
		System.out.println(" 아이디 : ");
		String id = scanner.next();
		boolean run2 = true;
		
		if(list.size() == 0) {
			System.out.println(" 아이디가 없습니다. \n 회원가입 하세요. \n");

			} else { 
				for ( int i=0; i<list.size(); i++  ) {
					if(id.equals(list.get(i).getMember().getMemberId())) {
						
						while(run2) {
							System.out.println(" 비밀번호 : ");
							password = scanner.next();
						
							if(password.equals(list.get(i).getMember().getPassword())) {
								
								board.setMember(list.get(i).getMember());
								
								System.out.println(" 제목 : ");
								board.setTitle(scanner.next());
							
								System.out.println(" 내용 :");
								board.setContents(scanner.next());
							
								System.out.println(" 글 등록이 완료되었습니다.\n ");
								board.setBoardId(list.get(i).getMember().getMemberNo());
							
								// 멤버 아이디마다 게시판 글 번호 붙이기
								int no = list.get(i).getMember().getMemberNo();
								no++;	// 1 증가시키고
								list.get(i).getMember().setMemberNo(no); // 1 증가시킨 걸 다시 저장
							
								list.add(board);
								
								run2 = false;	// 글 등록이 완료 되었으니 while문 다시 돌지 않게
							
							} else {
								System.out.println("비밀번호를 다시 입력해 주십시오.");
								// while문 돌아서 다시 비밀번호 확인
							}
						}	// while
					
					} else if(i == list.size()-1 ) {
						System.out.println(" 아이디가 없습니다. \n 회원가입 하세요. \n");
					} 	// 바깥  if
			
		}	// for
		
		}	// else문 	
		
		}	
		

	@Override
	public void delete() {
		System.out.println(" *** 게시글 삭제 *** ");
		System.out.println(" 아이디 : ");
		String id = scanner.next();
		
//		System.out.println("삭제할 글 번호를 하나 선택하세요.");
		if(0 == list.size()) {
			System.out.println(" 아이디가 없습니다. ");
			} else {
				for(int i=0; i<list.size(); i++) {
					if(id.equals(list.get(i).getMember().getMemberId())) {
					
						// 처음에 member 저장한 제목 내용이 없는 빈 board 인스턴스 출력안하게 하기
						if(null == list.get(i).getTitle())
							continue;
						
						System.out.println("***************");
						System.out.print(" "+list.get(i).getBoardId());
						System.out.print(". ");
						System.out.println(list.get(i).getTitle());
						System.out.println("***************");
						
						System.out.println(" 이 글을 삭제하시겠습니까? ");
						System.out.println(" 네 : 1번 입력 \n 아니오 : 2번 입력 ");
						
						String input = scanner.next();
						
						switch(input) {
							case "1" : 
								
								System.out.println(" 비밀번호 : "); 
								String password = scanner.next();
								if(password.equals(list.get(i).getMember().getPassword())) {
									list.remove(i);
									System.out.println(" 삭제 되었습니다. ");
									}
								
								break;
							
							case "2" : break;
						}
						
					} else if (i == list.size()-1) {
						System.out.println("아이디가 없습니다.");
					} 
									
			}	// for문
			
		}	// else문
		
	}

	@Override
	public void findBy()  {

		System.out.println(" *** 게시글 조회 *** ");
		System.out.println(" 아이디 : ");
		String id = scanner.next();
		
		// 조회시 아이디 없을때 예외 발생시켜서 예외처리하기 
		try {
			if(0 == list.size()) {
				Exception e = new Exception("아이디가 없습니다.");
				throw e;
			} else {
				for(int i=0; i<list.size(); i++) {
					if(id.equals(list.get(i).getMember().getMemberId())) {
						if( null == list.get(i).getTitle() )
							continue;
						// continue문은 반복문 내에서만 사용 될 수 있으며, 
						// 반복이 진행되는 도중에 continue문을 만나면 반복문의 끝으로 이동하여 다음 반복으로 넘어간다.
						
						System.out.println(list.get(i));
					} else if ( i == list.size()-1) {
						Exception e = new Exception("아이디가 없습니다.");
						throw e;
					}
					
					} // for문
			}
		} catch (Exception e) {
			System.out.println("\n"+e.getMessage()+"\n");
		}
	
	}	
	

	@Override
	public void quit() {
		run = false;
		System.out.println("프로그램이 종료되었습니다.");
		
	}

	
}
