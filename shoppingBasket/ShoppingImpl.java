package shoppingBasket;

import java.util.*;
import java.util.regex.Pattern;

public class ShoppingImpl implements Shopping {

    private static Scanner sc = new Scanner(System.in);
    private static final List<Member> list = new ArrayList<>();    // 회원정보 저장소  / static 변수 : 모든 인스턴스에 공통적으로 사용
    private static final Set cart = new HashSet();    // 장바구니
    private String emailId = "";    // 입력한 id에 @gmail.com을 붙여서 저장한 변수


    @Override
    public void init() {
        while (true) {
            System.out.println("*****장보기 프로그램*****");
            System.out.println("원하는 번호를 입력해주세요.");
            System.out.print("1. 회원가입\n" + "2. 로그인\n" + "3. 종료\n");

            System.out.println(">>");

            String input = sc.next();

            if ("".equals(input)) continue;

            if (input.equals("1")) join();
            else if (input.equals("2")) login();
            else if (input.equals("3")) quit();
            else System.out.println("잘못 입력하셨습니다.");

        }
    }

    @Override
    public void join() {
//        Member member = new Member();   // 아이디, 비밀번호 저장할 멤버 인스턴스 생성
        boolean run = true;
        String id = "";


        while (run) {
            System.out.println("*******************");
            System.out.println("아이디 (맨앞만 숫자 불가능/ 대소문자,숫자 모두 가능/ 최소 4자에서 12자까지 특수문자 불가)");
            System.out.println(">>");
            id = sc.next();

            String regExp = "[a-zA-Z]{1}[a-zA-Z0-9]{3,11}"; // 맨앞만 숫자 불가능/ 대소문자,숫자 모두 가능/ 최소 4자에서 12자까지 특수문자 불가)

            // 1. ID가 정규식 조건에 부합하는지 
            boolean isMatch = Pattern.matches(regExp, id);
            emailId = id + "@gmail.com";

            if (!isMatch) { // ID가 정규식 조건에 부합하지 않으면 부합하면 해당 블럭{}만 수행하고 if문을 빠져나간다.
                System.out.println("ID 로 사용할 수 없습니다.");
            } else {    // ID가 정규식 조건에 부합하면 -> 2. 중복 아이디가 없는지
                if (findById() == null) {  // 중복 아이디가 없다.
                    break;  // while문을 빠져나가서 저장
                } else {
                    System.out.println("이미 중복된 ID가 있습니다.");
                    System.out.println("다시 한 번 입력해주세요\n");
                }
            }
        }   // while

        System.out.println(id + "는 ID로 사용할 수 있습니다.");
//        member.setId(emailId);   //

        System.out.println("비밀번호\n >>");

        String pw = sc.next();
//        member.setPw(pw);   // pw 저장

        Member member = new Member(emailId, pw);

        list.add(member);   // 회원정보 저장소에 저장

        run = false;

        System.out.println(id + "님의 회원가입이 완료되었습니다.\n");
    }


    @Override
    public void login() {
        boolean run1 = true;
        boolean run2 = true;

        while (run1) {   // 아이디 while문
            System.out.println("아이디를 입력하세요");
            System.out.println(">>");

            String id = sc.next();
            emailId = id + "@gmail.com";

            if (findById() == null) {
                System.out.println("아이디가 없습니다.");
            } else {    // 일치하는 아이디가 있을 때
                run1 = false;

                while (run2) {  // 비밀번호 while문
                    System.out.println("비밀번호를 입력하세요");
                    System.out.println(">>");

                    String pw = sc.next();
                    // nextLine()는 Enter값을 기준으로 메소드를 종료시킨다. next()는 문자열만 리턴하고 종료 -> Enter값이 남아있음.
                    sc.nextLine();  // 엔터값이 남아있어서 이걸로 흡수

                    // 아니면 그냥 String pw = sc.nextLine()을 쓴다.
                    
                    if (findById().getPw().equals(pw)) {
                        System.out.println("로그인 되었습니다.");
                        showMenu();
                        run2 = false;
                    } else {
                        System.out.println("비밀번호를 잘못 입력하였습니다.");
                        System.out.println("다시 입력해주세요\n");
                    }

                }
            }

        }
    }

    @Override
    public void showMenu() {
        boolean run = true;

        while (run) {
            System.out.println();
            System.out.println("**********************");
            System.out.println("원하는 번호를 입력하세요.");
            System.out.println("1. 장보기");
            System.out.println("2. 장바구니 보기");
            System.out.println("3. 메인화면으로 돌아가기");
            System.out.println(">>");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    shop();
                    break;
                case "2":
                    showCart();
                    break;
                case "3":
                    run = false;
                    break;
                default:
                    System.out.println("잘못 입력하였습니다.");
                    System.out.println("다시 입력하세요.");
            }

        }

    }

    @Override
    public void shop() {
        boolean run = true;

        while (run) {
            System.out.println("******** 장보기 - 물품을 입력하세요 *********");
            System.out.println("구분자(,)사용하여 입력하세요 - ex) 사과,배,과자");
            System.out.println("if) 추가 물품이 없을 경우, exit 입력");
            System.out.println(">>");


            String product = sc.nextLine().trim();

            if (product.equalsIgnoreCase("exit")) break;

            else {
                String[] p1 = product.split(",");   // 구분자로 나눠서 String 배열에 각각 저장
                for (String s : p1) {
                    String p2 = s.trim();
                    cart.add(p2); // 장보기에서 똑같은 과일을 입력했을시 중복으로 넣어버리기 -> 인터페이스 set(중복x)을 구현한 HashSet 클래스 쓰기
                }
            }
        }
    }


    @Override
    public void showCart() {
        int index = 1;  // 장바구니 물품 번호(AutoIncrease)
        System.out.println();
        System.out.println("*************");
        System.out.println("장바구니 목록");

        Iterator it = cart.iterator();  //  Iterator : 컬렉션에 저장된 요소를 접근하는데 사용

        while (it.hasNext()) {
            System.out.print(index++ + "." + it.next() + " ");
        }
    }

    @Override
    public void quit() {
        System.exit(0);
        System.out.println("프로그램이 종료되었습니다");
    }

    @Override
    public Member findById() {
        for (Member m : list) {
            if (m.getId().equals(emailId))
                return m;
        }
        return null;    // 메소드가 특정조건에서 값을 반환할 수 없을 때 null 반환보다는 추후에 Optional을 이용해 보자 https://eglowc.tistory.com/42(clean code)
    }

}
