package org.socialnetworking.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BlogComments")
public class BlogComment extends DomainResponse implements Serializable {

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8690414624158326101L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "blogsComments_seq", allocationSize = 1)
	private int commentId;
	private int blogId;
	private int userId;
	private String date=new Date().toString();
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	private String comment;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public BlogComment(int commentId, int blogId, int userId, String comment) {
		super();
		this.commentId = commentId;
		this.blogId = blogId;
		this.userId = userId;
		this.comment = comment;
	}
	public BlogComment() {
		super();
	}
}
