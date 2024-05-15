package sl;
import org.springframework.stereotype.Component;
@Component

public class Lamp implements Lighter {
    @Override
    public void doLight() {
        System.out.println("Lamp: I am lamp from IKEA!");
    }
}
