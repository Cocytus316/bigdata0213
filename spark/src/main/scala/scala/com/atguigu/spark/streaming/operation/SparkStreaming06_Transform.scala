package scala.com.atguigu.spark.streaming.operation

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @Author Ding Han
 * @Description  DStream转换 - 无状态转化操作
 * @create
 * @Version 1.0
 */
object SparkStreaming06_Transform {

    def main(args: Array[String]): Unit = {
        // TODO Spark环境
        // SparkStreaming使用核数最少是2个
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))

        val ds = ssc.socketTextStream("hadoop102", 9999)
        // TODO 转换
        // Code Driver (1) - 执行一次
        val newDS: DStream[String] = ds.transform(
            rdd=>{
                // Code Driver(N) - 执行多次
                rdd.map(
                    data => {
                        // Code Executor(N) - 执行多次
                        data * 2
                    }
                )
            }
        )

        // Code : Driver(1) - 执行一次
        val newDS1 = ds.map(
            data => {
                // Code : Executor(N) - 执行多次
                data * 2
            }
        )

        newDS1.print()

        ssc.start()
        // 等待采集器的结束
        ssc.awaitTermination()
    }

}
