package com.example.collections;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Blocking behaviour: put()/take()
 * Objects add to queue ASAP until blocked by max size.
 */
public class BlockingQueueDemo {
    public static void main(String[] arg) {
        BlockingQueue queue = new LinkedBlockingQueue(10);
        Producer p = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}

class Producer implements Runnable {
    private final BlockingQueue queue;

    Producer(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                queue.put(produce());
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

class Consumer implements Runnable {
    private final BlockingQueue queue;

    Consumer(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(new Random().nextInt(1000));
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
        }
    }

    void consume(Object x) {
        System.out.println(Thread.currentThread() + "    :  " + x);
    }
}
