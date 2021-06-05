package com.cognizant.bustravels.service;

import java.util.List;

import com.cognizant.bustravels.bean.Issues;
import com.cognizant.bustravels.exception.IssuesException;

public interface IIssuesService {

	public List<Issues> displayIssues();
	public boolean addIssues(Issues issues)throws IssuesException;
}
