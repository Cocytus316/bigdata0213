package scala.com.atguigu.spark.core.rdd.operator.transforn.value.flatMap

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description  Spark - RDD - 算子（方法） - flatMap - 小功能
 * @create 2020-06-04 15:28
 * @Version 1.0
 */
object Test {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - flatMap
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        // TODO 小功能：将List(List(1,2),3,List(4,5))进行扁平化操作
        val dataRDD = sc.makeRDD(
            List(List(1,2),3,List(4, 5))
        )

        val rdd: RDD[Any] = dataRDD.flatMap(
            data => {
                data match {
                    case list: List[_] => list
                    case d => List(d)
                }
            }
        )

        println(rdd.collect().mkString(","))

        sc.stop()
    }

}
