package scala.com.atguigu.spark.core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark 算子 - 行动 - takeOrdered
 * @create 2020-06-05 18:30
 * @Version 1.0
 */
object Action03 {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val rdd: RDD[Int] = sc.makeRDD(List(2,1,4,3))

        // TODO takeOrdered
        //    返回该RDD排序后的前n个元素组成的数组
        // 1,2,3,4 => 1,2,3
        // 2,1,4 => 1,2,4
        val ints: Array[Int] = rdd.takeOrdered(3)
        println(ints.mkString(","))

        sc.stop()
    }

}
