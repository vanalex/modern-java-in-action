package collections;

import domain.Person;
import domain.Pet;
import domain.PetType;
import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.Sets;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
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

  @Test
  void doAnyPeopleHaveCats(){
    Predicate<Person> predicate = person -> person.hasPet(PetType.CAT);
    Assertions.assertThat(this.people.anySatisfy(predicate)).isTrue();
  }

  @Test
  void doAllPeopleHavePets() {
    Predicate<Person> predicate = Person::isPetPerson;
    boolean result = this.people.allSatisfy(predicate);
    Assertions.assertThat(result).isFalse();
  }

  @Test
  void howManyPeopleHaveCats() {
    int count = 2;
    int result = this.people.count(person -> person.hasPet(PetType.CAT));
    Assertions.assertThat( count).isEqualTo(result);
  }

  @Test
  void findMarySmith() {
    Person result = this.people.detectWith(Person::named, "Mary Smith");
    Assertions.assertThat(result.getFirstName()).isEqualTo("Mary");
    Assertions.assertThat(result.getLastName()).isEqualTo("Smith");
  }

  @Test
  void getPeopleWithPets() {
    MutableList<Person> petPeople = this.people.select(Person::isPetPerson);
    Assertions.assertThat(petPeople.size()).isEqualTo(7);
  }

  @Test
  void getAllPetTypesOfAllPeople() {
    Function<Person, Iterable<PetType>> function = Person::getPetTypes;
    MutableSet<PetType> petTypes = this.people.flatCollect(function, Sets.mutable.empty());

    var expected =
        Sets.mutable.with(PetType.CAT, PetType.DOG, PetType.TURTLE, PetType.HAMSTER, PetType.BIRD, PetType.SNAKE);
    Assertions.assertThat(expected).isEqualTo(petTypes);
  }

  @Test
  void doAnyPeopleHaveCatsRefactor() {
    boolean peopleHaveCatsLambda = this.people.anySatisfy(person -> person.hasPet(PetType.CAT));
    Assertions.assertThat(peopleHaveCatsLambda).isTrue();

    boolean peopleHaveCatsMethodRef = this.people.anySatisfyWith(Person::hasPet, PetType.CAT);
    Assertions.assertThat(peopleHaveCatsMethodRef).isTrue();
  }

  @Test
  void doAllPeopleHaveCatsRefactor() {
    boolean peopleHaveCatsLambda = this.people.allSatisfy(person -> person.hasPet(PetType.CAT));
    Assertions.assertThat(peopleHaveCatsLambda).isFalse();

    boolean peopleHaveCatsMethodRef = this.people.allSatisfyWith(Person::hasPet, PetType.CAT);
    Assertions.assertThat(peopleHaveCatsMethodRef).isFalse();
  }

  @Test
  void getPeopleWithCatsRefactor() {
    MutableList<Person> peopleWithCatsMethodRef = this.people.selectWith(Person::hasPet, PetType.CAT);

    Assertions.assertThat(peopleWithCatsMethodRef.size()).isEqualTo(2);
  }

  @Test
  public void getPeopleWithoutCatsRefactor() {
    MutableList<Person> peopleWithoutCatsMethodRef = this.people.rejectWith(Person::hasPet, PetType.CAT);

    Assertions.assertThat(peopleWithoutCatsMethodRef.size()).isEqualTo(6);
  }
}
