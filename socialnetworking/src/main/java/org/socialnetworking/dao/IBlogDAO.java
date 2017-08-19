package org.socialnetworking.dao;

import java.util.List;

import org.socialnetworking.model.Blog;
import org.socialnetworking.model.BlogComment;

public interface IBlogDAO {

	public Blog getBlog(int id);
	public List<Blog> getAllBlogs();
	public List<Blog> getDBlogs();
	public List<Blog> getABlogs();
	public List<Blog> getBlogsByUserName(String userName);
	public Blog getBlogById(int blogId);
	public boolean activateBlog(int id);
	public boolean addBlog(Blog b);
	public boolean updateBlog(Blog b);
	public boolean deleteBlog(int id);
	public boolean likeBlog(int id);
	
	public boolean addComment(BlogComment b); 
}
