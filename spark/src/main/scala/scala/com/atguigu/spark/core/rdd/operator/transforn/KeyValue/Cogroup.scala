package scala.com.atguigu.spark.core.rdd.operator.transforn.KeyValue

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法） - cogroup
 * @create 2020-06-05 18:30
 * @Version 1.0
 */
object Cogroup {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - cogroup

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val rdd1 = sc.makeRDD(
            List(
                ("a",1), ("b", 2),("a",3)
            )
        )
        val rdd2 = sc.makeRDD(
            List(
                ("a",6),("a",4), ("b", 5)
            )
        )

        // TODO 在类型为(K,V)和(K,W)的RDD上调用，返回一个(K,(Iterable<V>,Iterable<W>))类型的RDD
        val result: RDD[(String, (Iterable[Int], Iterable[Int]))] = rdd1.cogroup(rdd2)

        result.collect().foreach(println)

        sc.stop
    }

}
