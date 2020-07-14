package scala.com.atguigu.spark.core.accumulator

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description 不使用累加器的情况
 * @create 2020-06-08 19:25
 * @Version 1.0
 */
object Accumulator01 {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("acc")
        val sc = new SparkContext(sparkConf)

        // 8
        val rdd = sc.makeRDD(List(
            ("a", 1), ("a",2),("a", 3),("a", 4)
        ))

        // TODO 不使用累加器的情况
        //val rdd1 = rdd.reduceByKey(_+_)
        //println("sum = " + sum)
        var sum  = 0

        rdd.foreach{
            case ( word, count ) => {
                sum = sum + count
                println(sum)
            }
        }

        println("(a, "+sum+")")

        sc.stop()
    }

}
