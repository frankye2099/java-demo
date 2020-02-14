package com.example.collections;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * offer() / poll() will return null if not available
 */
public class BlockingQueueDemo2 {
    public static void main(String[] arg) {
        BlockingQueue queue = new LinkedBlockingQueue(10);
        Producer2 p = new Producer2(queue);
        Consumer2 c1 = new Consumer2(queue);
        Consumer2 c2 = new Consumer2(queue);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}

class Producer2 implements Runnable {
    private final BlockingQueue queue;

    Producer2(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                if(queue.offer(produce())) {
                    System.out.println("offer success");
                } else {
                    System.out.println("offer failed");
                }
            }
        } catch (InterruptedException ex) {
        }
    }

    Object produce() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(Thread.currentThread() + "   >>>>  " + uuid + "  >>>> " + this.queue.size());
        return uuid;
    }
}

class Consumer2 implements Runnable {
    private final BlockingQueue queue;

    Consumer2(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(new Random().nextInt(1000));
                consume(queue.poll(1, TimeUnit.MILLISECONDS));
            }
        } catch (InterruptedException ex) {
        }
    }

    void consume(Object x) {
        System.out.println(Thread.currentThread() + "    :  " + x);
    }
}
