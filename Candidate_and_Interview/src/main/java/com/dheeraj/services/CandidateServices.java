package com.dheeraj.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dheeraj.entities.Candidate;
import com.dheeraj.entities.Interview;

 

public interface CandidateServices {
	
	public List<Candidate> getresumes();
	
	public Candidate postresumes(Candidate candidate);
	
	public List<Candidate> scheduleInterview(int candidate_id,int inteview_id);
	
	public List<Interview> GetCandidateInterview( int cid);
	
	public List<String> resultOut(int cid,int iid);
	
 
  
}
