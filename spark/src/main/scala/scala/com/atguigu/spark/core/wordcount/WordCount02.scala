package scala.com.atguigu.spark.core.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description  WordCount - groupBy
 * @create 2020-06-01 21:24
 * @Version 1.0
 */
object WordCount02 {
    def main(args: Array[String]): Unit = {
        // TODO Spark - WordCount
        val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
        val sc = new SparkContext(sparkConf)

        //  读取文件数据
        val fileRDD: RDD[String] = sc.textFile("input/wordcount.txt")

        //  将读取的内容进行扁平化操作，切分单词
        val wordRDD: RDD[String] = fileRDD.flatMap(_.split(" "))

        // TODO 使用groupBy+双层map()
        val groupRDD: RDD[(String, Iterable[String])] = wordRDD.groupBy(word => word)

        val mapRDD: RDD[(String, Int)] = groupRDD.map {
            case (word, iter) => {
                (word, iter.size)
            }
        }

        // 将聚合的结果采集后打印到控制台
        val wordCountArray: Array[(String, Int)] = mapRDD.collect()
        println(wordCountArray.mkString(","))

        sc.stop()
    }

}
