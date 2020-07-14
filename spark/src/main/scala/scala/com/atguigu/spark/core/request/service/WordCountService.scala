package scala.com.atguigu.spark.core.request.service

import com.atguigu.summer.framework.core.TService
import com.atguigu.summer.framework.util.EnvUtil
import org.apache.spark.rdd.RDD

import scala.com.atguigu.spark.core.request.dao.WordCountDao


/**
 * @Author Ding Han
 * @Description
 * @create
 * @Version 1.0
 */
class WordCountService extends TService{

    private val wordCountDao = new WordCountDao

    /**
     * 数据分析
     *
     * @return
     */
    override def analysis(): Array[(String, Int)] = {
        val fileRDD: RDD[String] = wordCountDao.readFile("input/1.txt")
        val wordRDD: RDD[String] = fileRDD.flatMap(_.split(" "))
        val mapRDD: RDD[(String, Int)] = wordRDD.map( word=>(word,1) )
        val wordToSumRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_+_)
        wordToSumRDD.saveAsTextFile("output")
        val wordCountArray: Array[(String, Int)] = wordToSumRDD.collect()
        wordCountArray
    }
}
