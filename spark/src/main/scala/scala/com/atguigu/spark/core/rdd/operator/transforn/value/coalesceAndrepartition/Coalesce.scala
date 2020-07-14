package scala.com.atguigu.spark.core.rdd.operator.transforn.value.coalesceAndrepartition

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法） - coalesce
 * @create 2020-06-05 18:30
 * @Version 1.0
 */
object Coalesce {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - coalesce


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        // TODO  Coalesce
        //  根据数据量缩减分区，用于大数据集过滤后，提高小数据集的执行效率
        val rdd: RDD[Int] = sc.makeRDD(List(1,1,1,2,2,2), 6)

        // [1,1,1], [2,2,2]
        // [],[2,2,2]
        //val filterRDD = rdd.filter(num=>num%2==0)

        // 多 => 少
        // TODO 当数据过滤后，发现数据不够均匀，那么可以缩减分区
        //        val coalesceRDD = filterRDD.coalesce(1)
        //        coalesceRDD.saveAsTextFile("output")

        // TODO 如果发现数据分区不合理，也可以缩减分区
        val coalesceRDD = rdd.coalesce(2)
        coalesceRDD.saveAsTextFile("output")

        sc.stop()
    }

}
