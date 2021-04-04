package java15;

public record Person(String name, Integer age) {

    public Person(String name) {
        this(name, null);
    }

}