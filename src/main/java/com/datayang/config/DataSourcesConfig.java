package com.datayang.config;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourcesConfig {
	 public static final String DB_NAME = "mySqlite.db";
	 public static String DB_PATH = DataSourcesConfig.class.getClassLoader().getResource("").getPath() + DB_NAME;
	 public static String DB_SRC = "jdbc:sqlite:" + DB_PATH;
	
	@Primary //默认数据源
    @Bean(name = "dataSource",destroyMethod = "close")
    public DruidDataSource Construction() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        DB_PATH = System.getProperty("user.dir") + "/" + DB_NAME;
        DB_SRC = "jdbc:sqlite://" + DB_PATH;
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl(DB_SRC);
        dataSource.setDbType("h2");
        //配置最大连接
        dataSource.setMaxActive(20);
        //配置初始连接
        dataSource.setInitialSize(1);
        //配置最小连接
        dataSource.setMinIdle(1);
//        //连接等待超时时间
        dataSource.setMaxWait(60000);
//        //间隔多久进行检测,关闭空闲连接
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
//        //一个连接最小生存时间
        dataSource.setMinEvictableIdleTimeMillis(300000);
//        //用来检测是否有效的sql
        dataSource.setValidationQuery("select 1");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setFilters("stat,wall,log4j");
        try {
            dataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException("druid datasource init fail");
        }
        return dataSource;
    }
}
