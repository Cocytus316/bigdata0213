package scala.com.atguigu.spark.core.request.controller

import com.atguigu.summer.framework.core.TController

import scala.com.atguigu.spark.core.request.service.PageflowService

/**
 * @Author Ding Han
 * @Description
 * @create
 * @Version 1.0
 */
class PageflowController extends TController{

    private val pageflowService = new PageflowService

    override def execute(): Unit = {
        val result = pageflowService.analysis()
    }

}
