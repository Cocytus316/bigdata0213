package scala.com.atguigu.spark.core.request.controller

import com.atguigu.summer.framework.core.TController

import scala.com.atguigu.spark.core.request.service.WordCountService


/**
 * @Author Ding Han
 * @Description  WordCount控制器
 * @create
 * @Version 1.0
 */
class WordCountController extends TController{

    private val wordCountService = new WordCountService

    override def execute(): Unit = {

        wordCountService.analysis()
    }
}
