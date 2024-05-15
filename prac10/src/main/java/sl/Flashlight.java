package sl;
import org.springframework.stereotype.Component;
@Component
public class Flashlight implements Lighter {
    @Override
    public void doLight() {
        System.out.println("Flashlight: Im flash in the night!");
    }
}
