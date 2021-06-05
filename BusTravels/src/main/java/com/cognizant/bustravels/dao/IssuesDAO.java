package com.cognizant.bustravels.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.bustravels.bean.Issues;
import com.cognizant.bustravels.exception.IssuesException;

@Repository
public class IssuesDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Issues> displayIssues()
	{
		String sql="select * from issues";
		return jdbcTemplate.query(sql,new IssuesRowMapper());
	}
	public boolean addIssues(Issues issues) throws IssuesException
	{
		try
		{
		String sql="insert into issues(email_id,issue_desc) values(?,?)";
		return jdbcTemplate.update(sql,issues.getEmail_id(),issues.getIssue_desc())>0;
		}
		catch(DataAccessException e)
		{
			throw new IssuesException("email_id not found");
		}
	}
}
