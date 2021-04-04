package java15;

public class PersonExample {
    public static void main(String[] args) {
        Person john = new Person("john", 20);
        System.out.println(john.toString());
        Person joe = new Person("joe");
        System.out.println(joe);
    }
}
