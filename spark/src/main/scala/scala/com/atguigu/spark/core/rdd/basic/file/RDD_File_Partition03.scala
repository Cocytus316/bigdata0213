package scala.com.atguigu.spark.core.rdd.basic.file

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description txtfile分区数据存储原理
 * @create 2020-06-02 21:33
 * @Version 1.0
 */
object RDD_File_Partition03 {
    def main(args: Array[String]): Unit = {
        // TODO Scala


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        // TODO hadoop分区是以文件为单位进行划分的。
        //      读取数据不能跨越文件

        // 1@@ => 012
        // 234 => 345

        // 12 / 3 = 4
        // 1.txt => (0, 4)
        //       => (4, 6)
        // 2.txt => (0, 4)
        //       => (4, 6)

        val fileRDD1: RDD[String] = sc.textFile("input1", 3)
        fileRDD1.saveAsTextFile("output")
        sc.stop()
    }

}
