package com.phase1.api.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Blog {

	public Blog() {
		// TODO Auto-generated constructor stub
	}

	public Blog(String title, String content, Date createDate, Date modifiedDate, String createdBy,
			boolean isFavourite, String[] tags) {
		super();
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.isFavourite = isFavourite;
		this.tags = tags;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer blogId;
	
//	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)  
//    @JoinTable(name="users_blog", joinColumns=@JoinColumn(name="blogId"), inverseJoinColumns=@JoinColumn(name="userId")) 
	@ManyToMany(mappedBy="blogs")
	private List<Users> users;
	
	private String title;
	private String content;
	private Date createDate;
	private Date modifiedDate;
	private String createdBy;
	boolean isFavourite;
	private String[] tags;
	
	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isFavourite() {
		return isFavourite;
	}

	public void setFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Blog ID: "+this.blogId+" ");
		strBuilder.append("Blog Name : " +this.title);
		return strBuilder.toString();
	} 
	
}
