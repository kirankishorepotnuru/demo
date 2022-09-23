package com.bootcamp.creditcard.response;

import java.util.Objects;

public class ResponseInfo {
	private int statusCode;
	private String statusName;
	private String message;
	private String path;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "ResponseInfo [statusCode=" + statusCode + ", statusName=" + statusName + ", message=" + message
				+ ", path=" + path + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(message, path, statusCode, statusName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseInfo other = (ResponseInfo) obj;
		return Objects.equals(message, other.message) && Objects.equals(path, other.path)
				&& statusCode == other.statusCode && Objects.equals(statusName, other.statusName);
	}
	public ResponseInfo(int statusCode, String statusName, String message, String path) {
		super();
		this.statusCode = statusCode;
		this.statusName = statusName;
		this.message = message;
		this.path = path;
	}
	public ResponseInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
