package scala.com.atguigu.spark.streaming.request.controller

import com.atguigu.summer.framework.core.TController

import scala.com.atguigu.spark.streaming.request.service.BlackListService

/**
 * @Author Ding Han
 * @Description
 * @create
 * @Version 1.0
 */
class BlackListController extends TController{

    private val blackListService = new BlackListService

    override def execute(): Unit = {
        val result = blackListService.analysis()
    }

}
