package scala.com.atguigu.spark.core.rdd.operator.transforn.value.sortBy

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法） - sortBy
 * @create 2020-06-05 18:30
 * @Version 1.0
 */
object SortBy {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - sortBy


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val rdd: RDD[Int] = sc.makeRDD(List(1,4,2,3))

        // TODO sortBy

        // 默认排序规则为 升序
        // sortBy可以通过传递第二个参数改变排序的方式
        // sortBy可以设定第三个参数改变分区。
        val sortRDD: RDD[Int] = rdd.sortBy(num=>num, false)

        println(sortRDD.collect().mkString(","))

        sc.stop()
    }

}
