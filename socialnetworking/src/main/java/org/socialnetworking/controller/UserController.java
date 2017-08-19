package org.socialnetworking.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.socialnetworking.dao.IUserDAO;
import org.socialnetworking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:8887")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserDAO userDAO;

	@Autowired
	private HttpServletRequest request;

	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
//		if (!(user.getFile().getOriginalFilename().equals(""))) {
//			user.setUserImage(uploadImage(user.getFile()));
//		}
		if (userDAO.addUser(user)) {

			System.out.println(user);

			user.setResponseMessage("You have been successfully registered .");
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/view")
	public ResponseEntity<User> getUsers() {
		return new ResponseEntity(userDAO.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/viewUser")
	public ResponseEntity<String> getUser(@RequestBody int id) {
		return new ResponseEntity(userDAO.getUser(id), HttpStatus.OK);
	}

	@GetMapping("/viewD")
	public ResponseEntity<User> getDUser() {
		return new ResponseEntity(userDAO.getDUsers(), HttpStatus.OK);
	}

	@GetMapping("/viewA")
	public ResponseEntity<User> getAUser() {
		return new ResponseEntity(userDAO.getAUsers(), HttpStatus.OK);
	}

	@PostMapping("/delete")
	public ResponseEntity<String> deleteUser(@RequestBody int id) {
		if (userDAO.deleteUser(id)) {
			return new ResponseEntity<String>("User successfully deleted .", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Deletion failure.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/activate")
	public ResponseEntity<String> activateUser(@RequestBody int id) {
		if (userDAO.activateUser(id)) {
			return new ResponseEntity<String>("User successfully activated .", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("User activation failure.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	protected String uploadImage(MultipartFile multipart) {
//		String folderToUpload = "/resources/images/";
//		String filename = multipart.getOriginalFilename();
//		String realPath = request.getServletContext().getRealPath(folderToUpload);
//		if (!new File(realPath).exists()) {
//			new File(realPath).mkdirs();
//		}
//		String filePath = realPath + filename;
//		File destination = new File(filePath);
//		try {
//			multipart.transferTo(destination);
//		} catch (Exception ex) {
//		}
//		return filename;
//	}

}
