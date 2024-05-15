package mirea4sem.task4;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyExecutorService {
    private final int numThreads;
    private final List<Thread> threads;
    private final BlockingQueue<Runnable> tasks;

    public MyExecutorService(int numThreads) {
        this.numThreads = numThreads;
        this.threads = new LinkedList<>();
        this.tasks = new LinkedBlockingQueue<>();

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        Runnable task = tasks.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }
    }

    public void submit(Runnable task) {
        tasks.add(task);
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}