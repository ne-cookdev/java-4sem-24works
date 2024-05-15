package mirea4sem.task2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Comparator;

public class HumanTest {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(19, "Pavel", "Vishnyakov",
                LocalDate.of(2004, Month.JULY, 4), 90));
        humans.add(new Human(20, "Darya", "Krupenyova",
                LocalDate.of(2003, Month.DECEMBER, 26), 70));
        humans.add(new Human(19, "Denis", "Vorobyov",
                LocalDate.of(2004, Month.DECEMBER, 9), 85));

        Stream<Human> humanStream = humans.stream();

        int result = humanStream.sorted(Comparator.comparingInt(h -> h.firstname.charAt(1))).
                filter(h -> h.weight % 10 == 0).
                sorted(Comparator.comparingInt(person -> person.weight * person.age)).
                mapToInt(h -> h.weight).reduce(1, Math::multiplyExact);
        System.out.println(result);
    }
}
