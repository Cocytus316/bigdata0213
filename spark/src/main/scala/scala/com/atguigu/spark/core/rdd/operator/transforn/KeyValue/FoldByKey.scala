package scala.com.atguigu.spark.core.rdd.operator.transforn.KeyValue

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法） - foldByKey
 * @create 2020-06-05 18:30
 * @Version 1.0
 */
object FoldByKey {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - foldByKey

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val rdd = sc.makeRDD(
            List(
                ("a", 1), ("a",2), ("c",3),
                ("b", 4), ("c",5), ("c",6)
            )
            ,2
        )

        // TODO 如果分区内计算规则和分区间的计算规则相同都是求和，那么可以计算wordcount
//                val result: RDD[(String, Int)] = rdd.aggregateByKey(0)(
//                    (x, y) => x + y,
//                    (x, y) => x + y
//                )
//                val result = rdd.aggregateByKey(0)(_+_, _+_)
//                println(result.collect().mkString(","))

        // TODO 如果分区内计算规则和分区间计算规则相同，那么可以将aggregateByKey简化为
        //      另外一个方法foldByKey
        val result = rdd.foldByKey(0)(_+_)
        println(result.collect().mkString(","))

        // scala
        // List().reduce(_+_)
        // List().fold(0)(_+_)

        // spark
        // rdd.reduceByKey(_+_)
        // rdd.foldByKey(0)(_+_)

        sc.stop
    }

}
