package org.socialnetworking.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "UserDetails")
public class User extends DomainResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3460250219598355519L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "users_seq", allocationSize = 1)
	private int userId;
	private String userName;
	private String fullName;
	private String password;
	private String conPassword;
	private String email;
	private String phone;
	private String role;
	private String isOnline="false";
	public String userImage;
	
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

//	@Transient
//	private MultipartFile file;
//	public MultipartFile getFile()
//	{
//	return file;
//	}
//	public void setFile(MultipartFile file)
//	{
//	this.file=file;
//	}


	public User(int userId, String userName, String fullName, String password, String conPassword, String email,
			String phone, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.conPassword = conPassword;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.isOnline = "false";
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConPassword() {
		return conPassword;
	}

	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", fullName=" + fullName + ", password=" + password
				+ ", conPassword=" + conPassword + ", email=" + email + ", phone=" + phone + ", role=" + role
				+ ", isOnline=" + isOnline + "]";
	}
	

}
