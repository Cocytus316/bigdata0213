package scala.com.atguigu.spark.streaming.operation

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

/**
 * @Author Ding Han
 * @Description  DStream创建 - RDD队列
 * @create
 * @Version 1.0
 */
object SparkStreaming02_Queue {

    def main(args: Array[String]): Unit = {
        // TODO Spark环境
        // SparkStreaming使用核数最少是2个
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))

        // TODO 执行逻辑
        val queue = new mutable.Queue[RDD[String]]()
        val queueDS: InputDStream[String] = ssc.queueStream(queue)

        queueDS.print()
        ssc.start()

        for ( i <- 1 to 5 ) {
            val rdd = ssc.sparkContext.makeRDD(List(i.toString))
            queue.enqueue(rdd)
            Thread.sleep(1000)
        }


        // 等待采集器的结束
        ssc.awaitTermination()
    }

}
