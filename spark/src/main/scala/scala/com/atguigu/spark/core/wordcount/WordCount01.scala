package scala.com.atguigu.spark.core.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Ding Han
 * @Description  WordCount - reduceByKey方法
 * @create 2020-06-01 21:24
 * @Version 1.0
 */
object WordCount01 {
    def main(args: Array[String]): Unit = {
        // TODO Spark - WordCount
        val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
        val sc = new SparkContext(sparkConf)

        //  读取文件数据
        val fileRDD: RDD[String] = sc.textFile("input/wordcount.txt")

        //  将读取的内容进行扁平化操作，切分单词
        val wordRDD: RDD[String] = fileRDD.flatMap(_.split(" "))

        //  分词后的数据进行结构的转换
        val mapRDD: RDD[(String, Int)] = wordRDD.map( word=>(word,1) )

        // TODO 使用reduceByKey方法
        val wordToSumRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_+_)

        // 将聚合的结果采集后打印到控制台
        val wordCountArray: Array[(String, Int)] = wordToSumRDD.collect()
        println(wordCountArray.mkString(","))

        sc.stop()
    }

}
