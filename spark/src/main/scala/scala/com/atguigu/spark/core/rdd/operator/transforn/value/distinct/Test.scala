package scala.com.atguigu.spark.core.rdd.operator.transforn.value.distinct

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @Author Ding Han
 * @Description
 * @create 2020-06-05 21:08
 * @Version 1.0
 */
object Test {
    def main(args: Array[String]): Unit = {

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,1,2,4))

        //TODO 小练习：不使用distinct实现数据去重
        val rdd1: RDD[Int] = rdd.map((_,1)).reduceByKey(_+_).map(_._1)

        println(rdd1.collect().mkString(","))
    }

}
