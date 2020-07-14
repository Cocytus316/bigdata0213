package scala.com.atguigu.spark.streaming.operation

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @Author Ding Han
 * @Description  DStream创建 - 目录采集数据
 * @create
 * @Version 1.0
 */
object SparkStreaming03_File {

    def main(args: Array[String]): Unit = {
        // TODO Spark环境
        // SparkStreaming使用核数最少是2个
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))

        // TODO 执行逻辑
        //   DStream创建 - 目录采集数据
        //   只能采集新文件
        val dirDS: DStream[String] = ssc.textFileStream("in")
        dirDS.print()

        ssc.start()

        // 等待采集器的结束
        ssc.awaitTermination()
    }

}
