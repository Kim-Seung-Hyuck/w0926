package dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;

public enum ConnectionUtil {
    INSTANCE;

    private DataSource dataSource;

    ConnectionUtil()  {
        try {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mariadb://192.168.00.98:3306/webdb");
            config.setUsername("webuser");
            config.setPassword("webuser");
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

            dataSource = new HikariDataSource(config);
        }catch (Exception e) {
            //bad practice
        }
    }
    public Connection getConnection()throws Exception{
        return dataSource.getConnection();
    }
}

