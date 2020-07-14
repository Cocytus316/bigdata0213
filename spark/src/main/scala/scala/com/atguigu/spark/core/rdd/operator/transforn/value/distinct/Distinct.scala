package scala.com.atguigu.spark.core.rdd.operator.transforn.value.distinct

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法） - distinct
 * @create 2020-06-05 18:30
 * @Version 1.0
 */
object Distinct {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - distinct


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,1,2,4))

        //        rdd.groupBy(
        //            (num:Int)=>num,2
        //        )

        // TODO distinct 去重
        val rdd1: RDD[Int] = rdd.distinct()
        // distinct可以改变分区的数量
        val rdd2: RDD[Int] = rdd.distinct(2)

        println(rdd1.collect().mkString(","))
        println(rdd2.collect().mkString(","))

        sc.stop()
    }

}
