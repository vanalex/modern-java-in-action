package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkContextBuilder {

    public static final SparkConf SPARK_CONFIG = new SparkConf().setAppName("appName").setMaster("local");
    public static final JavaSparkContext SPARK_CONTEXT = build();

    public static JavaSparkContext build(){
        return new JavaSparkContext(SPARK_CONFIG);
    }
}
