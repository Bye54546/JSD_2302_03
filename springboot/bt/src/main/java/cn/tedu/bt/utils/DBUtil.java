package cn.tedu.bt.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库工具类,用于管理数据库连接
 */
public class DBUtil {
    /*
        阿里提供的连接池
        数据库连接池主要有两个作用:
        1:控制连接数量
        2:重用连接
     */
    private static DruidDataSource ds;
    static{
        initDataSource();//初始化连接池
    }
    private static void initDataSource(){
        ds = new DruidDataSource();
        ds.setUsername("root");//设置数据库用户名
        ds.setPassword("9999");//数据库密码
        ds.setUrl("jdbc:mysql://localhost:3306/birddb?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");//设置数据库位置
        ds.setInitialSize(5);//连接池的初始容量,创建后内部默认5条连接
        ds.setMaxActive(50);//设置最大连接数
    }

    /**
     * 获取一个数据库连接
     * @return
     */
    public static Connection getConnection() throws SQLException {
        /*
            当我们调用连接池的getConnection()时,返回的连接是连接池提供的连接,内部封装着
            真是的数据库连接.
            当我们调用getConnection()时,连接池会将其中的一个空闲连接返回,返回前会设置它的
            转台为被租借.此时其它线程就不能再获取到这个连接了.
            当我们使用外该连接后会调用该连接的close()方法,此时该方法并非将实际的数据库连接关闭,
            而是将该连接的状态改为空闲,此时其它线程就可以获取到该连接了.
         */
        return ds.getConnection();
    }
}
