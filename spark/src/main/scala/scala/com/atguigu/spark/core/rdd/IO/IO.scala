package scala.com.atguigu.spark.core.rdd.IO

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description
 * @create 2020-06-08 19:13
 * @Version 1.0
 */
object IO {
    def main(args: Array[String]): Unit = {

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val rdd: RDD[String] = sc.textFile("input/1.txt")
        rdd.saveAsTextFile("output")

        rdd.saveAsObjectFile("output1")
        val objectRDD: RDD[String] = sc.objectFile[String]("output1")

        rdd.map((_, 1)).saveAsSequenceFile("output2")
        val seqRDD: RDD[(String, Int)] = sc.sequenceFile[String, Int]("output2")

        sc.stop()
    }
}
