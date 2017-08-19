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
@Table(name = "Blogs")
public class Blog extends DomainResponse implements Serializable{

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5902335015810630363L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "blogs_seq", allocationSize = 1)
	private int blogId;
	private String blogHeader;
	private String blogCategory;
	private String blogUser;
	private String blogContent;
	private String isActive="false";
	private int blogLikes=0;
	private String blogDate=new Date().toString();
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogHeader() {
		return blogHeader;
	}
	public void setBlogHeader(String blogHeader) {
		this.blogHeader = blogHeader;
	}
	public String getBlogCategory() {
		return blogCategory;
	}
	public void setBlogCategory(String blogCategory) {
		this.blogCategory = blogCategory;
	}
	public String getBlogUser() {
		return blogUser;
	}
	public void setBlogUser(String blogUser) {
		this.blogUser = blogUser;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public int getBlogLikes() {
		return blogLikes;
	}
	public void setBlogLikes(int blogLikes) {
		this.blogLikes = blogLikes;
	}
	public String getBlogDate() {
		return blogDate;
	}
	public void setBlogDate(String blogDate) {
		this.blogDate = blogDate;
	}
	public Blog(int blogId, String blogHeader, String blogCategory, String blogUser, String blogContent) {
		super();
		this.blogId = blogId;
		this.blogHeader = blogHeader;
		this.blogCategory = blogCategory;
		this.blogUser = blogUser;
		this.blogContent = blogContent;
		this.isActive = "false";
		this.blogLikes = 0;
		this.blogDate = new Date().toString();
	}
	public Blog() {
		super();
	}
	
}
