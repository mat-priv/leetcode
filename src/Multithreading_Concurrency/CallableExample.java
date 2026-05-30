package Multithreading_Concurrency;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Processor implements Callable<String> {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        long time = Instant.now().toEpochMilli();
        try {
            if (id / 2 == 2 && id % 2 == 0)
                TimeUnit.SECONDS.sleep(20);
            else
                TimeUnit.SECONDS.sleep(2);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Executing task with id: " + id
                + " in thread with id: " + Thread.currentThread().threadId()
                + " time to proces: " + (Instant.now().toEpochMilli() - time);
    }
}

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<String> result = pool.submit(new Processor(i));
            futures.add(result);
        }

        for (Future<String> f : futures) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        pool.shutdown();

    }
}
