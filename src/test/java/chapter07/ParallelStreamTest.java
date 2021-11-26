package chapter07;

import java.time.Duration;
import java.time.Instant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParallelStreamTest {

  @Test
  void testSequentialStream(){
    Instant start = Instant.now();
    long result = ParallelStreamFactory.sequentialSum(5);
    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println(timeElapsed);
    Assertions.assertThat(result).isEqualTo(15L);
  }

  @Test
  void testParallelStream(){
    Instant start = Instant.now();
    long result = ParallelStreamFactory.parallelSum(5);
    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println(timeElapsed);
    Assertions.assertThat(result).isEqualTo(15L);
  }

  @Test
  void testRangedSumSequential(){
    Instant start = Instant.now();
    long result = ParallelStreamFactory.rangedSum(5);
    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println(timeElapsed);
    Assertions.assertThat(result).isEqualTo(15L);
  }

  @Test
  void testRangedSumParallel(){
    Instant start = Instant.now();
    long result = ParallelStreamFactory.parallelRangedSum(5);
    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println(timeElapsed);
    Assertions.assertThat(result).isEqualTo(15L);
  }

}
