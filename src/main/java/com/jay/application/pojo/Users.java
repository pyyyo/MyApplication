package com.jay.application.pojo;

import java.util.Date;

/**
 *  用户表
 * @author Jay
 */
public class Users {
	private Integer id;								//id
	private String userIp;								//IP
	private String userName;							//用户名
	private String userPassword;						//密码
	private String userEmail;							//email
	private String userProfilePhoto;					//头像
	private Date userRegistrationTime;					//注册时间
	private Date userBirthDay;							//生日
	private Integer userAge;							//年龄
	private Integer userTelephoneNumber;				//手机
	private String userNickName;						//昵称
	private String token;								//token
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserProfilePhoto() {
		return userProfilePhoto;
	}
	public void setUserProfilePhoto(String userProfilePhoto) {
		this.userProfilePhoto = userProfilePhoto;
	}
	public Date getUserRegistrationTime() {
		return userRegistrationTime;
	}
	public void setUserRegistrationTime(Date userRegistrationTime) {
		this.userRegistrationTime = userRegistrationTime;
	}
	public Date getUserBirthDay() {
		return userBirthDay;
	}
	public void setUserBirthDay(Date userBirthDay) {
		this.userBirthDay = userBirthDay;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public Integer getUserTelephoneNumber() {
		return userTelephoneNumber;
	}
	public void setUserTelephoneNumber(Integer userTelephoneNumber) {
		this.userTelephoneNumber = userTelephoneNumber;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", userIp=" + userIp + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userEmail=" + userEmail + ", userProfilePhoto=" + userProfilePhoto
				+ ", userRegistrationTime=" + userRegistrationTime + ", userBirthDay=" + userBirthDay + ", userAge="
				+ userAge + ", userTelephoneNumber=" + userTelephoneNumber + ", userNickName=" + userNickName
				+ ", token=" + token + "]";
	}
	
}
