package scala.com.atguigu.spark.core.rdd.operator.transforn.value.groupBy

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description  Spark - RDD - 算子（方法）- groupBy
 * @create 2020-06-04 16:10
 * @Version 1.0
 */
object GroupBy {
    def main(args: Array[String]): Unit = {
        // TODO Spark - RDD - 算子（方法）- groupBy
        //  groupBy 方法可以根据指定的规则进行分组，指定的规则的返回值就是分组的key
        //  groupBy 方法的返回值为元组
        //      元组中的第一个元素，表示分组的key
        //      元组中的第二个元素，表示相同key的数据形成的可迭代的集合
        //  groupBy方法执行完毕后，会将数据进行分组操作，但是分区是不会改变的。
        //      不同的组的数据会打乱在不同的分区中
        //  groupBy方法方法会导致数据不均匀，产生shuffle操作。如果想改变分区，可以传递参数。

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
        val sc = new SparkContext(sparkConf)

        val dataRDD:RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6),3)

        def test( i:Int ): Int = {
            i % 2
        }
        //        dataRDD.groupBy(
        //           test,2
        //        )

        //rdd.saveAsTextFile("output")
        // glom => 分区转换为一个array
        //        println(" 分组后的数据分区的数量 = " + rdd.glom().collect().length)
        //
        //        rdd.collect().foreach{
        //            case ( key, list ) => {
        //                println("key:" + key + " list【"+list.mkString(",")+"】")
        //            }
        //        }

        sc.stop()
    }
}
