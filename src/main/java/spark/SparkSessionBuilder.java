package spark;

import org.apache.spark.sql.SparkSession;

public class SparkSessionBuilder {

    public static final SparkSession SPARK_SESSION = build();

    public static SparkSession build(){
        return SparkSession.builder().appName("Java Spark SQL basic example").master("local").getOrCreate();
    }
}
