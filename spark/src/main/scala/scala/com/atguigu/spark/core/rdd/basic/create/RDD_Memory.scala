package scala.com.atguigu.spark.core.rdd.basic.create

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description 从内存中创建RDD
 * @create 2020-06-02 21:33
 * @Version 1.0
 */
object RDD_Memory {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
        val sc = new SparkContext(sparkConf)

        // TODO  Spark - 从内存中创建RDD
        // 1. parallelize : 并行
        val list = List(1,2,3,4)
        val rdd: RDD[Int] = sc.parallelize(list)
        println(rdd.collect().mkString(","))

        // TODO makeRDD的底层代码其实就是调用了parallelize方法
        val rdd1: RDD[Int] = sc.makeRDD(list)
        println(rdd1.collect().mkString(","))

        sc.stop()
    }

}
