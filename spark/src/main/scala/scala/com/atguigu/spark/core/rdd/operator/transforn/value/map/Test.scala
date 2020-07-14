package scala.com.atguigu.spark.core.rdd.operator.transforn.value.map

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description  小功能
 * @create 2020-06-04 11:19
 * @Version 1.0
 */
object Test {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - map
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        //TODO 小功能：从服务器日志数据apache.log中获取用户请求URL资源路径
        val fileRDD = sc.textFile("input/apache.log")

        val urlRdd: RDD[String] = fileRDD.map(
            line => {
                val datas: Array[String] = line.split(" ")
                datas(6)
            }
        )
        urlRdd.collect().foreach(println)

        sc.stop()

    }

}
