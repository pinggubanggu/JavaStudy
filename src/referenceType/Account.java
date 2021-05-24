package referenceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {
	private Scanner scanner = new Scanner(System.in);
	private boolean run = true;
	private List<AccountBean> accounts = new ArrayList<>();
	
	public void init() {
		while(run) {
			menu();
		}
	}

	private void menu() {
		System.out.println("****메뉴****");
		System.out.println(" 1. 계좌생성");
		System.out.println(" 2. 계좌목록");
		System.out.println(" 3. 예금");
		System.out.println(" 4. 출금");
		System.out.println(" 5. 종료");
		System.out.println("***********");
		
		String input = scanner.next();
		switch(input) {
		case "1" : 
			accountMake();
			break;
		case "2" : 
			findAllList();
			break;
		case "3" :
			deposit();
			break;
		case "4" :
			withdraw();
			break;
		case "5" :
			quit();
			break;
		default : 
			System.out.println("잘못 눌렀습니다. 다시 입력해주세요.");
		}
	}
	
	// 1. 계좌생성
	private void accountMake() {
		
		// 저장할 accountBean 인스턴스 생성
		AccountBean account = new AccountBean();
		
		System.out.println("1.계좌생성");
		System.out.println("계좌번호 : ");
		account.setAccountNumber(scanner.nextInt());
		
		System.out.println("계좌주 : ");
		account.setAccountName(scanner.next());
		
		System.out.println("입급액 : ");
		account.setDepositAmount(scanner.nextInt());
		
		System.out.println("결과 : 계좌가 생성되었습니다.");
		
		// List에 저장
		accounts.add(account);
	}
	
	// 2. 계좌목록
	private void findAllList() {
		for(Object i : accounts) {
			System.out.println(i);
		}
//		accounts.forEach(r -> System.out.println(r));

	}
	
	// 3. 예금
	private void deposit() {
		System.out.println("계좌번호 : ");
		int input = scanner.nextInt();
		
		// accounts에서 입력한 계좌번호와 맞는 객체 찾기
		for(int i=0; i<accounts.size(); i++) {
			if(input == accounts.get(i).getAccountNumber()) {
				
				// 계좌목록에 있는 계좌번호와 맞는게 있으면 예금 절차 시행
				System.out.println("예금액 : ");
				int input2 = scanner.nextInt();
				
				// 기존에 있던 예금액과 현재 넣을 예금액을 합치기
				int ResultDeposit = input2 + accounts.get(i).getDepositAmount();
				accounts.get(i).setDepositAmount(ResultDeposit);
				
				System.out.println("결과 : 예금이 성공하였습니다.");
				break;
			} else {
				System.out.println("일치하는 계좌번호가 없습니다.");
			}
		} // for
		
	} // deposit
	
	private void withdraw() {
		boolean run2 = true;
		int input2 = 0;
		System.out.println("계좌번호 : ");
		int input = scanner.nextInt();
		
//		System.out.println(input);
//		System.out.println(accounts.get(0).getAccountNumber());
//		System.out.println(input == accounts.get(0).getAccountNumber());
		
		
		// accounts에서 입력한 계좌번호와 맞는 객체 찾기
		for(int i=0; i<accounts.size(); i++) {
			if(input == accounts.get(i).getAccountNumber()) {
				
				// 계좌목록에 있는 계좌번호와 맞는게 있으면 출금 절차 시행
				System.out.println("출금액 : ");
				input2 = scanner.nextInt();
				
				// 기존에 있던 예금액에서 현재 출금액을 빼기
				// 1) if문으로 출금액이 예금액보다 큰 금액인지 확인
				if(input2 > accounts.get(i).getDepositAmount() ) {
					System.out.println("출금액이 예금액보다 더 큽니다.");
					continue;
					}
				
				// 2) 출금액이 예금액보다 크지 않으면 출금절차 실행
				 else { 
					// 기존 예금액에서 출금액 빼기
					int ResultDeposit = accounts.get(i).getDepositAmount() - input2;
					// 남은 금액 계좌 예금액으로 다시 저장하기
					accounts.get(i).setDepositAmount(ResultDeposit);
				
					System.out.println("결과 : 출금이 성공하였습니다.");
					break;
				}
			} else  {
				System.out.println("일치하는 계좌번호가 없습니다.");
			}
		} // for
		
	} // withdraw
		private void quit() {
			run = false;
			System.out.println("시스템을 종료합니다.");
		}
		
	
}
