package collections;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.jupiter.api.Test;

public class MutableTest {

  @Test
  void test(){
    MutableList<String> mutableList = Lists.mutable.empty();
    Assertions.assertThat(mutableList).isEmpty();
    mutableList.add("One");
    mutableList.add("One");
    mutableList.add("Two");
    Assertions.assertThat(mutableList.size()).isEqualTo(3);

    MutableList<String> mutableList2 = Lists.mutable.of("One", "Two", "Three");
    Assertions.assertThat(mutableList2.size()).isEqualTo(3);
  }

  @Test
  void testFastList(){
    MutableList<Integer> list = FastList.newListWith(1, 8, 5, 41, 31, 17, 23, 38);
    boolean result = list.allSatisfy(Predicates.greaterThan(0));
    Assertions.assertThat(result).isTrue();
  }
}
