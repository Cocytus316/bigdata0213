package scala.com.atguigu.spark.core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark 算子 - 行动 - 简单方法
 * @create 2020-06-05 18:30
 * @Version 1.0
 */
object Action02 {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))

        // TODO reduce :简化，规约
        //   聚集RDD中的所有元素，先聚合分区内数据，再聚合分区间数据
        //val i: Int = rdd.reduce(_+_)

        // TODO collect :采集数据
        //  在驱动程序中，以数组Array的形式返回数据集的所有元素
        //  collect方法会将所有分区计算的结果拉取到当前节点Driver的内存中，可能会出现内存溢出
        //val array: Array[Int] = rdd.collect()

        // TODO count
        //   返回RDD中元素的个数
        val cnt: Long = rdd.count()

        // TODO first
        //    返回RDD中的第一个元素
        val f = rdd.first()

        // TODO take
        //    返回一个由RDD的前n个元素组成的数组
        val subarray: Array[Int] = rdd.take(3)

        println(cnt)

        sc.stop()


    }

}
