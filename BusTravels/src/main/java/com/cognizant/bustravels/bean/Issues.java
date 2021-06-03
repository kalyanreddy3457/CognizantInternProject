package com.cognizant.bustravels.bean;

public class Issues {

	private int issue_id;
	private String email_id;
	private String issue_desc;
	public int getIssue_id() {
		return issue_id;
	}
	public void setIssue_id(int issue_id) {
		this.issue_id = issue_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getIssue_desc() {
		return issue_desc;
	}
	public void setIssue_desc(String issue_desc) {
		this.issue_desc = issue_desc;
	}
	@Override
	public String toString() {
		return "Issues [issue_id=" + issue_id + ", email_id=" + email_id + ", issue_desc=" + issue_desc + "]";
	}
	
}
