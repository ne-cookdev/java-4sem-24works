package mirea4sem.task4;

public class Main {
    public static void main(String[] args) {
        MyExecutorService executor = new MyExecutorService(3);

        executor.submit(() -> {
            System.out.println("Task 1 executed by thread " + Thread.currentThread().getName());
        });

        executor.submit(() -> {
            System.out.println("Task 2 executed by thread " + Thread.currentThread().getName());
        });

        executor.submit(() -> {
            System.out.println("Task 3 executed by thread " + Thread.currentThread().getName());
        });

        executor.shutdown();
    }
}