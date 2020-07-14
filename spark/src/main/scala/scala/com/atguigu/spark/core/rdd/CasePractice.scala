package scala.com.atguigu.spark.core.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description 案例实操
 * @create 2020-06-06 11:10
 * @Version 1.0
 */
object CasePractice {
    def main(args: Array[String]): Unit = {
        // TODO 需求说明：统计出每一个省份每个广告被点击数量排行的Top3

        val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        sc.textFile("input/agent.log")




    }

}
