package com.atguigu;

/**
 * @Author Ding Han
 * @Description  HBase的DDL操作
 * @create 2020-06-22 15:42
 * @Version 1.0
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.NamespaceDescriptor.Builder;
import org.apache.hadoop.hbase.NamespaceExistException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * 1.创建命名空间
 * 2.判断表是否存在
 * 3.创建表
 * 4.删除表
 */
public class HBase01_DDL {


    //声明Connection以及Admin
    private static Connection connection;
    private static Admin admin;


    //TODO 封装配置连接代码
    static {
        //1.创建配置信息，并指定连接的集群
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", "hadoop102,hadoop103,hadoop104");

        //2.创建连接器
        try {
            connection = ConnectionFactory.createConnection(configuration);
            //3.创建DDL操作对象
            admin = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //释放连接
   public static void close() throws IOException {
        admin.close();
        connection.close();
   }

    //TODO 一.创建命名空间
    public static void createNameSpace(String ns) throws IOException {

        //1.创建命名空间描述器
        Builder builder = NamespaceDescriptor.create(ns);
        NamespaceDescriptor namespaceDescriptor = builder.build();

        //2.创建命名空间
        try {
            admin.createNamespace(namespaceDescriptor);
        } catch (NamespaceExistException e) {
            System.out.println("该命名空间已存在！！！");
        }
    }

    //TODO 二.判断表是否存在
    public static boolean isTableExist(String tableName) throws IOException {
        return admin.tableExists(TableName.valueOf(tableName));
    }


    //TODO 三.创建表
    public static void createTable(String tableName,String... cfs) throws IOException {

        //1.判断是否有列族信息
       if (cfs.length <= 0) {
           System.out.println("请输入列族信息！！！");
           return;
       }

        //2.判断表是否存在
        if (isTableExist(tableName)) {
            System.out.println("该表已存在");
            return;
        }

        //3.创建表描述器Builder对象
        TableDescriptorBuilder tableDescriptorBuilder =
                TableDescriptorBuilder.newBuilder(TableName.valueOf(tableName));

        //4.循环放入列族信息
        for (String cf : cfs) {

            //5.创建列族描述器
            ColumnFamilyDescriptor columnFamilyDescriptor =
                    ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(cf)).build();
            tableDescriptorBuilder.setColumnFamily(columnFamilyDescriptor);
        }

        //6.创建表描述器
          //指定注册协处理器
        tableDescriptorBuilder.setCoprocessor("com.atguigu.HBase03_Coprocessor");
        TableDescriptor tableDescriptor = tableDescriptorBuilder.build();

        //7.创建表
        admin.createTable(tableDescriptor);
    }

    //TODO 四.删除表
    public static void dropTable(String tableName) throws IOException {

        //1.判断表是否存在
        if (!isTableExist(tableName)) {
            System.out.println(tableName + "该表不存在！！！");
            return;
        }

        //2.使表不可用
        TableName name = TableName.valueOf(tableName);
        admin.disableTable(name);

        //3.删除表操作
        admin.deleteTable(name);

    }





    public static void main(String[] args) throws IOException {
        //1.测试创建命名空间
//        createNameSpace("bigtable");

        //2.测试表是否存在
//        System.out.println(isTableExist("stu1"));

        //3.测试创建表
        createTable("stu6", "info");

        //4.测试删除表
//        dropTable("student2");

        close();

    }



}
