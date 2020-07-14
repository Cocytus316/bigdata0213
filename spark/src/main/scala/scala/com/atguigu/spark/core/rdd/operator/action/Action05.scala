package scala.com.atguigu.spark.core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark 算子 - 行动 - save相关
 * @create 2020-06-05 18:30
 * @Version 1.0
 */
object Action05 {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))

        // TODO 将数据保存到不同格式的文件中
        rdd.saveAsTextFile("output")
        rdd.saveAsObjectFile("output1")
        rdd.map((_,1)).saveAsSequenceFile("output2")

        sc.stop()
    }

}
