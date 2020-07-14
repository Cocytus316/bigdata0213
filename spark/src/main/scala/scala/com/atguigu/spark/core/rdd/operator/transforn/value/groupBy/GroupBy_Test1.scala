package scala.com.atguigu.spark.core.rdd.operator.transforn.value.groupBy

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法）- groupBy - 小功能2
 * @create 2020-06-04 16:10
 * @Version 1.0
 */
object GroupBy_Test1 {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法）- groupBy

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        // TODO 小功能2：从服务器日志数据apache.log中获取每个时间段访问量
        val dataRDD: RDD[String] = sc.textFile("input/apache.log")

        //获取整个时间段
        val timeRDD: RDD[String] = dataRDD.map(
            data => {
                val timeData: Array[String] = data.split(" ")
                timeData(3)
            }
        )

        //将时间按照小时进行分组
        val hourRDD: RDD[(String, Iterable[String])] = timeRDD.groupBy(
            time => {
                time.substring(11, 13)
            }
        )

        //统计每个小时内的总访问量
        val rdd: RDD[(String, Int)] = hourRDD.mapValues(
            hourData => hourData.size
        )

        rdd.collect().foreach(println)

        sc.stop()
    }
}
