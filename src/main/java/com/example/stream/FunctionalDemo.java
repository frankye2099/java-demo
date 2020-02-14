package com.example.stream;

public class FunctionalDemo {
    public static void main(String[] args) {
        Area sq = x -> x * x;
        System.out.println(sq.calculate(5));
        System.out.println(sq.calculate(6));

        Area circle = r -> 3.14 * r * r;
        System.out.println(circle.calculate(5));
        System.out.println(circle.calculate(6));

        System.out.println(Area.sq.calculate(5));
        System.out.println(Area.circle.calculate(5));
        System.out.println(sq.doubleIt(9));
    }
}
