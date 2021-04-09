package spark;

import org.apache.spark.api.java.JavaRDD;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static spark.SparkContextBuilder.SPARK_CONTEXT;

public class SparkTest {

    @Test
    @Disabled
    public void testSum(){
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> distData = SPARK_CONTEXT.parallelize(data);
        Integer result = distData.reduce(Integer::sum);
        assertThat(result).isEqualTo(15);
    }

    @Test
    @Disabled
    public void testGetTextLength(){
        JavaRDD<String> lines =  SPARK_CONTEXT.textFile("src/main/resources/spark/data.txt");
        JavaRDD<Integer> lineLengths = lines.map(s -> s.length());
        int totalLength = lineLengths.reduce((a, b) -> a + b);
        assertThat(totalLength).isEqualTo(20);
    }
}
