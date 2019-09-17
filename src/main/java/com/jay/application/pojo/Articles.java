package com.jay.application.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *  博文表
 * @author Jay
 */
public class Articles {

	private Integer articlId;			//博文Id
	private Integer userId;				//用户Id
	private String articlTitle;			//博文标题
	private String articContent;		//博文内容
	private Integer articlViews;		//浏览量
	private Integer articCommentCount;	//评论总数
	private Date articDate;				//发表时间
	private String articDateString;		//发表时间 String格式
	private Integer articLikeCount;		//喜欢数
	private Users users;				//用户
	
	public Integer getArticlId() {
		return articlId;
	}
	public void setArticlId(Integer articlId) {
		this.articlId = articlId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getArticlTitle() {
		return articlTitle;
	}
	public void setArticlTitle(String articlTitle) {
		this.articlTitle = articlTitle;
	}
	public String getArticContent() {
		return articContent;
	}
	public void setArticContent(String articContent) {
		this.articContent = articContent;
	}
	public Integer getArticlViews() {
		return articlViews;
	}
	public void setArticlViews(Integer articlViews) {
		this.articlViews = articlViews;
	}
	public Integer getArticCommentCount() {
		return articCommentCount;
	}
	public void setArticCommentCount(Integer articCommentCount) {
		this.articCommentCount = articCommentCount;
	}
	public Date getArticDate() {
		return articDate;
	}
	public void setArticDate(Date articDate) {
		this.articDate = articDate;
	}
	public Integer getArticLikeCount() {
		return articLikeCount;
	}
	public void setArticLikeCount(Integer articLikeCount) {
		this.articLikeCount = articLikeCount;
	}
	
	public String getArticDateString() {
		return articDateString;
	}
	public void setArticDateString(String articDateString) {
		this.articDateString = articDateString;
	}
	
	public Users getUsers() {
		return users;
	}
	
	public void setUsers(Users users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Articles [articlId=" + articlId + ", userId=" + userId + ", articlTitle=" + articlTitle
				+ ", articContent=" + articContent + ", articlViews=" + articlViews + ", articCommentCount="
				+ articCommentCount + ", articDate=" + articDate + ", articDateString=" + articDateString
				+ ", articLikeCount=" + articLikeCount + ", users=" + users + "]";
	}
	
}
