package collections;

import domain.Person;
import domain.Pet;
import domain.PetType;
import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.junit.jupiter.api.Test;

class MutableTest extends AbstractBaseTest{

  @Test
  void getFirstNamesOfAllPeople() {
    MutableList<String> firstNames = this.people.collect(Person::getFirstName);

    var expectedFirstNames = Lists.mutable.with("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John");
    Assertions.assertThat(expectedFirstNames).isEqualTo(firstNames);
  }

  @Test
  void getNamesOfMarySmithsPets() {
    Person person = this.getPersonNamed("Mary Smith");
    MutableList<Pet> pets = person.getPets();

    MutableList<String> names = pets.collect(Pet::getName);

    Assertions.assertThat(names.makeString()).isEqualTo("Tabby");
  }

  @Test
  void getPeopleWithCats() {
    MutableList<Person> peopleWithCats = this.people.select(person -> person.hasPet(PetType.CAT));
    Assertions.assertThat(peopleWithCats.size()).isEqualTo(2);
  }

  @Test
  void getPeopleWithoutCats() {
    MutableList<Person> peopleWithoutCats = this.people.reject(person -> person.hasPet(PetType.CAT));
    Assertions.assertThat(peopleWithoutCats.size()).isEqualTo(6);
  }
}
