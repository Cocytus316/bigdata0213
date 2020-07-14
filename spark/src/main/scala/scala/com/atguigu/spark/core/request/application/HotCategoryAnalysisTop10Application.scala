package scala.com.atguigu.spark.core.request.application

import com.atguigu.summer.framework.core.TApplication

import scala.com.atguigu.spark.core.request.controller.HotCategoryAnalysisTop10Controller


/**
 * @Author Ding Han
 * @Description 热门品类前10应用程序
 * @create
 * @Version 1.0
 */
object HotCategoryAnalysisTop10Application extends App with TApplication{

    start("spark") {

        // TODO 热门品类前10应用程序

        val controller = new HotCategoryAnalysisTop10Controller
        controller.execute()
    }


    
}
