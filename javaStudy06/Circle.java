package javaStudy06;

public class Circle implements Cloneable {

    Point p;
    Double r;

    Circle(Point p , double r) {
        this.p = p;
        this.r = r;
    }

    public Circle shallowCopy() {
        Object obj = null;

        try {
           obj = super.clone();
        } catch (CloneNotSupportedException e) { }
        return (Circle)obj;
    }

    public Circle deepCopy() {
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) { }

        Circle c = (Circle)obj;
        c.p = new Point(this.p.x, this.p.y);

        return c;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
