package scala.com.atguigu.spark.core.rdd.operator.transforn.value.mapPartitionsWithIndex

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description Spark - RDD - 算子（方法） - mapPartitionsWithIndex
 * @create 2020-06-04 15:00
 * @Version 1.0
 */
object MapPartitionsWithIndex {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法） - mapPartitionsWithIndex
        // 函数签名
//        def mapPartitionsWithIndex[U: ClassTag](
//            f: (Int, Iterator[T]) => Iterator[U],
//            preservesPartitioning: Boolean = false): RDD[U]
//        )
        // TODO 函数说明
        //  将待处理的数据以分区为单位发送到计算节点进行处理，这里的处理是指可以进行任意的处理，
        //  哪怕是过滤数据，在处理时同时可以获取当前分区索引

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        // 获取每个分区最大值以及分区号
        val dataRDD: RDD[Int] = sc.makeRDD(List(3,5,1,6,2,4),3)
        val rdd = dataRDD.mapPartitionsWithIndex(
            (index, iter) => {
                List((index, iter.max)).iterator
            }
        )

        println(rdd.collect.mkString(","))

        sc.stop()



    }

}
