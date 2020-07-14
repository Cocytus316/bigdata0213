package scala.com.atguigu.spark.core.rdd.operator.transforn.value.groupBy

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法）- groupBy - 小功能1
 * @create 2020-06-04 16:10
 * @Version 1.0
 */
object GroupBy_Test {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法）- groupBy

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        // TODO 小功能1：将List("Hello", "hive", "hbase", "Hadoop")根据单词首写字母进行分组
        val dataRDD = sc.makeRDD(List("Hello", "hive", "hbase", "Hadoop"), 2)

        val rdd: RDD[(Char, Iterable[String])] = dataRDD.groupBy(
            word => {
                word(0)
            }
        )

        rdd.collect().foreach(println)

        sc.stop()
    }
}
