package genericsJoin;

public class BoardApp {
    public static void main(String[] args) {
        BoardService bs = new BoardServiceImpl();
        bs.init();
    }

}
