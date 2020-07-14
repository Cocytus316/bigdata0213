package scala.com.atguigu.spark.streaming.operation

import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @Author Ding Han
 * @Description  DStream创建 - Kafka采集数据 - Kafka 0-10 Direct模式
 * @create
 * @Version 1.0
 */
object SparkStreaming05_Kafka {

    def main(args: Array[String]): Unit = {
        // TODO Spark环境
        // SparkStreaming使用核数最少是2个
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))

        // TODO 使用SparkStreaming读取Kafka的数据

        // Kafka的配置信息
        val kafkaPara: Map[String, Object] = Map[String, Object](
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> "hadoop102:9092,hadoop103:9092,hadoop104:9092",
            ConsumerConfig.GROUP_ID_CONFIG -> "atguigu",
            "key.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer",
            "value.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer"
        )

        val kafkaDStream: InputDStream[ConsumerRecord[String, String]] =
            KafkaUtils.createDirectStream[String, String](
                ssc,
                LocationStrategies.PreferConsistent,
                ConsumerStrategies.Subscribe[String, String](Set("atguigu"), kafkaPara)
            )

        val valueDStream: DStream[String] = kafkaDStream.map(record => record.value())

        valueDStream.flatMap(_.split(" "))
          .map((_, 1))
          .reduceByKey(_ + _)
          .print()


        ssc.start()
        // 等待采集器的结束
        ssc.awaitTermination()
    }

}
