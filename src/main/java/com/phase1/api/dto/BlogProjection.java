package com.phase1.api.dto;

import org.hibernate.annotations.Immutable;

@Immutable
public class BlogProjection {

	public BlogProjection(Integer blogId,String title,String createdBy) {
		super();
		this.blogId = blogId;
		this.title=title;
		this.createdBy=createdBy;
	}
	private Integer blogId;
	private String title;
	private String createdBy;
	public Integer getBlogId() {
		return blogId;
	}
	public String getTitle() {
		return title;
	}
	public String getCreatedBy() {
		return createdBy;
	}
}
