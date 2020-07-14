package scala.com.atguigu.spark.streaming.request.application

import com.atguigu.summer.framework.core.TApplication

import scala.com.atguigu.spark.streaming.request.controller.{BlackListController, MockDataController}

/**
 * @Author Ding Han
 * @Description
 * @create
 * @Version 1.0
 */
object MockDataApplication extends App with TApplication{

    start("sparkStreaming") {
        val controller = new MockDataController
        controller.execute()
    }

}
