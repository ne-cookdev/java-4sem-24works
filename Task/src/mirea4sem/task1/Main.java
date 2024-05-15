package mirea4sem.task1;

public class Main implements Function {
    @Override
    public int nod(int a, int b) {
        int min_a_b = Math.min(a, b);
        for (int i = min_a_b; i > 1; i--) {
            if(a % i == 0 && b % i == 0){
                return i;
            }
            i--;
        }
        return 1;
    }
}
