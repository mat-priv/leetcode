package Multithreading_Concurrency.threads_creation;

public class DaemonThreads {

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
        //will be interrupted because it is daemon thread. User thread will be finished earlier.
        thread2.setDaemon(true);
        thread2.start();


        System.out.println("----------------Runner 1 and 2 are done. Finishing main thread.");
    }
}
