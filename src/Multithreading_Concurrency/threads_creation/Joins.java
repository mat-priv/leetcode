package Multithreading_Concurrency.threads_creation;

public class Joins {

    static class Runner1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println("Runner 1: " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("----------------Runner 1 finished the job...");
        }
    }

    static class Runner2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    System.out.println("___Runner 2: " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("----------------Runner 2 finished the job...");
        }
    }


    public static void main(String[] args) {
        var thread1 = new Thread(new Runner1());
        var thread2 = new Thread(new Runner2());

        thread1.start();
        thread2.start();

        Runnable runner3 = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(400);
                    System.out.println("______Runner 3: " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("----------------Runner 3 finished the job...");
        };

        Runnable runner4 = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println("_________Runner 4: " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("----------------Runner 4 finished the job...");
        };

        var thread3 = new Thread(runner3);
        var thread4 = new Thread(runner4);

        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("----------------Runner 1 and 2 are done. Finishing main thread.");
    }
}
