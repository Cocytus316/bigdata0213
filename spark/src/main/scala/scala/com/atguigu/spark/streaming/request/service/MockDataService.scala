package scala.com.atguigu.spark.streaming.request.service

import com.atguigu.summer.framework.core.TService

import scala.com.atguigu.spark.streaming.request.dao.MockDataDao

/**
 * @Author Ding Han
 * @Description
 * @create
 * @Version 1.0
 */
class MockDataService extends TService{

    private val mockDataDao = new MockDataDao

    /**
     * 数据分析
     *
     * @return
     */
    override def analysis() = {
        // TODO 生成模拟数据
        //import mockDataDao._
        val datas  = mockDataDao.genMockData _
        //val a = Seq("a")

        // TODO 向Kafka中发送数据
        mockDataDao.writeToKakfa(datas)


    }


}
