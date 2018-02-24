package com.datayang.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class MybatisConfig {
	
@Resource	
DataSource dataSource;


@Bean(name = "sqlSessionFactory")
public SqlSessionFactory sqlSessionFactory() {
	 SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
     bean.setDataSource(dataSource);
//     bean.setTypeAliasesPackage("hello.po");

     //添加XML目录
     ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
     try {
         //设置xml扫描路径
         bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
         return bean.getObject();
     } catch (Exception e) {
         throw new RuntimeException("sqlSessionFactory init fail",e);
     }
} 

}
