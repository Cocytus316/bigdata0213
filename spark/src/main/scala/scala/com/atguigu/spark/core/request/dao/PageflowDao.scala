package scala.com.atguigu.spark.core.request.dao

import com.atguigu.summer.framework.core.TDao
import org.apache.spark.rdd.RDD

import scala.com.atguigu.spark.core.request.bean.UserVisitAction

/**
 * @Author Ding Han
 * @Description
 * @create
 * @Version 1.0
 */
class PageflowDao extends TDao{

    def getUserVisitAction( path:String ) = {
        val rdd: RDD[String] = readFile(path)
        rdd.map(
            line => {
                val datas = line.split("_")
                UserVisitAction(
                    datas(0),
                    datas(1).toLong,
                    datas(2),
                    datas(3).toLong,
                    datas(4),
                    datas(5),
                    datas(6).toLong,
                    datas(7).toLong,
                    datas(8),
                    datas(9),
                    datas(10),
                    datas(11),
                    datas(12).toLong
                )
            }
        )
    }

}
