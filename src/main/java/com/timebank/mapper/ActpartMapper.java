package com.timebank.mapper;

import com.timebank.domain.Actpart;
import com.timebank.domain.ActpartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActpartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ACTPART
     *
     * @mbg.generated
     */
    long countByExample(ActpartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ACTPART
     *
     * @mbg.generated
     */
    int deleteByExample(ActpartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ACTPART
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String actpartGuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ACTPART
     *
     * @mbg.generated
     */
    int insert(Actpart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ACTPART
     *
     * @mbg.generated
     */
    int insertSelective(Actpart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ACTPART
     *
     * @mbg.generated
     */
    List<Actpart> selectByExample(ActpartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ACTPART
     *
     * @mbg.generated
     */
    Actpart selectByPrimaryKey(String actpartGuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ACTPART
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Actpart record, @Param("example") ActpartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ACTPART
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Actpart record, @Param("example") ActpartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ACTPART
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Actpart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.ACTPART
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Actpart record);
}