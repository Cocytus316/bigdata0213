package scala.com.atguigu.spark.core.rdd.operator.transforn.KeyValue

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法） - join
 * @create 2020-06-05 18:30
 * @Version 1.0
 */
object Join {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - join

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val rdd1 = sc.makeRDD(
            List(
                ("a",1), ("b", 2),("a",3),("c",1)
            )
        )
        val rdd2 = sc.makeRDD(
            List(
                ("a",6),("a",4), ("b", 5)
            )
        )

        // TODO join方法可以将两个rdd中相同的key的value连接在一起
        //  join方法性能不太高，能不用尽量不要用。
        val result: RDD[(String, (Int, Int))] = rdd1.join(rdd2)

//        val result: RDD[(String, (Int, Option[Int]))] = rdd1.leftOuterJoin(rdd2)

        //println(result.collect().mkString(","))
        result.collect().foreach(println)

        sc.stop
    }

}
