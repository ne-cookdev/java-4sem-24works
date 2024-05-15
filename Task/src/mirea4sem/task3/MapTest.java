package mirea4sem.task3;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MapTest {
    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new ReentrantLock();

        HashMap<Integer, String> map = new HashMap<>(){
            @Override
            public String put(Integer i, String s){
                try {
                    lock.lock();
                    return super.put(i, s);
                }
                finally {
                    lock.unlock();
                }
            }
        };

        Thread one = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                map.put(i, "test");
            }
        });

        Thread two = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                map.put(i + 5, "test");
            }
        });

        one.start();
        two.start();
        Thread.sleep(10);

        System.out.println(map);
    }
}
