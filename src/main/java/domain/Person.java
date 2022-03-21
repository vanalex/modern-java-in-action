package domain;

import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;

public class Person {
  private final String firstName;
  private final String lastName;
  private final MutableList<Pet> pets = Lists.mutable.empty();

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public boolean named(String name) {
    return name.equals(this.firstName + ' ' + this.lastName);
  }

  public boolean hasPet(PetType petType) {
    return this.pets.containsBy(Pet::getType, petType);
  }

  public MutableList<Pet> getPets() {
    return this.pets;
  }

  public Bag<PetType> getPetTypes() {
    return this.pets.countBy(Pet::getType);
  }

  public Person addPet(PetType petType, String name, int age) {
    this.pets.add(new Pet(petType, name, age));
    return this;
  }

  public boolean isPetPerson() {
    return this.pets.notEmpty();
  }
}
