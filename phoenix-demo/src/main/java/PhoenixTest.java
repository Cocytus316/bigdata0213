import org.apache.phoenix.queryserver.client.ThinClientUtil;

import java.sql.*;

/**
 * @Author Ding Han
 * @Description
 * @create 2020-06-23 15:13
 * @Version 1.0
 */
public class PhoenixTest {
    public static void main(String[] args) throws SQLException {

        //1.获取连接地址
        String connectionUrl = ThinClientUtil.getConnectionUrl("hadoop101", 8765);

        //2.创建连接
        Connection connection = DriverManager.getConnection(connectionUrl);


        //3.预编译SQL
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");

        //4.执行查询
        ResultSet resultSet = preparedStatement.executeQuery();

        //5.解析resultSet
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) +
                    "/t" + resultSet.getString(2));
        }

        //6.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
