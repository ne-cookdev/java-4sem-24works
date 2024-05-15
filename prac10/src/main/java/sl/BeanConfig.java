package sl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class BeanConfig {
@Bean
    public Lighter a(){
        return new Lamp();
    }
    @Bean
    public Lighter b(){
        return new Flashlight();
    }
    @Bean
    public Lighter c(){
        return new Firefly();
    }
}
