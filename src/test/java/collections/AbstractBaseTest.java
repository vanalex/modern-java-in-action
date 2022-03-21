package collections;

import domain.Person;
import domain.PetType;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractBaseTest {

  protected MutableList<Person> people;

  @BeforeEach
  public void setUp() throws Exception {
    this.people = Lists.mutable.with(
        new Person("Mary", "Smith").addPet(PetType.CAT, "Tabby", 2),
        new Person("Bob", "Smith")
            .addPet(PetType.CAT, "Dolly", 3)
            .addPet(PetType.DOG, "Spot", 2),
        new Person("Ted", "Smith").addPet(PetType.DOG, "Spike", 4),
        new Person("Jake", "Snake").addPet(PetType.SNAKE, "Serpy", 1),
        new Person("Barry", "Bird").addPet(PetType.BIRD, "Tweety", 2),
        new Person("Terry", "Turtle").addPet(PetType.TURTLE, "Speedy", 1),
        new Person("Harry", "Hamster")
            .addPet(PetType.HAMSTER, "Fuzzy", 1)
            .addPet(PetType.HAMSTER, "Wuzzy", 1),
        new Person("John", "Doe")
    );
  }

  public Person getPersonNamed(String fullName) {
    return this.people.detectWith(Person::named, fullName);
  }
}
