package genericsJoin;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class BoardServiceImpl implements BoardService {
    Map<String, Board> map = new HashMap<>();    // 참조변수의 지네릭 타입과 생성자의 지네릭 타입은 일치해야 한다.
    Scanner scanner = new Scanner(System.in);
    int bId = 0;    // board에서 게시글 번호 number를 AutoIncrease 적용할 전역변수


    /**
     * 초기실행문
     */
    @Override
    public void init() {

        while (true) {
            System.out.println("*******************");
            System.out.println("1. 회원가입");
            System.out.println("2. 게시글 쓰기");
            System.out.println("3. 게시글 조회하기");
            System.out.println("4. 게시글 삭제하기");
            System.out.println("5. 종료하기");
            System.out.print(">>");

            int input = scanner.nextInt();

            try {
                switch (input) {
                    case 1:
                        createMember();
                        break;
                    case 2:
                        createBoardByMember();
                        break;
                    case 3:
                        selectBoardByMember();
                        break;
                    case 4:
                        deleteBoardByMember();
                        break;
                    case 5:
                        quit();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("해당하는 숫자를 입력해주세요.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }   // while
    }

    /**
     * 회원가입
     */
    @Override
    public void createMember() {
        boolean run = true;

        while (run) {
            System.out.println("아이디 : ");
            System.out.print(">>");
            String id = scanner.next();

            // 아이디 중복검사 - findById(String id)를 이용
            if (true == findById(id)) { // 중복아이디가 있음
                System.out.println("다시 입력해주세요.");

            } else {

                System.out.println("비밀번호 : ");
                System.out.print(">>");
                String password = scanner.next();

                Member member = new Member(id, password);
                Board board = new Board(member);

//                map.put(1,board);   //  key타입이 int이기 때문에 저장이 되지 않는다.
                map.put(id, board);
                System.out.println("회원가입이 완료되었습니다.");

                run = false;
            }
        }
    }

    /**
     * 아이디별로 게시글 쓰기
     */
    @Override
    public void createBoardByMember() {
        System.out.println("아이디 : ");
        System.out.print(">>");

        String id = scanner.next();
        scanner.nextLine();


        map.forEach((key, value) -> {
            if (map.get(key).getMember().getMemberId().equals(id)) {
                System.out.println(map.get(key).getMember().getMemberId() + "님 글 제목을 입력해 주세요.");
                System.out.print(">>");
                map.get(key).setTitle(scanner.nextLine().trim());

                System.out.println("내용을 입력해주세요.");
                System.out.print(">>");
                map.get(key).setContents(scanner.nextLine().trim());

                map.get(key).setBoardNo(bId);
                bId++;

                System.out.println("글 등록이 완료되었습니다.");
            } else {
                System.out.println(" 없는 사용자 입니다.");
                throw new NullPointerException();
            }
        });
    }

    /**
     * 아이디별로 게시글 보기
     */
    @Override
    public void selectBoardByMember() {
        System.out.println("아이디 : ");
        System.out.print(">>");

        String id = scanner.next();

        map.forEach((key, value) -> {
            if (map.get(key).getMember().getMemberId().equals(id)) {
                System.out.println(map.get(key));
            } else {
                System.out.println("없는 사용자입니다.");
                throw new NullPointerException();
            }
        });
    }

    /**
     * 게시글 삭제하기
     */
    @Override
    public void deleteBoardByMember() {

        try {
            System.out.println("아이디 : ");
            System.out.print(">>");

            String id = scanner.next();

            map.forEach((key, value) -> {
                if (map.get(key).getMember().getMemberId().equals(id)) {
                    System.out.println("비밀번호 : ");
                    System.out.print(">>");

                    String pw = scanner.next();

                    // 비밀번호 맞는지 확인
                    if (map.get(key).getMember().getPassword().equals(pw)) {
                        map.remove(key);
                        System.out.println("글 삭제를 완료하였습니다.");
                    } else {
                        System.out.println("비밀번호가 맞지 않습니다.");
                    }
                } else {
                    System.out.println("없는 사용자입니다.");
                    throw new NullPointerException();
                }
            });

        } catch (Exception e) {

        }

    }

    /**
     * 프로그램 종료하기
     */
    @Override
    public void quit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }

    boolean findById(String id) {
        boolean check = false;

        for (String s : map.keySet()) {
            if (s.equals(id)) {
                System.out.println(id + "는 이미 있는 아이디입니다.");
                check = true;
                break;
            }
        }
        return check;
    }
}

