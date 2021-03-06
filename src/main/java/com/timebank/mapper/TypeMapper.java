package com.timebank.mapper;

import com.timebank.domain.Type;
import com.timebank.domain.TypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.TYPE
     *
     * @mbg.generated
     */
    long countByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.TYPE
     *
     * @mbg.generated
     */
    int deleteByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.TYPE
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String typeGuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.TYPE
     *
     * @mbg.generated
     */
    int insert(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.TYPE
     *
     * @mbg.generated
     */
    int insertSelective(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.TYPE
     *
     * @mbg.generated
     */
    List<Type> selectByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.TYPE
     *
     * @mbg.generated
     */
    Type selectByPrimaryKey(String typeGuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.TYPE
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.TYPE
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.TYPE
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.TYPE
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Type record);
}