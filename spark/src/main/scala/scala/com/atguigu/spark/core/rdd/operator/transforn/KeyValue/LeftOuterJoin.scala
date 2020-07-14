package scala.com.atguigu.spark.core.rdd.operator.transforn.KeyValue

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法） - leftOuterJoin
 * @create 2020-06-05 18:30
 * @Version 1.0
 */
object LeftOuterJoin {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - leftOuterJoin

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val rdd1 = sc.makeRDD(
            List(
                ("a",1), ("b", 2),("c",3),("c",4)
            )
        )
        val rdd2 = sc.makeRDD(
            List(
                ("a",4), ("b", 5), ("b", 6)
            )
        )

        // TODO leftOuterJoin
        //   类似于SQL语句的左外连接
        // TODO rightOuterJoin
        val result: RDD[(String, (Int, Option[Int]))] = rdd1.leftOuterJoin(rdd2)
        // rdd1.rightOuterJoin()

        result.collect().foreach(println)

        sc.stop
    }

}
