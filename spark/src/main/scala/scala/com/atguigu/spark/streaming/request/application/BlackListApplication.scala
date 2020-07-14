package scala.com.atguigu.spark.streaming.request.application

import com.atguigu.summer.framework.core.TApplication

import scala.com.atguigu.spark.streaming.request.controller.BlackListController

/**
 * @Author Ding Han
 * @Description
 * @create
 * @Version 1.0
 */
object BlackListApplication extends App with TApplication{

    start("sparkStreaming") {
        val controller = new BlackListController
        controller.execute()
    }

}
