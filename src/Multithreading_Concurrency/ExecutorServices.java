package Multithreading_Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {

    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Executing task with id: " + id + " in thread with id: " + Thread.currentThread().threadId());
            TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ExecutorServices {

    public static void main(String[] args) {
        System.out.println("SingleThreadExecutor");
        singleThreadTest();
        System.out.println("FixedThreadExecutor");
        fixedThreadTest();
        System.out.println("CachedThreadExecutor");
        cachedThreadTest();
    }

    public static void fixedThreadTest() {
        ExecutorService fes = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 15; i++) {
            fes.execute(new Task(i*100));
        }

        fes.shutdown();

        try {
            if (fes.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                fes.shutdownNow();
            }
        } catch (InterruptedException e) {
            fes.shutdownNow();
        }
    }

    public static void singleThreadTest() {
        ExecutorService ste = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            ste.execute(new Task(i));
        }

        ste.shutdown();

        try {
            if (ste.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                ste.shutdownNow();
            }
        } catch (InterruptedException e) {
            ste.shutdownNow();
        }


    }

    public static void cachedThreadTest() {
        ExecutorService ces = Executors.newCachedThreadPool();

        for (int i = 0; i < 15; i++) {
            ces.execute(new Task(i*10000));
        }

        ces.shutdown();
    }

}
