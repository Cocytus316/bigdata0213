package scala.com.atguigu.spark.core.rdd.operator.transforn.value.flatMap

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法） - flatMap
 * @create 2020-06-04 15:28
 * @Version 1.0
 */
object FlatMap {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - flatMap
        //  def flatMap[U: ClassTag](f: T => TraversableOnce[U]): RDD[U]
        //  函数说明：将处理的数据进行扁平化后再进行映射处理，所以算子也称之为扁平映射

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val dataRDD: RDD[List[Int]] = sc.makeRDD(List(
            List(1, 2), List(3, 4)
        ))

        val rdd: RDD[Int] = dataRDD.flatMap(
            list => list
        )

        println(rdd.collect().mkString(","))

        sc.stop()
    }

}
