package com.timebank.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Users {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_GUID
     *
     * @mbg.generated
     */
    private String userGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_NAME
     *
     * @mbg.generated
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_ACCOUNT
     *
     * @mbg.generated
     */
    private String userAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_PASSWORD
     *
     * @mbg.generated
     */
    private String userPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_FROM_ROLE_GUID
     *
     * @mbg.generated
     */
    private String userFromRoleGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_TYPE_GUID_GENDER
     *
     * @mbg.generated
     */
    private String userTypeGuidGender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_TYPE_ACCOUNT_STATUS
     *
     * @mbg.generated
     */
    private String userTypeAccountStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_SALT
     *
     * @mbg.generated
     */
    private String userSalt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_OWN_CURRENCY
     *
     * @mbg.generated
     */
    private Double userOwnCurrency;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_PRE_CONSUME_CURRENCY
     *
     * @mbg.generated
     */
    private Double userPreConsumeCurrency;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_ADDRESS
     *
     * @mbg.generated
     */
    private String userAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_PROVINCE
     *
     * @mbg.generated
     */
    private String userProvince;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_CITY
     *
     * @mbg.generated
     */
    private String userCity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_DISTRICT
     *
     * @mbg.generated
     */
    private String userDistrict;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_COORDINATE
     *
     * @mbg.generated
     */
    private String userCoordinate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_COMM_GUID
     *
     * @mbg.generated
     */
    private String userCommGuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_ROLE
     *
     * @mbg.generated
     */
    private String userRole;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_IDNUM
     *
     * @mbg.generated
     */
    private String userIdnum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_PHONE
     *
     * @mbg.generated
     */
    private String userPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_MAIL
     *
     * @mbg.generated
     */
    private String userMail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_EMERCONTACT
     *
     * @mbg.generated
     */
    private String userEmercontact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_EMERPERSON
     *
     * @mbg.generated
     */
    private String userEmerperson;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_BIRTHDATE
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date userBirthdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_IDIMAGE
     *
     * @mbg.generated
     */
    private String userIdimage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_CURRENTADDR
     *
     * @mbg.generated
     */
    private String userCurrentaddr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_AVATAR
     *
     * @mbg.generated
     */
    private String userAvatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_TRANS_PASSWORD
     *
     * @mbg.generated
     */
    private Integer userTransPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.USERS.USER_CREDIT
     *
     * @mbg.generated
     */
    private Integer userCredit;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_GUID
     *
     * @return the value of dbo.USERS.USER_GUID
     *
     * @mbg.generated
     */
    public String getUserGuid() {
        return userGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_GUID
     *
     * @param userGuid the value for dbo.USERS.USER_GUID
     *
     * @mbg.generated
     */
    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid == null ? null : userGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_NAME
     *
     * @return the value of dbo.USERS.USER_NAME
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_NAME
     *
     * @param userName the value for dbo.USERS.USER_NAME
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_ACCOUNT
     *
     * @return the value of dbo.USERS.USER_ACCOUNT
     *
     * @mbg.generated
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_ACCOUNT
     *
     * @param userAccount the value for dbo.USERS.USER_ACCOUNT
     *
     * @mbg.generated
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_PASSWORD
     *
     * @return the value of dbo.USERS.USER_PASSWORD
     *
     * @mbg.generated
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_PASSWORD
     *
     * @param userPassword the value for dbo.USERS.USER_PASSWORD
     *
     * @mbg.generated
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_FROM_ROLE_GUID
     *
     * @return the value of dbo.USERS.USER_FROM_ROLE_GUID
     *
     * @mbg.generated
     */
    public String getUserFromRoleGuid() {
        return userFromRoleGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_FROM_ROLE_GUID
     *
     * @param userFromRoleGuid the value for dbo.USERS.USER_FROM_ROLE_GUID
     *
     * @mbg.generated
     */
    public void setUserFromRoleGuid(String userFromRoleGuid) {
        this.userFromRoleGuid = userFromRoleGuid == null ? null : userFromRoleGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_TYPE_GUID_GENDER
     *
     * @return the value of dbo.USERS.USER_TYPE_GUID_GENDER
     *
     * @mbg.generated
     */
    public String getUserTypeGuidGender() {
        return userTypeGuidGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_TYPE_GUID_GENDER
     *
     * @param userTypeGuidGender the value for dbo.USERS.USER_TYPE_GUID_GENDER
     *
     * @mbg.generated
     */
    public void setUserTypeGuidGender(String userTypeGuidGender) {
        this.userTypeGuidGender = userTypeGuidGender == null ? null : userTypeGuidGender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_TYPE_ACCOUNT_STATUS
     *
     * @return the value of dbo.USERS.USER_TYPE_ACCOUNT_STATUS
     *
     * @mbg.generated
     */
    public String getUserTypeAccountStatus() {
        return userTypeAccountStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_TYPE_ACCOUNT_STATUS
     *
     * @param userTypeAccountStatus the value for dbo.USERS.USER_TYPE_ACCOUNT_STATUS
     *
     * @mbg.generated
     */
    public void setUserTypeAccountStatus(String userTypeAccountStatus) {
        this.userTypeAccountStatus = userTypeAccountStatus == null ? null : userTypeAccountStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_SALT
     *
     * @return the value of dbo.USERS.USER_SALT
     *
     * @mbg.generated
     */
    public String getUserSalt() {
        return userSalt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_SALT
     *
     * @param userSalt the value for dbo.USERS.USER_SALT
     *
     * @mbg.generated
     */
    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt == null ? null : userSalt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_OWN_CURRENCY
     *
     * @return the value of dbo.USERS.USER_OWN_CURRENCY
     *
     * @mbg.generated
     */
    public Double getUserOwnCurrency() {
        return userOwnCurrency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_OWN_CURRENCY
     *
     * @param userOwnCurrency the value for dbo.USERS.USER_OWN_CURRENCY
     *
     * @mbg.generated
     */
    public void setUserOwnCurrency(Double userOwnCurrency) {
        this.userOwnCurrency = userOwnCurrency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_PRE_CONSUME_CURRENCY
     *
     * @return the value of dbo.USERS.USER_PRE_CONSUME_CURRENCY
     *
     * @mbg.generated
     */
    public Double getUserPreConsumeCurrency() {
        return userPreConsumeCurrency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_PRE_CONSUME_CURRENCY
     *
     * @param userPreConsumeCurrency the value for dbo.USERS.USER_PRE_CONSUME_CURRENCY
     *
     * @mbg.generated
     */
    public void setUserPreConsumeCurrency(Double userPreConsumeCurrency) {
        this.userPreConsumeCurrency = userPreConsumeCurrency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_ADDRESS
     *
     * @return the value of dbo.USERS.USER_ADDRESS
     *
     * @mbg.generated
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_ADDRESS
     *
     * @param userAddress the value for dbo.USERS.USER_ADDRESS
     *
     * @mbg.generated
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_PROVINCE
     *
     * @return the value of dbo.USERS.USER_PROVINCE
     *
     * @mbg.generated
     */
    public String getUserProvince() {
        return userProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_PROVINCE
     *
     * @param userProvince the value for dbo.USERS.USER_PROVINCE
     *
     * @mbg.generated
     */
    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince == null ? null : userProvince.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_CITY
     *
     * @return the value of dbo.USERS.USER_CITY
     *
     * @mbg.generated
     */
    public String getUserCity() {
        return userCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_CITY
     *
     * @param userCity the value for dbo.USERS.USER_CITY
     *
     * @mbg.generated
     */
    public void setUserCity(String userCity) {
        this.userCity = userCity == null ? null : userCity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_DISTRICT
     *
     * @return the value of dbo.USERS.USER_DISTRICT
     *
     * @mbg.generated
     */
    public String getUserDistrict() {
        return userDistrict;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_DISTRICT
     *
     * @param userDistrict the value for dbo.USERS.USER_DISTRICT
     *
     * @mbg.generated
     */
    public void setUserDistrict(String userDistrict) {
        this.userDistrict = userDistrict == null ? null : userDistrict.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_COORDINATE
     *
     * @return the value of dbo.USERS.USER_COORDINATE
     *
     * @mbg.generated
     */
    public String getUserCoordinate() {
        return userCoordinate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_COORDINATE
     *
     * @param userCoordinate the value for dbo.USERS.USER_COORDINATE
     *
     * @mbg.generated
     */
    public void setUserCoordinate(String userCoordinate) {
        this.userCoordinate = userCoordinate == null ? null : userCoordinate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_COMM_GUID
     *
     * @return the value of dbo.USERS.USER_COMM_GUID
     *
     * @mbg.generated
     */
    public String getUserCommGuid() {
        return userCommGuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_COMM_GUID
     *
     * @param userCommGuid the value for dbo.USERS.USER_COMM_GUID
     *
     * @mbg.generated
     */
    public void setUserCommGuid(String userCommGuid) {
        this.userCommGuid = userCommGuid == null ? null : userCommGuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_ROLE
     *
     * @return the value of dbo.USERS.USER_ROLE
     *
     * @mbg.generated
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_ROLE
     *
     * @param userRole the value for dbo.USERS.USER_ROLE
     *
     * @mbg.generated
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_IDNUM
     *
     * @return the value of dbo.USERS.USER_IDNUM
     *
     * @mbg.generated
     */
    public String getUserIdnum() {
        return userIdnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_IDNUM
     *
     * @param userIdnum the value for dbo.USERS.USER_IDNUM
     *
     * @mbg.generated
     */
    public void setUserIdnum(String userIdnum) {
        this.userIdnum = userIdnum == null ? null : userIdnum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_PHONE
     *
     * @return the value of dbo.USERS.USER_PHONE
     *
     * @mbg.generated
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_PHONE
     *
     * @param userPhone the value for dbo.USERS.USER_PHONE
     *
     * @mbg.generated
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_MAIL
     *
     * @return the value of dbo.USERS.USER_MAIL
     *
     * @mbg.generated
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_MAIL
     *
     * @param userMail the value for dbo.USERS.USER_MAIL
     *
     * @mbg.generated
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_EMERCONTACT
     *
     * @return the value of dbo.USERS.USER_EMERCONTACT
     *
     * @mbg.generated
     */
    public String getUserEmercontact() {
        return userEmercontact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_EMERCONTACT
     *
     * @param userEmercontact the value for dbo.USERS.USER_EMERCONTACT
     *
     * @mbg.generated
     */
    public void setUserEmercontact(String userEmercontact) {
        this.userEmercontact = userEmercontact == null ? null : userEmercontact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_EMERPERSON
     *
     * @return the value of dbo.USERS.USER_EMERPERSON
     *
     * @mbg.generated
     */
    public String getUserEmerperson() {
        return userEmerperson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_EMERPERSON
     *
     * @param userEmerperson the value for dbo.USERS.USER_EMERPERSON
     *
     * @mbg.generated
     */
    public void setUserEmerperson(String userEmerperson) {
        this.userEmerperson = userEmerperson == null ? null : userEmerperson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_BIRTHDATE
     *
     * @return the value of dbo.USERS.USER_BIRTHDATE
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getUserBirthdate() {
        return userBirthdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_BIRTHDATE
     *
     * @param userBirthdate the value for dbo.USERS.USER_BIRTHDATE
     *
     * @mbg.generated
     */
    public void setUserBirthdate(Date userBirthdate) {
        this.userBirthdate = userBirthdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_IDIMAGE
     *
     * @return the value of dbo.USERS.USER_IDIMAGE
     *
     * @mbg.generated
     */
    public String getUserIdimage() {
        return userIdimage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_IDIMAGE
     *
     * @param userIdimage the value for dbo.USERS.USER_IDIMAGE
     *
     * @mbg.generated
     */
    public void setUserIdimage(String userIdimage) {
        this.userIdimage = userIdimage == null ? null : userIdimage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_CURRENTADDR
     *
     * @return the value of dbo.USERS.USER_CURRENTADDR
     *
     * @mbg.generated
     */
    public String getUserCurrentaddr() {
        return userCurrentaddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_CURRENTADDR
     *
     * @param userCurrentaddr the value for dbo.USERS.USER_CURRENTADDR
     *
     * @mbg.generated
     */
    public void setUserCurrentaddr(String userCurrentaddr) {
        this.userCurrentaddr = userCurrentaddr == null ? null : userCurrentaddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_AVATAR
     *
     * @return the value of dbo.USERS.USER_AVATAR
     *
     * @mbg.generated
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_AVATAR
     *
     * @param userAvatar the value for dbo.USERS.USER_AVATAR
     *
     * @mbg.generated
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_TRANS_PASSWORD
     *
     * @return the value of dbo.USERS.USER_TRANS_PASSWORD
     *
     * @mbg.generated
     */
    public Integer getUserTransPassword() {
        return userTransPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_TRANS_PASSWORD
     *
     * @param userTransPassword the value for dbo.USERS.USER_TRANS_PASSWORD
     *
     * @mbg.generated
     */
    public void setUserTransPassword(Integer userTransPassword) {
        this.userTransPassword = userTransPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.USERS.USER_CREDIT
     *
     * @return the value of dbo.USERS.USER_CREDIT
     *
     * @mbg.generated
     */
    public Integer getUserCredit() {
        return userCredit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.USERS.USER_CREDIT
     *
     * @param userCredit the value for dbo.USERS.USER_CREDIT
     *
     * @mbg.generated
     */
    public void setUserCredit(Integer userCredit) {
        this.userCredit = userCredit;
    }
}