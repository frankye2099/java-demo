package com.example.stream;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 10).toArray());

        System.out.println(IntStream.range(1, 10).anyMatch(x -> x > 5));

        System.out.println(IntStream.range(1, 100).filter(x -> x > 5).skip(2).limit(2).map(x -> x * x).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(1, 100).summaryStatistics());
        System.out.println(IntStream.generate(() -> {
            Random r = new Random();
            return r.nextInt(10);
        }).limit(10).boxed().collect(Collectors.toList()));


        Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck")
                .filter(n -> n.length() % 2 != 0)
                .forEach(System.out::println);

        IntStream.Builder ib = IntStream.builder().add(3).add(2).add(6).add(7).add(1);
        System.out.println(ib.build().sorted().boxed().collect(Collectors.toList()));

        System.out.println(Stream.of(3,6,9, 8,2,4).reduce(Integer.MAX_VALUE, Integer::min));

    }
}
