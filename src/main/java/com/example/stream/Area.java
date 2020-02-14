package com.example.stream;

@FunctionalInterface
public interface Area {
    double calculate(double x);

    default double doubleIt(double x) {
        return x * 2;
    }

    Area sq = x -> x * x;
    Area circle = r -> Math.PI * r * r;

}
