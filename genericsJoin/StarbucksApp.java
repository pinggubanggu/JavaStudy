package genericsJoin;

import java.util.ArrayList;
import java.util.List;

interface Starbucks { }

class FrappuccinoSyrup { }
class Frappuccino implements Starbucks {
    FrappuccinoSyrup fsyrup;
    public String toString() { return "Frappuccino"; }
}

class JavaChip extends Frappuccino { public String toString() { return "JavaChip"; }}
class Malcha extends Frappuccino { public String toString() { return "Malcha"; }}

class Latte { }

public class StarbucksApp {
    public static void main(String[] args) {
        StarbucksBasket<Frappuccino> fsb = new StarbucksBasket<>();
        fsb.add(new JavaChip());
        fsb.add(new Malcha());
        fsb.add(new Frappuccino());
//        fsb.add(new Latte());   // 에러. <T extends Frappuccino & Starbucks>를 만족하는 타입만 대입 될 수 있다.

        StarbucksBasket<JavaChip> jsb = new StarbucksBasket<>();
        jsb.add(new JavaChip());
//        jsb.add(new Frappuccino());   // 에러. JavaChip의 조상은 올 수 없음.
//        jsb.add(new Malcha());  // 에러. JavaChip과 자손관계가 아님.

        System.out.println("fsb : " + fsb);
        System.out.println("jsb : " + jsb);
    }
}

class StarbucksBasket<T extends Frappuccino & Starbucks> extends Basket<T> { }
class Basket<T> {
    List<T> list = new ArrayList<T>();
    void add(T item) { list.add(item); }
    T get(int i) { return list.get(i); }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
}
