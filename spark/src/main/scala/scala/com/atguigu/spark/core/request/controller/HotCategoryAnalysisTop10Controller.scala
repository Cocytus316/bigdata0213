package scala.com.atguigu.spark.core.request.controller

import com.atguigu.summer.framework.core.TController

import scala.com.atguigu.spark.core.request.service.{HotCategoryAnalysisTop10Service, WordCountService}


/**
 * @Author Ding Han
 * @Description  WordCount控制器
 * @create
 * @Version 1.0
 */
class HotCategoryAnalysisTop10Controller extends TController{

    private val hotCategoryAnalysisTop10Service = new HotCategoryAnalysisTop10Service

    override def execute(): Unit = {
        val result = hotCategoryAnalysisTop10Service.analysis()
        result.foreach(println)
    }
}
