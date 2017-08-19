package org.socialnetworking.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.socialnetworking.dao.IBlogDAO;
import org.socialnetworking.model.Blog;
import org.socialnetworking.model.BlogComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository("blogDAO")
@Transactional
@EnableTransactionManagement
public class BlogDAOImpl implements IBlogDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Blog getBlog(int id) {
		return sessionFactory.getCurrentSession().get(Blog.class, Integer.valueOf(id));
	}

	@Override
	public List<Blog> getAllBlogs() {
		return sessionFactory.getCurrentSession().createQuery("FROM Blog", Blog.class).getResultList();
	}

	@Override
	public List<Blog> getDBlogs() {
		return sessionFactory.getCurrentSession().createQuery("FROM Blog b where b.isActive='false'", Blog.class).getResultList();
	}

	@Override
	public List<Blog> getABlogs() {
		return sessionFactory.getCurrentSession().createQuery("FROM Blog b where b.isActive='true'", Blog.class).getResultList();
	}

	@Override
	public List<Blog> getBlogsByUserName(String userName) {
		return sessionFactory.getCurrentSession().createQuery("FROM Blog b where b.blogUser=:userName", Blog.class).getResultList();
	}

	@Override
	public Blog getBlogById(int blogId) {
		return (Blog)sessionFactory.getCurrentSession().createQuery("FROM Blog b where b.blogId=:blogId", Blog.class).setParameter("blogId",blogId).getResultList().get(0);
	}

	@Override
	public boolean activateBlog(int id) {
		try {
			Blog blog=getBlog(id);
			blog.setIsActive("true");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addBlog(Blog b) {
		try {
			sessionFactory.getCurrentSession().persist(b);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog b) {
		try {
			sessionFactory.getCurrentSession().update(b);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteBlog(int id) {
		try {
			sessionFactory.getCurrentSession().delete(getBlog(id));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean likeBlog(int id) {
		try {
			Blog blog=getBlog(id);
			blog.setBlogLikes(blog.getBlogLikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addComment(BlogComment b) {
		try {
			sessionFactory.getCurrentSession().persist(b);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
}
