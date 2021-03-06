package com.timebank.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Activity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.ACTIVITY.ACTIVITY_GUID
     *
     * @mbg.generated
     */
    private String activityGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.ACTIVITY.ACTIVITY_TITLE
     *
     * @mbg.generated
     */
    private String activityTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.ACTIVITY.ACTIVITY_DESP
     *
     * @mbg.generated
     */
    private String activityDesp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.ACTIVITY.ACTIVITY_COMMENT
     *
     * @mbg.generated
     */
    private String activityComment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.ACTIVITY.ACTIVITY_START_TIME
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityStartTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.ACTIVITY.ACTIVITY_END_TIME
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityEndTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.ACTIVITY.ACTIVITY_PROCESS_USER_GUID
     *
     * @mbg.generated
     */
    private String activityProcessUserGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.ACTIVITY.ACTIVITY_ADDRESS
     *
     * @mbg.generated
     */
    private String activityAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.ACTIVITY.ACTIVITY_FROM_COMM_GUID
     *
     * @mbg.generated
     */
    private String activityFromCommGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.ACTIVITY.ACTIVITY_TYPE_PROCESS_STATUS
     *
     * @mbg.generated
     */
    private String activityTypeProcessStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.ACTIVITY.ACTIVITY_TARGETS_USER_GUID
     *
     * @mbg.generated
     */
    private String activityTargetsUserGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.ACTIVITY.ACTIVITY_PERSON_NUM
     *
     * @mbg.generated
     */
    private Integer activityPersonNum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.ACTIVITY.ACTIVITY_GUID
     *
     * @return the value of dbo.ACTIVITY.ACTIVITY_GUID
     *
     * @mbg.generated
     */
    public String getActivityGuid() {
        return activityGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.ACTIVITY.ACTIVITY_GUID
     *
     * @param activityGuid the value for dbo.ACTIVITY.ACTIVITY_GUID
     *
     * @mbg.generated
     */
    public void setActivityGuid(String activityGuid) {
        this.activityGuid = activityGuid == null ? null : activityGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.ACTIVITY.ACTIVITY_TITLE
     *
     * @return the value of dbo.ACTIVITY.ACTIVITY_TITLE
     *
     * @mbg.generated
     */
    public String getActivityTitle() {
        return activityTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.ACTIVITY.ACTIVITY_TITLE
     *
     * @param activityTitle the value for dbo.ACTIVITY.ACTIVITY_TITLE
     *
     * @mbg.generated
     */
    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle == null ? null : activityTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.ACTIVITY.ACTIVITY_DESP
     *
     * @return the value of dbo.ACTIVITY.ACTIVITY_DESP
     *
     * @mbg.generated
     */
    public String getActivityDesp() {
        return activityDesp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.ACTIVITY.ACTIVITY_DESP
     *
     * @param activityDesp the value for dbo.ACTIVITY.ACTIVITY_DESP
     *
     * @mbg.generated
     */
    public void setActivityDesp(String activityDesp) {
        this.activityDesp = activityDesp == null ? null : activityDesp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.ACTIVITY.ACTIVITY_COMMENT
     *
     * @return the value of dbo.ACTIVITY.ACTIVITY_COMMENT
     *
     * @mbg.generated
     */
    public String getActivityComment() {
        return activityComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.ACTIVITY.ACTIVITY_COMMENT
     *
     * @param activityComment the value for dbo.ACTIVITY.ACTIVITY_COMMENT
     *
     * @mbg.generated
     */
    public void setActivityComment(String activityComment) {
        this.activityComment = activityComment == null ? null : activityComment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.ACTIVITY.ACTIVITY_START_TIME
     *
     * @return the value of dbo.ACTIVITY.ACTIVITY_START_TIME
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getActivityStartTime() {
        return activityStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.ACTIVITY.ACTIVITY_START_TIME
     *
     * @param activityStartTime the value for dbo.ACTIVITY.ACTIVITY_START_TIME
     *
     * @mbg.generated
     */
    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.ACTIVITY.ACTIVITY_END_TIME
     *
     * @return the value of dbo.ACTIVITY.ACTIVITY_END_TIME
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getActivityEndTime() {
        return activityEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.ACTIVITY.ACTIVITY_END_TIME
     *
     * @param activityEndTime the value for dbo.ACTIVITY.ACTIVITY_END_TIME
     *
     * @mbg.generated
     */
    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.ACTIVITY.ACTIVITY_PROCESS_USER_GUID
     *
     * @return the value of dbo.ACTIVITY.ACTIVITY_PROCESS_USER_GUID
     *
     * @mbg.generated
     */
    public String getActivityProcessUserGuid() {
        return activityProcessUserGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.ACTIVITY.ACTIVITY_PROCESS_USER_GUID
     *
     * @param activityProcessUserGuid the value for dbo.ACTIVITY.ACTIVITY_PROCESS_USER_GUID
     *
     * @mbg.generated
     */
    public void setActivityProcessUserGuid(String activityProcessUserGuid) {
        this.activityProcessUserGuid = activityProcessUserGuid == null ? null : activityProcessUserGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.ACTIVITY.ACTIVITY_ADDRESS
     *
     * @return the value of dbo.ACTIVITY.ACTIVITY_ADDRESS
     *
     * @mbg.generated
     */
    public String getActivityAddress() {
        return activityAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.ACTIVITY.ACTIVITY_ADDRESS
     *
     * @param activityAddress the value for dbo.ACTIVITY.ACTIVITY_ADDRESS
     *
     * @mbg.generated
     */
    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress == null ? null : activityAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.ACTIVITY.ACTIVITY_FROM_COMM_GUID
     *
     * @return the value of dbo.ACTIVITY.ACTIVITY_FROM_COMM_GUID
     *
     * @mbg.generated
     */
    public String getActivityFromCommGuid() {
        return activityFromCommGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.ACTIVITY.ACTIVITY_FROM_COMM_GUID
     *
     * @param activityFromCommGuid the value for dbo.ACTIVITY.ACTIVITY_FROM_COMM_GUID
     *
     * @mbg.generated
     */
    public void setActivityFromCommGuid(String activityFromCommGuid) {
        this.activityFromCommGuid = activityFromCommGuid == null ? null : activityFromCommGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.ACTIVITY.ACTIVITY_TYPE_PROCESS_STATUS
     *
     * @return the value of dbo.ACTIVITY.ACTIVITY_TYPE_PROCESS_STATUS
     *
     * @mbg.generated
     */
    public String getActivityTypeProcessStatus() {
        return activityTypeProcessStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.ACTIVITY.ACTIVITY_TYPE_PROCESS_STATUS
     *
     * @param activityTypeProcessStatus the value for dbo.ACTIVITY.ACTIVITY_TYPE_PROCESS_STATUS
     *
     * @mbg.generated
     */
    public void setActivityTypeProcessStatus(String activityTypeProcessStatus) {
        this.activityTypeProcessStatus = activityTypeProcessStatus == null ? null : activityTypeProcessStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.ACTIVITY.ACTIVITY_TARGETS_USER_GUID
     *
     * @return the value of dbo.ACTIVITY.ACTIVITY_TARGETS_USER_GUID
     *
     * @mbg.generated
     */
    public String getActivityTargetsUserGuid() {
        return activityTargetsUserGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.ACTIVITY.ACTIVITY_TARGETS_USER_GUID
     *
     * @param activityTargetsUserGuid the value for dbo.ACTIVITY.ACTIVITY_TARGETS_USER_GUID
     *
     * @mbg.generated
     */
    public void setActivityTargetsUserGuid(String activityTargetsUserGuid) {
        this.activityTargetsUserGuid = activityTargetsUserGuid == null ? null : activityTargetsUserGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.ACTIVITY.ACTIVITY_PERSON_NUM
     *
     * @return the value of dbo.ACTIVITY.ACTIVITY_PERSON_NUM
     *
     * @mbg.generated
     */
    public Integer getActivityPersonNum() {
        return activityPersonNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.ACTIVITY.ACTIVITY_PERSON_NUM
     *
     * @param activityPersonNum the value for dbo.ACTIVITY.ACTIVITY_PERSON_NUM
     *
     * @mbg.generated
     */
    public void setActivityPersonNum(Integer activityPersonNum) {
        this.activityPersonNum = activityPersonNum;
    }
}