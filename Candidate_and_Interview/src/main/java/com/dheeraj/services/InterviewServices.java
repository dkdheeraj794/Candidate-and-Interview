package com.dheeraj.services;

import java.util.List;

 import com.dheeraj.entities.Interview;

 
public interface InterviewServices {

	public List<Interview> getinterview();
	
	public Interview addinterview(Interview interview);
	
	public List<Interview> outcomeInterview(int id, String outcome);
}
