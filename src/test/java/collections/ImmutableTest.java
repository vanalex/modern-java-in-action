package collections;

import collections.domain.Person;
import collections.domain.PetType;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImmutableTest extends AbstractBaseTest{

  @Test
  void immutablePetCounts() {
    ImmutableBag<PetType> petTypes =
        this.people.countByEach(Person::getPetTypes).toImmutable();

    Assertions.assertEquals(2, petTypes.occurrencesOf(PetType.CAT));
    Assertions.assertEquals(2, petTypes.occurrencesOf(PetType.DOG));
    Assertions.assertEquals(2, petTypes.occurrencesOf(PetType.HAMSTER));
    Assertions.assertEquals(1, petTypes.occurrencesOf(PetType.SNAKE));
    Assertions.assertEquals(1, petTypes.occurrencesOf(PetType.TURTLE));
    Assertions.assertEquals(1, petTypes.occurrencesOf(PetType.BIRD));
  }
}
