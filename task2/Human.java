package mirea4sem.task2;
import java.lang.*;
import java.time.LocalDate;

public class Human {
    int age;
    String firstname;
    String lastname;
    LocalDate birthDate;
    int weight;

    Human(int age, String firstname, String lastname, LocalDate birthDate, int weight){
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                '}';
    }
}
