package scala.com.atguigu.spark.core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark 算子 - 行动 - 方法
 * @create 2020-06-05 18:30
 * @Version 1.0
 */
object Action04 {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        //val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

        // TODO sum
        //val d: Double = rdd.sum()
        //println(d)

        // TODO aggregate
        //  分区的数据通过初始值和分区内的数据进行聚合，然后再和初始值进行分区间的数据聚合
        // aggregateByKey ： 初始值只参与到分区内计算
        // aggregate ： 初始值分区内计算会参与，同时分区间计算也会参与
        //val i: Int = rdd.aggregate(10)(_+_,_+_)
        //println(i)

        // TODO fold
        //   折叠操作，aggregate的简化版操作
        //val i: Int = rdd.fold(10)(_+_)
        //println(i)

        // TODO countByKey - 7
        //    统计每种key的个数
        //
        //        val rdd: RDD[(String, Int)] = sc.makeRDD(List(
        //            ("a",4),("a",1),("a",1)
        //        ))
        //        val wordToCount: collection.Map[String, Long] = rdd.countByKey()
        //
        //        println(wordToCount)

        // TODO countByValue - 8
        val rdd: RDD[String] = sc.makeRDD(List(
            "a","a","a","hello", "hello"
        ))

        val wordToCount: collection.Map[String, Long] = rdd.countByValue()
        println(wordToCount)



        sc.stop()
    }

}
