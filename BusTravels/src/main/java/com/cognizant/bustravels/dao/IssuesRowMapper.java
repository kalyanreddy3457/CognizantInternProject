package com.cognizant.bustravels.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.bustravels.bean.Issues;

public class IssuesRowMapper implements RowMapper<Issues> {

	@Override
	public Issues mapRow(ResultSet rs, int rowNum) throws SQLException {
		Issues issues = new Issues();
		issues.setIssue_id(rs.getInt(1));
		issues.setEmail_id(rs.getString(2));
		issues.setIssue_desc(rs.getString(3));
		return issues;
	}

}