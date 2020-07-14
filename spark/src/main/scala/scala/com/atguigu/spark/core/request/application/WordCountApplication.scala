package scala.com.atguigu.spark.core.request.application
import com.atguigu.summer.framework.core.TApplication

import scala.com.atguigu.spark.core.request.controller.WordCountController

/**
 * @Author Ding Han
 * @Description
 * @create
 * @Version 1.0
 */
object WordCountApplication extends App with TApplication{

    start("spark") {

        val controller = new WordCountController
        controller.execute()
    }


    
}
