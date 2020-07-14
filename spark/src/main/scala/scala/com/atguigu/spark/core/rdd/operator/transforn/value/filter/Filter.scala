package scala.com.atguigu.spark.core.rdd.operator.transforn.value.filter

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法）- filter
 * @create 2020-06-04 16:40
 * @Version 1.0
 */
object Filter {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法）- filter
        //  根据指定的规则对数据进行筛选过滤，满足条件的数据保留，不满足的数据丢弃
        //  当数据进行筛选过滤后，分区不变，但是分区内的数据可能不均衡，生产环境下，可能会出现数据倾斜

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val dataRDD:RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6),3)

        val rdd: RDD[Int] = dataRDD.filter(
            num => {
                num % 2 == 0
            }
        )
        rdd.collect().foreach(println)




        sc.stop()

    }
}
