package scala.com.atguigu.spark.core.request.application

import com.atguigu.summer.framework.core.TApplication

import scala.com.atguigu.spark.core.request.controller.PageflowController

/**
 * @Author Ding Han
 * @Description  页面单跳转化率
 * @create
 * @Version 1.0
 */
object PageflowApplication extends App with TApplication{

    start( "spark" ) {
        val controller = new PageflowController
        controller.execute()
    }

}
