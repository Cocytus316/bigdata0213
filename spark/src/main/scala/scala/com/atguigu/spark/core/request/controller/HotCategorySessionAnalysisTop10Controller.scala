package scala.com.atguigu.spark.core.request.controller

import com.atguigu.summer.framework.core.TController

import scala.com.atguigu.spark.core.request.bean
import scala.com.atguigu.spark.core.request.service.{HotCategoryAnalysisTop10Service, HotCategorySessionAnalysisTop10Service}


/**
 * @Author Ding Han
 * @Description  WordCount控制器
 * @create
 * @Version 1.0
 */
class HotCategorySessionAnalysisTop10Controller extends TController{

    private val hotCategoryAnalysisTop10Service = new HotCategoryAnalysisTop10Service
    private val hotCategorySessionAnalysisTop10Service = new HotCategorySessionAnalysisTop10Service

    override def execute(): Unit = {
        val categories: List[bean.HotCategory] = hotCategoryAnalysisTop10Service.analysis()
        val result = hotCategorySessionAnalysisTop10Service.analysis(categories)
        result.foreach(println)
    }
}
