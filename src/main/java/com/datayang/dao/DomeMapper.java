package com.datayang.dao;

import org.apache.ibatis.annotations.Mapper;

import com.datayang.pojo.Dome;
@Mapper
public interface DomeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dome record);

    int insertSelective(Dome record);

    Dome selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dome record);

    int updateByPrimaryKey(Dome record);
}