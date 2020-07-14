package scala.com.atguigu.spark.core.rdd.operator.transforn.value.mapPartitions

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description RDD - 算子（方法） - mapPartitions - 小功能
 * @create 2020-06-04 11:39
 * @Version 1.0
 */
object Test {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法）- mapPartitions

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val dataRDD: RDD[Int] = sc.makeRDD(List(3,5,1,6,2,4),2)

        // 获取每个数据分区的最大值
        val rdd: RDD[Int] = dataRDD.mapPartitions(
            iter => {
                List(iter.max).iterator
            }
        )

        println(rdd.collect.mkString(","))

        sc.stop()

    }

}
