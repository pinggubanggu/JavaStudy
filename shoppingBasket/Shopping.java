package shoppingBasket;

public interface Shopping {

    // 1. 실행
    void init();

    // 2. 회원가입
    void join();
    
    // 2-1. 회원가입 할 때 기존에 아이디 있는지 확인
    Member findById();

    // 3. 로그인
    void login();

    // 4. 장보기 메뉴
    void showMenu();

    // 5. 장보기
    void shop();

    // 6. 장바구니
    void showCart();

    // 7. 프로그램 종료
    void quit();
}
