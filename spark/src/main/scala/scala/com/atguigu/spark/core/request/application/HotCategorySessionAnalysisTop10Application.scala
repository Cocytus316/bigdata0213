package scala.com.atguigu.spark.core.request.application

import com.atguigu.summer.framework.core.TApplication

import scala.com.atguigu.spark.core.request.controller.{HotCategoryAnalysisTop10Controller, HotCategorySessionAnalysisTop10Controller}


/**
 * @Author Ding Han
 * @Description 热门品类中每个品类的Top10活跃Session统计
 * @create
 * @Version 1.0
 */
object HotCategorySessionAnalysisTop10Application extends App with TApplication{

    start("spark") {

        // TODO 热门品类中每个品类的Top10活跃Session统计

        val controller = new HotCategorySessionAnalysisTop10Controller
        controller.execute()
    }


    
}
