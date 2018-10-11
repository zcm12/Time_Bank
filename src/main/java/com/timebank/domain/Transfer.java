package com.timebank.domain;

import java.util.Date;

public class Transfer {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.TRANSFER.TRANS_GUID
     *
     * @mbg.generated
     */
    private String transGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.TRANSFER.TRANS_FROM_USER_GUID
     *
     * @mbg.generated
     */
    private String transFromUserGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.TRANSFER.TRANS_TO_USER_GUID
     *
     * @mbg.generated
     */
    private String transToUserGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.TRANSFER.TRANS_DESP
     *
     * @mbg.generated
     */
    private String transDesp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.TRANSFER.TRANS_ISSUE_TIME
     *
     * @mbg.generated
     */
    private Date transIssueTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.TRANSFER.TRANS_TYPE_GUID_PROCESS_STATUS
     *
     * @mbg.generated
     */
    private String transTypeGuidProcessStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.TRANSFER.TRANS_PROCESS_TIME
     *
     * @mbg.generated
     */
    private Date transProcessTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.TRANSFER.TRANS_PROCESS_DESP
     *
     * @mbg.generated
     */
    private String transProcessDesp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.TRANSFER.TRANS_CURRENCY
     *
     * @mbg.generated
     */
    private Double transCurrency;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.TRANSFER.TRANS_FROM_USER_ACCOUNT
     *
     * @mbg.generated
     */
    private String transFromUserAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.TRANSFER.TRANS_TO_USER_ACCOUNT
     *
     * @mbg.generated
     */
    private String transToUserAccount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.TRANSFER.TRANS_GUID
     *
     * @return the value of dbo.TRANSFER.TRANS_GUID
     *
     * @mbg.generated
     */
    public String getTransGuid() {
        return transGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.TRANSFER.TRANS_GUID
     *
     * @param transGuid the value for dbo.TRANSFER.TRANS_GUID
     *
     * @mbg.generated
     */
    public void setTransGuid(String transGuid) {
        this.transGuid = transGuid == null ? null : transGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.TRANSFER.TRANS_FROM_USER_GUID
     *
     * @return the value of dbo.TRANSFER.TRANS_FROM_USER_GUID
     *
     * @mbg.generated
     */
    public String getTransFromUserGuid() {
        return transFromUserGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.TRANSFER.TRANS_FROM_USER_GUID
     *
     * @param transFromUserGuid the value for dbo.TRANSFER.TRANS_FROM_USER_GUID
     *
     * @mbg.generated
     */
    public void setTransFromUserGuid(String transFromUserGuid) {
        this.transFromUserGuid = transFromUserGuid == null ? null : transFromUserGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.TRANSFER.TRANS_TO_USER_GUID
     *
     * @return the value of dbo.TRANSFER.TRANS_TO_USER_GUID
     *
     * @mbg.generated
     */
    public String getTransToUserGuid() {
        return transToUserGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.TRANSFER.TRANS_TO_USER_GUID
     *
     * @param transToUserGuid the value for dbo.TRANSFER.TRANS_TO_USER_GUID
     *
     * @mbg.generated
     */
    public void setTransToUserGuid(String transToUserGuid) {
        this.transToUserGuid = transToUserGuid == null ? null : transToUserGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.TRANSFER.TRANS_DESP
     *
     * @return the value of dbo.TRANSFER.TRANS_DESP
     *
     * @mbg.generated
     */
    public String getTransDesp() {
        return transDesp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.TRANSFER.TRANS_DESP
     *
     * @param transDesp the value for dbo.TRANSFER.TRANS_DESP
     *
     * @mbg.generated
     */
    public void setTransDesp(String transDesp) {
        this.transDesp = transDesp == null ? null : transDesp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.TRANSFER.TRANS_ISSUE_TIME
     *
     * @return the value of dbo.TRANSFER.TRANS_ISSUE_TIME
     *
     * @mbg.generated
     */
    public Date getTransIssueTime() {
        return transIssueTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.TRANSFER.TRANS_ISSUE_TIME
     *
     * @param transIssueTime the value for dbo.TRANSFER.TRANS_ISSUE_TIME
     *
     * @mbg.generated
     */
    public void setTransIssueTime(Date transIssueTime) {
        this.transIssueTime = transIssueTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.TRANSFER.TRANS_TYPE_GUID_PROCESS_STATUS
     *
     * @return the value of dbo.TRANSFER.TRANS_TYPE_GUID_PROCESS_STATUS
     *
     * @mbg.generated
     */
    public String getTransTypeGuidProcessStatus() {
        return transTypeGuidProcessStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.TRANSFER.TRANS_TYPE_GUID_PROCESS_STATUS
     *
     * @param transTypeGuidProcessStatus the value for dbo.TRANSFER.TRANS_TYPE_GUID_PROCESS_STATUS
     *
     * @mbg.generated
     */
    public void setTransTypeGuidProcessStatus(String transTypeGuidProcessStatus) {
        this.transTypeGuidProcessStatus = transTypeGuidProcessStatus == null ? null : transTypeGuidProcessStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.TRANSFER.TRANS_PROCESS_TIME
     *
     * @return the value of dbo.TRANSFER.TRANS_PROCESS_TIME
     *
     * @mbg.generated
     */
    public Date getTransProcessTime() {
        return transProcessTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.TRANSFER.TRANS_PROCESS_TIME
     *
     * @param transProcessTime the value for dbo.TRANSFER.TRANS_PROCESS_TIME
     *
     * @mbg.generated
     */
    public void setTransProcessTime(Date transProcessTime) {
        this.transProcessTime = transProcessTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.TRANSFER.TRANS_PROCESS_DESP
     *
     * @return the value of dbo.TRANSFER.TRANS_PROCESS_DESP
     *
     * @mbg.generated
     */
    public String getTransProcessDesp() {
        return transProcessDesp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.TRANSFER.TRANS_PROCESS_DESP
     *
     * @param transProcessDesp the value for dbo.TRANSFER.TRANS_PROCESS_DESP
     *
     * @mbg.generated
     */
    public void setTransProcessDesp(String transProcessDesp) {
        this.transProcessDesp = transProcessDesp == null ? null : transProcessDesp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.TRANSFER.TRANS_CURRENCY
     *
     * @return the value of dbo.TRANSFER.TRANS_CURRENCY
     *
     * @mbg.generated
     */
    public Double getTransCurrency() {
        return transCurrency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.TRANSFER.TRANS_CURRENCY
     *
     * @param transCurrency the value for dbo.TRANSFER.TRANS_CURRENCY
     *
     * @mbg.generated
     */
    public void setTransCurrency(Double transCurrency) {
        this.transCurrency = transCurrency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.TRANSFER.TRANS_FROM_USER_ACCOUNT
     *
     * @return the value of dbo.TRANSFER.TRANS_FROM_USER_ACCOUNT
     *
     * @mbg.generated
     */
    public String getTransFromUserAccount() {
        return transFromUserAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.TRANSFER.TRANS_FROM_USER_ACCOUNT
     *
     * @param transFromUserAccount the value for dbo.TRANSFER.TRANS_FROM_USER_ACCOUNT
     *
     * @mbg.generated
     */
    public void setTransFromUserAccount(String transFromUserAccount) {
        this.transFromUserAccount = transFromUserAccount == null ? null : transFromUserAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.TRANSFER.TRANS_TO_USER_ACCOUNT
     *
     * @return the value of dbo.TRANSFER.TRANS_TO_USER_ACCOUNT
     *
     * @mbg.generated
     */
    public String getTransToUserAccount() {
        return transToUserAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.TRANSFER.TRANS_TO_USER_ACCOUNT
     *
     * @param transToUserAccount the value for dbo.TRANSFER.TRANS_TO_USER_ACCOUNT
     *
     * @mbg.generated
     */
    public void setTransToUserAccount(String transToUserAccount) {
        this.transToUserAccount = transToUserAccount == null ? null : transToUserAccount.trim();
    }
}