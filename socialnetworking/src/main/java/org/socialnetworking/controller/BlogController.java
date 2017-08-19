package org.socialnetworking.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.socialnetworking.dao.IBlogDAO;
import org.socialnetworking.model.Blog;
import org.socialnetworking.model.BlogComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8887")
@RestController
@RequestMapping("/blog")
public class BlogController 
{
	@Autowired
	IBlogDAO blogDAO;

	@Autowired
	private HttpServletRequest request;

	@PostMapping("/add")
	public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
		blog.setBlogDate(new Date().toString());
		blog.setBlogLikes(0);
		blog.setIsActive("false");
		if (blogDAO.addBlog(blog)) {

			System.out.println(blog);

			blog.setResponseMessage("Your post has been successfully registered .");
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		} else {
			return new ResponseEntity<Blog>(blog, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/viewD")
	public ResponseEntity<Blog> getDBlogs() {
		return new ResponseEntity(blogDAO.getDBlogs(), HttpStatus.OK);
	}
	
	@GetMapping("/viewA")
	public ResponseEntity<Blog> getABlogs() {
		return new ResponseEntity(blogDAO.getABlogs(), HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> deleteUser(@RequestBody int id) {
		if (blogDAO.deleteBlog(id)) {
			return new ResponseEntity<String>("Blog successfully deleted .", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Deletion failure.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/activate")
	public ResponseEntity<String> activateBlog(@RequestBody int id) {
		if (blogDAO.activateBlog(id)) {
			return new ResponseEntity<String>("Blog successfully activated .", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Blog activation failure.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//@GetMapping("/singleBlog")
	@RequestMapping(value = "/singleBlog/{blogId}")
	public ResponseEntity<Blog> getSingleBlog(@PathVariable("blogId") int blogId){
			//@RequestParam("blogHeader") String blogHeader) {
		
		return new ResponseEntity(blogDAO.getBlogById(blogId), HttpStatus.OK);
	}
	
	@PostMapping("/like")
	public ResponseEntity<String> likeBlog(@RequestBody int id) {
		if (blogDAO.likeBlog(id)) {
			return new ResponseEntity<String>("Blog successfully liked .", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Blog liking failure.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/addComment/{blogId}/{userId}/{comment}")
	public ResponseEntity<BlogComment> addCommentBlog(@PathVariable("blogId") int blogId,@PathVariable("userId") int userId,@PathVariable("comment") String comment) {
		BlogComment blogComment=new BlogComment();
		blogComment.setBlogId(blogId);
		blogComment.setUserId(userId);
		blogComment.setComment(comment);
		blogComment.setDate(new Date().toString());
		if (blogDAO.addComment(blogComment)) {

			System.out.println(blogComment);

			blogComment.setResponseMessage("Your comment has been successfully registered .");
			return new ResponseEntity<BlogComment>(blogComment, HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogComment>(blogComment, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
