//package com.yunguo.mapper;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//
//import com.yunguo.domain.Police;
//import com.yunguo.domain.PoliceExample;
//
//@Mapper
//public interface PoliceMapper {
//    int countByExample(PoliceExample example);
//
//    int deleteByExample(PoliceExample example);
//
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Police record);
//
//    int insertSelective(Police record);
//
//    List<Police> selectByExample(PoliceExample example);
//
//    Police selectByPrimaryKey(Integer id);
//
//    int updateByExampleSelective(@Param("record") Police record, @Param("example") PoliceExample example);
//
//    int updateByExample(@Param("record") Police record, @Param("example") PoliceExample example);
//
//    int updateByPrimaryKeySelective(Police record);
//
//    int updateByPrimaryKey(Police record);
//}