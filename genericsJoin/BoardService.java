package genericsJoin;

public interface BoardService {
    /**
     * 초기실행문 */
    void init();

    /**
     * 회원가입 */
    void createMember();

    /**
     * 아이디별로 게시글 쓰기 */
    void createBoardByMember();

    /**
     * 아이디별로 게시글 보기 */
    void selectBoardByMember();

    /**
     * 게시글 삭제하기 */
    void deleteBoardByMember();

    /**
     * 프로그램 종료하기 */
    void quit();

}
