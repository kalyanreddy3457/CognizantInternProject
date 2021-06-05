package com.cognizant.bustravels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bustravels.bean.Issues;
import com.cognizant.bustravels.dao.IssuesDAO;
import com.cognizant.bustravels.exception.IssuesException;

@Service
public class IssuesService implements IIssuesService{

	@Autowired
	IssuesDAO issuesDAO;
	public List<Issues> displayIssues()
	{
		return issuesDAO.displayIssues();
	}
	public boolean addIssues(Issues issues)throws IssuesException {
		return issuesDAO.addIssues(issues);
	}

}
