package com.timebank.domain;

import java.util.Date;

public class Reqest {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_GUID
     *
     * @mbg.generated
     */
    private String reqGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_ISSUE_USER_GUID
     *
     * @mbg.generated
     */
    private String reqIssueUserGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_ISSUE_TIME
     *
     * @mbg.generated
     */
    private Date reqIssueTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_ADDRESS
     *
     * @mbg.generated
     */
    private String reqAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_TITLE
     *
     * @mbg.generated
     */
    private String reqTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_DESP
     *
     * @mbg.generated
     */
    private String reqDesp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_COMMENT
     *
     * @mbg.generated
     */
    private String reqComment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_DISPATCH_TIME
     *
     * @mbg.generated
     */
    private Date reqDispatchTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_TYPE_GUID_CLASS
     *
     * @mbg.generated
     */
    private String reqTypeGuidClass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_AVAILABLE_START_TIME
     *
     * @mbg.generated
     */
    private Date reqAvailableStartTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_AVAILABLE_END_TIME
     *
     * @mbg.generated
     */
    private Date reqAvailableEndTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_RRE_DURATION_TIME
     *
     * @mbg.generated
     */
    private Integer reqRreDurationTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_PRE_CUNSUME_CURRENCY
     *
     * @mbg.generated
     */
    private Double reqPreCunsumeCurrency;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_START_TIME
     *
     * @mbg.generated
     */
    private Date reqStartTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_END_TIME
     *
     * @mbg.generated
     */
    private Date reqEndTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_ACTUAL_CONSUME_CURRENCY
     *
     * @mbg.generated
     */
    private Double reqActualConsumeCurrency;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_TYPE_APPROVE_STATUS
     *
     * @mbg.generated
     */
    private String reqTypeApproveStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_TARGETS_USER_GUID
     *
     * @mbg.generated
     */
    private String reqTargetsUserGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_ACTUAL_DURATION_TIME
     *
     * @mbg.generated
     */
    private Integer reqActualDurationTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_PERSON_NUM
     *
     * @mbg.generated
     */
    private Integer reqPersonNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_TYPE_GUID_URGENCY
     *
     * @mbg.generated
     */
    private String reqTypeGuidUrgency;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_FROM_WEIGHT_GUID
     *
     * @mbg.generated
     */
    private String reqFromWeightGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_TYPE_GUID_PROCESS_STATUS
     *
     * @mbg.generated
     */
    private String reqTypeGuidProcessStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_PROCESS_USER_GUID
     *
     * @mbg.generated
     */
    private String reqProcessUserGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_TARGETS_USER_ACCOUNT
     *
     * @mbg.generated
     */
    private String reqTargetsUserAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.REQEST.REQ_PHONE
     *
     * @mbg.generated
     */
    private String reqPhone;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_GUID
     *
     * @return the value of dbo.REQEST.REQ_GUID
     *
     * @mbg.generated
     */
    public String getReqGuid() {
        return reqGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_GUID
     *
     * @param reqGuid the value for dbo.REQEST.REQ_GUID
     *
     * @mbg.generated
     */
    public void setReqGuid(String reqGuid) {
        this.reqGuid = reqGuid == null ? null : reqGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_ISSUE_USER_GUID
     *
     * @return the value of dbo.REQEST.REQ_ISSUE_USER_GUID
     *
     * @mbg.generated
     */
    public String getReqIssueUserGuid() {
        return reqIssueUserGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_ISSUE_USER_GUID
     *
     * @param reqIssueUserGuid the value for dbo.REQEST.REQ_ISSUE_USER_GUID
     *
     * @mbg.generated
     */
    public void setReqIssueUserGuid(String reqIssueUserGuid) {
        this.reqIssueUserGuid = reqIssueUserGuid == null ? null : reqIssueUserGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_ISSUE_TIME
     *
     * @return the value of dbo.REQEST.REQ_ISSUE_TIME
     *
     * @mbg.generated
     */
    public Date getReqIssueTime() {
        return reqIssueTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_ISSUE_TIME
     *
     * @param reqIssueTime the value for dbo.REQEST.REQ_ISSUE_TIME
     *
     * @mbg.generated
     */
    public void setReqIssueTime(Date reqIssueTime) {
        this.reqIssueTime = reqIssueTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_ADDRESS
     *
     * @return the value of dbo.REQEST.REQ_ADDRESS
     *
     * @mbg.generated
     */
    public String getReqAddress() {
        return reqAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_ADDRESS
     *
     * @param reqAddress the value for dbo.REQEST.REQ_ADDRESS
     *
     * @mbg.generated
     */
    public void setReqAddress(String reqAddress) {
        this.reqAddress = reqAddress == null ? null : reqAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_TITLE
     *
     * @return the value of dbo.REQEST.REQ_TITLE
     *
     * @mbg.generated
     */
    public String getReqTitle() {
        return reqTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_TITLE
     *
     * @param reqTitle the value for dbo.REQEST.REQ_TITLE
     *
     * @mbg.generated
     */
    public void setReqTitle(String reqTitle) {
        this.reqTitle = reqTitle == null ? null : reqTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_DESP
     *
     * @return the value of dbo.REQEST.REQ_DESP
     *
     * @mbg.generated
     */
    public String getReqDesp() {
        return reqDesp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_DESP
     *
     * @param reqDesp the value for dbo.REQEST.REQ_DESP
     *
     * @mbg.generated
     */
    public void setReqDesp(String reqDesp) {
        this.reqDesp = reqDesp == null ? null : reqDesp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_COMMENT
     *
     * @return the value of dbo.REQEST.REQ_COMMENT
     *
     * @mbg.generated
     */
    public String getReqComment() {
        return reqComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_COMMENT
     *
     * @param reqComment the value for dbo.REQEST.REQ_COMMENT
     *
     * @mbg.generated
     */
    public void setReqComment(String reqComment) {
        this.reqComment = reqComment == null ? null : reqComment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_DISPATCH_TIME
     *
     * @return the value of dbo.REQEST.REQ_DISPATCH_TIME
     *
     * @mbg.generated
     */
    public Date getReqDispatchTime() {
        return reqDispatchTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_DISPATCH_TIME
     *
     * @param reqDispatchTime the value for dbo.REQEST.REQ_DISPATCH_TIME
     *
     * @mbg.generated
     */
    public void setReqDispatchTime(Date reqDispatchTime) {
        this.reqDispatchTime = reqDispatchTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_TYPE_GUID_CLASS
     *
     * @return the value of dbo.REQEST.REQ_TYPE_GUID_CLASS
     *
     * @mbg.generated
     */
    public String getReqTypeGuidClass() {
        return reqTypeGuidClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_TYPE_GUID_CLASS
     *
     * @param reqTypeGuidClass the value for dbo.REQEST.REQ_TYPE_GUID_CLASS
     *
     * @mbg.generated
     */
    public void setReqTypeGuidClass(String reqTypeGuidClass) {
        this.reqTypeGuidClass = reqTypeGuidClass == null ? null : reqTypeGuidClass.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_AVAILABLE_START_TIME
     *
     * @return the value of dbo.REQEST.REQ_AVAILABLE_START_TIME
     *
     * @mbg.generated
     */
    public Date getReqAvailableStartTime() {
        return reqAvailableStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_AVAILABLE_START_TIME
     *
     * @param reqAvailableStartTime the value for dbo.REQEST.REQ_AVAILABLE_START_TIME
     *
     * @mbg.generated
     */
    public void setReqAvailableStartTime(Date reqAvailableStartTime) {
        this.reqAvailableStartTime = reqAvailableStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_AVAILABLE_END_TIME
     *
     * @return the value of dbo.REQEST.REQ_AVAILABLE_END_TIME
     *
     * @mbg.generated
     */
    public Date getReqAvailableEndTime() {
        return reqAvailableEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_AVAILABLE_END_TIME
     *
     * @param reqAvailableEndTime the value for dbo.REQEST.REQ_AVAILABLE_END_TIME
     *
     * @mbg.generated
     */
    public void setReqAvailableEndTime(Date reqAvailableEndTime) {
        this.reqAvailableEndTime = reqAvailableEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_RRE_DURATION_TIME
     *
     * @return the value of dbo.REQEST.REQ_RRE_DURATION_TIME
     *
     * @mbg.generated
     */
    public Integer getReqRreDurationTime() {
        return reqRreDurationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_RRE_DURATION_TIME
     *
     * @param reqRreDurationTime the value for dbo.REQEST.REQ_RRE_DURATION_TIME
     *
     * @mbg.generated
     */
    public void setReqRreDurationTime(Integer reqRreDurationTime) {
        this.reqRreDurationTime = reqRreDurationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_PRE_CUNSUME_CURRENCY
     *
     * @return the value of dbo.REQEST.REQ_PRE_CUNSUME_CURRENCY
     *
     * @mbg.generated
     */
    public Double getReqPreCunsumeCurrency() {
        return reqPreCunsumeCurrency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_PRE_CUNSUME_CURRENCY
     *
     * @param reqPreCunsumeCurrency the value for dbo.REQEST.REQ_PRE_CUNSUME_CURRENCY
     *
     * @mbg.generated
     */
    public void setReqPreCunsumeCurrency(Double reqPreCunsumeCurrency) {
        this.reqPreCunsumeCurrency = reqPreCunsumeCurrency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_START_TIME
     *
     * @return the value of dbo.REQEST.REQ_START_TIME
     *
     * @mbg.generated
     */
    public Date getReqStartTime() {
        return reqStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_START_TIME
     *
     * @param reqStartTime the value for dbo.REQEST.REQ_START_TIME
     *
     * @mbg.generated
     */
    public void setReqStartTime(Date reqStartTime) {
        this.reqStartTime = reqStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_END_TIME
     *
     * @return the value of dbo.REQEST.REQ_END_TIME
     *
     * @mbg.generated
     */
    public Date getReqEndTime() {
        return reqEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_END_TIME
     *
     * @param reqEndTime the value for dbo.REQEST.REQ_END_TIME
     *
     * @mbg.generated
     */
    public void setReqEndTime(Date reqEndTime) {
        this.reqEndTime = reqEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_ACTUAL_CONSUME_CURRENCY
     *
     * @return the value of dbo.REQEST.REQ_ACTUAL_CONSUME_CURRENCY
     *
     * @mbg.generated
     */
    public Double getReqActualConsumeCurrency() {
        return reqActualConsumeCurrency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_ACTUAL_CONSUME_CURRENCY
     *
     * @param reqActualConsumeCurrency the value for dbo.REQEST.REQ_ACTUAL_CONSUME_CURRENCY
     *
     * @mbg.generated
     */
    public void setReqActualConsumeCurrency(Double reqActualConsumeCurrency) {
        this.reqActualConsumeCurrency = reqActualConsumeCurrency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_TYPE_APPROVE_STATUS
     *
     * @return the value of dbo.REQEST.REQ_TYPE_APPROVE_STATUS
     *
     * @mbg.generated
     */
    public String getReqTypeApproveStatus() {
        return reqTypeApproveStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_TYPE_APPROVE_STATUS
     *
     * @param reqTypeApproveStatus the value for dbo.REQEST.REQ_TYPE_APPROVE_STATUS
     *
     * @mbg.generated
     */
    public void setReqTypeApproveStatus(String reqTypeApproveStatus) {
        this.reqTypeApproveStatus = reqTypeApproveStatus == null ? null : reqTypeApproveStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_TARGETS_USER_GUID
     *
     * @return the value of dbo.REQEST.REQ_TARGETS_USER_GUID
     *
     * @mbg.generated
     */
    public String getReqTargetsUserGuid() {
        return reqTargetsUserGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_TARGETS_USER_GUID
     *
     * @param reqTargetsUserGuid the value for dbo.REQEST.REQ_TARGETS_USER_GUID
     *
     * @mbg.generated
     */
    public void setReqTargetsUserGuid(String reqTargetsUserGuid) {
        this.reqTargetsUserGuid = reqTargetsUserGuid == null ? null : reqTargetsUserGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_ACTUAL_DURATION_TIME
     *
     * @return the value of dbo.REQEST.REQ_ACTUAL_DURATION_TIME
     *
     * @mbg.generated
     */
    public Integer getReqActualDurationTime() {
        return reqActualDurationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_ACTUAL_DURATION_TIME
     *
     * @param reqActualDurationTime the value for dbo.REQEST.REQ_ACTUAL_DURATION_TIME
     *
     * @mbg.generated
     */
    public void setReqActualDurationTime(Integer reqActualDurationTime) {
        this.reqActualDurationTime = reqActualDurationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_PERSON_NUM
     *
     * @return the value of dbo.REQEST.REQ_PERSON_NUM
     *
     * @mbg.generated
     */
    public Integer getReqPersonNum() {
        return reqPersonNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_PERSON_NUM
     *
     * @param reqPersonNum the value for dbo.REQEST.REQ_PERSON_NUM
     *
     * @mbg.generated
     */
    public void setReqPersonNum(Integer reqPersonNum) {
        this.reqPersonNum = reqPersonNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_TYPE_GUID_URGENCY
     *
     * @return the value of dbo.REQEST.REQ_TYPE_GUID_URGENCY
     *
     * @mbg.generated
     */
    public String getReqTypeGuidUrgency() {
        return reqTypeGuidUrgency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_TYPE_GUID_URGENCY
     *
     * @param reqTypeGuidUrgency the value for dbo.REQEST.REQ_TYPE_GUID_URGENCY
     *
     * @mbg.generated
     */
    public void setReqTypeGuidUrgency(String reqTypeGuidUrgency) {
        this.reqTypeGuidUrgency = reqTypeGuidUrgency == null ? null : reqTypeGuidUrgency.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_FROM_WEIGHT_GUID
     *
     * @return the value of dbo.REQEST.REQ_FROM_WEIGHT_GUID
     *
     * @mbg.generated
     */
    public String getReqFromWeightGuid() {
        return reqFromWeightGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_FROM_WEIGHT_GUID
     *
     * @param reqFromWeightGuid the value for dbo.REQEST.REQ_FROM_WEIGHT_GUID
     *
     * @mbg.generated
     */
    public void setReqFromWeightGuid(String reqFromWeightGuid) {
        this.reqFromWeightGuid = reqFromWeightGuid == null ? null : reqFromWeightGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_TYPE_GUID_PROCESS_STATUS
     *
     * @return the value of dbo.REQEST.REQ_TYPE_GUID_PROCESS_STATUS
     *
     * @mbg.generated
     */
    public String getReqTypeGuidProcessStatus() {
        return reqTypeGuidProcessStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_TYPE_GUID_PROCESS_STATUS
     *
     * @param reqTypeGuidProcessStatus the value for dbo.REQEST.REQ_TYPE_GUID_PROCESS_STATUS
     *
     * @mbg.generated
     */
    public void setReqTypeGuidProcessStatus(String reqTypeGuidProcessStatus) {
        this.reqTypeGuidProcessStatus = reqTypeGuidProcessStatus == null ? null : reqTypeGuidProcessStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_PROCESS_USER_GUID
     *
     * @return the value of dbo.REQEST.REQ_PROCESS_USER_GUID
     *
     * @mbg.generated
     */
    public String getReqProcessUserGuid() {
        return reqProcessUserGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_PROCESS_USER_GUID
     *
     * @param reqProcessUserGuid the value for dbo.REQEST.REQ_PROCESS_USER_GUID
     *
     * @mbg.generated
     */
    public void setReqProcessUserGuid(String reqProcessUserGuid) {
        this.reqProcessUserGuid = reqProcessUserGuid == null ? null : reqProcessUserGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_TARGETS_USER_ACCOUNT
     *
     * @return the value of dbo.REQEST.REQ_TARGETS_USER_ACCOUNT
     *
     * @mbg.generated
     */
    public String getReqTargetsUserAccount() {
        return reqTargetsUserAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_TARGETS_USER_ACCOUNT
     *
     * @param reqTargetsUserAccount the value for dbo.REQEST.REQ_TARGETS_USER_ACCOUNT
     *
     * @mbg.generated
     */
    public void setReqTargetsUserAccount(String reqTargetsUserAccount) {
        this.reqTargetsUserAccount = reqTargetsUserAccount == null ? null : reqTargetsUserAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.REQEST.REQ_PHONE
     *
     * @return the value of dbo.REQEST.REQ_PHONE
     *
     * @mbg.generated
     */
    public String getReqPhone() {
        return reqPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.REQEST.REQ_PHONE
     *
     * @param reqPhone the value for dbo.REQEST.REQ_PHONE
     *
     * @mbg.generated
     */
    public void setReqPhone(String reqPhone) {
        this.reqPhone = reqPhone == null ? null : reqPhone.trim();
    }
}