package scala.com.atguigu.spark.core.rdd.operator.transforn.value.filter

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法）- filter  - 小功能
 * @create 2020-06-04 16:40
 * @Version 1.0
 */
object Filter_Test {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法）- filter

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        //TODO 小功能：从服务器日志数据apache.log中获取2015年5月17日的请求路径
        val dataRDD: RDD[String] = sc.textFile("input/apache.log")

        //获取整个时间段
        val timeRDD: RDD[String] = dataRDD.map(
            data => {
                val timeData: Array[String] = data.split(" ")
                timeData(3)
            }
        )

        //过滤得到2015年5月17日的请求路径
        val rdd: RDD[String] = timeRDD.filter(
            time => {
                val date: String = time.substring(0, 10)
                date == "17/05/2015"
            }
        )

        rdd.collect().foreach(println)

        sc.stop()

    }
}
