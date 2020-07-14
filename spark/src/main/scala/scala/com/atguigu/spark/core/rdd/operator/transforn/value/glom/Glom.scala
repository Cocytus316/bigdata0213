package scala.com.atguigu.spark.core.rdd.operator.transforn.value.glom

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法） - glom
 * @create 2020-06-04 15:40
 * @Version 1.0
 */
object Glom {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - glom
        //  函数说明：将同一个分区的数据直接转换为相同类型的内存数组进行处理，分区不变
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val dataRDD:RDD[Int] = sc.makeRDD(List(1,2,3,4), 2)

        val rdd: RDD[Array[Int]] = dataRDD.glom()

        rdd.foreach(
            array => {
                println(array.mkString(","))
            }
        )


        sc.stop()
    }

}
