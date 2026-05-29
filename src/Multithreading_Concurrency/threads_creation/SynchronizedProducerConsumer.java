package Multithreading_Concurrency.threads_creation;

import java.util.LinkedList;
import java.util.List;

public class SynchronizedProducerConsumer {


    public static void main(String[] args) {
        SharedBuffer sb = new SharedBuffer(5);

        Thread c = new Thread(new Consumer(sb));
        Thread p = new Thread(new Producer(sb));

        c.start();
        p.start();

    }
}

class SharedBuffer {
    public List<Integer> buffer = new LinkedList<>();
    public int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce() throws InterruptedException {
        while (buffer.size() == capacity) {
            System.out.println("Buffer is full. Producer will wait now...");
            wait();
        }

        for (int i = 0; i < capacity; i++) {
            buffer.add(i);
            System.out.println("Producer added " + i + " to the buffer");
        }
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (buffer.size() < capacity) {
            System.out.println("Buffer is not full. Waiting for producer to finish the job");
            wait();
        }

        while (buffer.size() != 0) {
            buffer.remove(0);
            System.out.println("Consumer removed element from the buffer");
        }

        notify();
    }
}

class Producer implements Runnable {
    private SharedBuffer sharedBuffer;

    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sharedBuffer.produce();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Consumer implements Runnable {

    private SharedBuffer sharedBuffer;

    public Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sharedBuffer.consume();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
