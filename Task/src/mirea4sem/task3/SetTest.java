package mirea4sem.task3;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) throws Exception{
        Set<Integer> set = new HashSet<>(){
            @Override
            synchronized public boolean add(Integer e) {
                return super.add(e);
            }
        };

        Thread one = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                set.add(i);
            }
        });

        Thread two = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                set.add(i + 5);
            }
        });

        one.start();
        two.start();
        Thread.sleep(10);

        System.out.println(set);
    }
}
