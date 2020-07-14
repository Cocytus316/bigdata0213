package com.atguigu;

/**
 * @Author Ding Han
 * @Description  HBase的DML API操作
 * @create 2020-06-22 19:12
 * @Version 1.0
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Iterator;

/**
 * 1.新增和修改数据
 * 2.单条数据查询
 * 3.批量数据查询
 * 4.删除数据
 */
public class HBase02_DML {
    //声明Connection以及Admin
    private static Connection connection;

    //TODO 封装配置连接代码
    static {
        //1.创建配置信息，并指定连接的集群
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", "hadoop102,hadoop103,hadoop104");

        //2.创建连接器
        try {
            connection = ConnectionFactory.createConnection(configuration);
            //3.创建DDL操作对象
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //释放连接
    public static void close() throws IOException {
        connection.close();
    }

    //TODO 一.新增和修改数据 put
    public static void putData(String tableName,String rowKey,String cf,String cn,String value) throws IOException {

        //1.获取DML的Table对象
        Table table = connection.getTable(TableName.valueOf(tableName));

        //2.创建Put对象
        Put put = new Put(Bytes.toBytes(rowKey));

        //3.给Put对象添加数据
        put.addColumn(Bytes.toBytes(cf), Bytes.toBytes(cn), Bytes.toBytes(value));

        //4.执行插入数据的操作
        table.put(put);

        //5.释放资源
        table.close();
    }

    //TODO 二.单条数据查询 get
    public static void getData(String tableName,String rowKey,String cf,String cn) throws IOException {

        //1.获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));

        //2.创建get对象
        Get get = new Get(Bytes.toBytes(rowKey));

        //3.指定列族/列
        get.addFamily(Bytes.toBytes(cf));
        //指定列族：列
        get.addColumn(Bytes.toBytes(cf), Bytes.toBytes(cn));

        //4.查询数据
        Result result = table.get(get);

        //5.解析result
        for (Cell cell : result.rawCells()) {
            System.out.println("CF:" + Bytes.toString(CellUtil.cloneFamily(cell)) +
                    ",CN:" + Bytes.toString(CellUtil.cloneQualifier(cell)) +
                    ",Value:" + Bytes.toString(CellUtil.cloneValue(cell)));
        }

        //6.释放资源
        table.close();
    }

    //TODO 三.扫描数据 scan
    public static void scanTable(String tableName) throws IOException {

        //1.获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));

        //2.获取Scan对象
        Scan scan = new Scan();

        //3.扫描全表
        ResultScanner results = table.getScanner(scan);

        //4.解析results
        Iterator<Result> iterator = results.iterator();
        while (iterator.hasNext()) {
            Result result = iterator.next();
            for (Cell cell : result.rawCells()) {
                System.out.println("CF:" + Bytes.toString(CellUtil.cloneFamily(cell)) +
                        ",CN:" + Bytes.toString(CellUtil.cloneQualifier(cell)) +
                        ",Value:" + Bytes.toString(CellUtil.cloneValue(cell)));
            }
        }

        //5.释放资源
        table.close();
    }

    //TODO 四.删除数据
    //   DeleteFamily:执行删除整个RowKey数据添加的标记 ；作用范围：当前列族<=标记时间戳的数据
    //   DeleteColumn:执行指定到列族的数据添加的标记（代"s"的方法） ；作用范围：当前列<=标记时间戳的数据
    //   Delete:执行指定到列族的数据添加的标记 ；作用范围：只作用标记时间戳的范围
    public static void deleteData(String tableName,String rowKey,String cf,String cn) throws IOException {

        //1.获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));

        //2.创建Delete对象
        Delete delete = new Delete(Bytes.toBytes(rowKey));

        //3.执行删除操作
        table.delete(delete);

        //指定列族删除数据
        delete.addFamily(Bytes.toBytes(cf));
        //指定列族:列 删除数据
        delete.addColumn(Bytes.toBytes(cf), Bytes.toBytes(cn));
        //指定列族:列 删除所有版本的数据
        // TODO addColumns推荐使用
        delete.addColumns(Bytes.toBytes(cf), Bytes.toBytes(cn));




        //4.释放资源
        table.close();

    }





    public static void main(String[] args) throws IOException {

        //1.测试插入数据
//        putData("stu4", "1001", "info", "name", "hanhan");

        //2.测试get方式获取数据
//        getData("stu4", "1001", "info", "name");

        //3.测试扫描全表
//        scanTable("stu4");

        //4.测试删除
        deleteData("stu4", "1111", "info2", "aa");

        close();
    }



}
