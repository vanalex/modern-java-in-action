package streams.streams;

import java.util.Arrays;
import java.util.List;

public class MaxAndMinTestFixture {
    public static List<Employee> buildEmployeeList(){
        return Arrays.asList(
                new Employee("Cersei",     250_000, "Lannister"),
                new Employee("Jamie",      150_000, "Lannister"),
                new Employee("Tyrion",       1_000, "Lannister"),
                new Employee("Tywin",    1_000_000, "Lannister"),
                new Employee("Jon Snow",    75_000, "Stark"),
                new Employee("Robb",       120_000, "Stark"),
                new Employee("Eddard",     125_000, "Stark"),
                new Employee("Sansa",            0, "Stark"),
                new Employee("Arya",         1_000, "Stark"));
    }
}
