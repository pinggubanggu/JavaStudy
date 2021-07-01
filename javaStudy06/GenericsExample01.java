package javaStudy06;

import java.util.ArrayList;

class Product{ }
class Tv extends Product { }
class Audio extends Product { }

public class GenericsExample01 {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<Product>();
        ArrayList<Tv>      tvList = new ArrayList<>();

        productList.add(new Tv());
        productList.add(new Audio());

        tvList.add(new Tv());
        tvList.add(new Tv());

        printAll(productList);
        // printAll(tvList); 컴파일 에러 발생

    }

    private static void printAll(ArrayList<Product> list) {
        for(Product p : list) {
            System.out.println(p);
        }
    }
}
