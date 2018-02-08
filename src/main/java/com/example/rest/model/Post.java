package com.example.rest.model;

public class Post {
	private int userId;
	private int id;
	private String title;
	private String body;

	public Post(int userId, int id, String title, String body) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + userId;
		result = 31 * result + id;
		result = 31 * result + title != null ? title.hashCode() : 0;
		result = 31 * result + body != null ? body.hashCode() : 0;
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof Post)) {
			return false;
		}
		if (this == object) {
			return true;
		}
		Post other = (Post) object;

		return userId == other.getUserId() &&
				id == other.getId() &&
				areEqual(title, other.getTitle()) &&
				areEqual(body, other.getBody());
	}

	private boolean areEqual(String s1, String s2) {
		return s1 == null ? s2 == null : s1.equals(s2);
	}
	
	
}
