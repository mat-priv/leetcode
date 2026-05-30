package Multithreading_Concurrency;

public class ThreadsCreation {

    static class Runner1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                    System.out.println("Runner 1: " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
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
                    Thread.sleep(100);
                    System.out.println("______Runner 3: " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable runner4 = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(250);
                    System.out.println("_________Runner 4: " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        var thread3 = new Thread(runner3);
        var thread4 = new Thread(runner4);

        thread3.start();
        thread4.start();;
    }
}
