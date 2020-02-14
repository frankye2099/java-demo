package com.example.multithread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo  " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar  " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        System.out.println("Before submit");
        executor.submit(runnable);
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(1);
            String threadName = Thread.currentThread().getName();
            System.out.println("task " + threadName);
            return 123;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());

        Integer result = null;
        try {
            result = future.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println("future done? " + future.isDone());
        System.out.println("result: " + result);


        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        try {
            executor.invokeAll(callables)
                    .stream()
                    .map(f -> {
                        try {
                            return f.get();
                        }
                        catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
