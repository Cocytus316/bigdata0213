package scala.com.atguigu.spark.core.rdd.operator.transforn.value.map

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description  RDD - 算子（方法） - map
 * @create 2020-06-04 10:58
 * @Version 1.0
 */
object Map01 {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - map

        // TODO map
        //  def map[U: ClassTag](f: T => U): RDD[U]
        //  将处理的数据逐条进行映射转换，这里的转换可以是类型的转换，也可以是值的转换

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        // 2个分区 => 12,34
        val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

        // TODO 分区问题
        // RDD中有分区列表
        // 默认分区数量不变，数据会转换后输出
        val rdd1: RDD[Int]  = rdd.map( _ * 2 )

        rdd1.saveAsTextFile("output")

        sc.stop()
    }

}
