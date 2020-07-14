package scala.com.atguigu.spark.core.rdd.operator.transforn.KeyValue

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法） - groupByKey
 * @create 2020-06-05 18:30
 * @Version 1.0
 */
object GroupByKey {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - groupByKey

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val rdd = sc.makeRDD(
            List(
                ("hello", 4), ("scala",1), ("hello",1)
            )
        )

        // TODO groupByKey : 根据数据的key进行分组
        // groupBy : 根据指定的规则对数据进行分组

        // TODO 调用groupByKey后，返回数据的类型为元组
        //   元组的第一个元素表示的是用于分组的key
        //   元组的第二个元组表示的是分组后，相同key的value的集合
        val groupRDD: RDD[(String, Iterable[Int])] = rdd.groupByKey()

        val wordToCount = groupRDD.map{
            case ( word, iter ) => {
                (word, iter.sum)
            }
        }

        println(wordToCount.collect().mkString(","))

        sc.stop
    }

}
