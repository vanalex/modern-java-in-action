package streams.streams;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BinaryOperator;

import static org.assertj.core.api.Assertions.assertThat;
import static streams.streams.MaxAndMinTestFixture.buildEmployeeList;

class MaxAndMinTest {

    @Test
    void testMaximumSalaryMaxBy(){
        Employee result = buildEmployeeList().stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(Employee::getSalary))).orElse(new Employee());
        assertThat(result.getSalary()).isEqualTo(1_000_000);
    }

    @Test
    void testMaximumSalaryMax(){
        Employee result = buildEmployeeList().stream()
                .max(Comparator.comparingInt(Employee::getSalary)).orElse(new Employee());
        assertThat(result.getSalary()).isEqualTo(1_000_000);
    }
}
