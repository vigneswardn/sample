package com.phase1.api.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Users {
	

	public Users() {
		super();
	}
	
	public Users(int userId, String userName, String firstName, String lastName, String password, String email,
			String phone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public Users(int userId, List<Blog> blogs) {
		super();
		this.userId = userId;
		this.blogs = blogs;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String phone;
	
	//@ManyToMany(mappedBy="users",targetEntity=Blog.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	
	@JoinTable(name="users_blogs",joinColumns={@JoinColumn(name="userId")},inverseJoinColumns={@JoinColumn(name = "blogId")})
	@ManyToMany
	List<Blog> blogs;
	

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Blog> getBlogs() {
		if(blogs == null) {
			blogs = new ArrayList<Blog>();
		}
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	@Override
    public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("User ID: "+this.userId+" ");
		strBuilder.append("User Name : " +this.userName);
		return strBuilder.toString();
	}

	
	
}
