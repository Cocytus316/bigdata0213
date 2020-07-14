package scala.com.atguigu.spark.streaming.request.controller

import com.atguigu.summer.framework.core.TController

import scala.com.atguigu.spark.streaming.request.service.{BlackListService, MockDataService}

/**
 * @Author Ding Han
 * @Description
 * @create
 * @Version 1.0
 */
class MockDataController extends TController{

    private val mockDataService = new MockDataService

    override def execute(): Unit = {
        val result = mockDataService.analysis()
    }

}
