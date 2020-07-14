package scala.com.atguigu.spark.core.rdd.operator.transforn.value.mapPartitionsWithIndex

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法） - mapPartitionsWithIndex - 小功能
 * @create 2020-06-04 15:00
 * @Version 1.0
 */
object Test {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - mapPartitionsWithIndex

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        // TODO 小功能：获取第二个数据分区的数据
        val dataRDD: RDD[Int] = sc.makeRDD(List(3,5,1,6,2,4),3)
        val rdd: RDD[Int] = dataRDD.mapPartitionsWithIndex(
            (index, iter) => {
                if (index == 1) {
                    iter
                } else {
                    Nil.iterator
                }
            }
        )
        rdd

        println(rdd.collect.mkString(","))

        sc.stop()



    }

}
