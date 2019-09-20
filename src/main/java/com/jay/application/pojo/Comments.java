package com.jay.application.pojo;

import java.util.Date;

/**
 *  评论表
 * @author Jay
 */
public class Comments {
	/**
	 * 评论Id
	 */
	private Integer commentId;
	/**
	 * 用户Id
	 */
	private Integer userId;
	/**
	 * 博文Id
	 */
	private Integer articleId;
	/**
	 * 点赞数
	 */
	private Integer commentLikeCount;
	/**
	 * 评论日期
	 */
	private Date commentDate;
	/**
	 * 评论内容
	 */
	private String commentContent;
	/**
	 * 父评论
	 */
	private Comments parentComments;
	
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public Integer getCommentLikeCount() {
		return commentLikeCount;
	}
	public void setCommentLikeCount(Integer commentLikeCount) {
		this.commentLikeCount = commentLikeCount;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Comments getParentComments() {
		return parentComments;
	}
	public void setParentComments(Comments parentComments) {
		this.parentComments = parentComments;
	}
	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", userId=" + userId + ", articleId=" + articleId
				+ ", commentLikeCount=" + commentLikeCount + ", commentDate=" + commentDate + ", commentContent="
				+ commentContent + ", parentComments=" + parentComments + "]";
	}
	
	
}
