package com.dheeraj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 import com.dheeraj.entities.Candidate;
import com.dheeraj.entities.Interview;
import com.dheeraj.services.CandidateServices;

@RestController
public class CandidateController {
	
	@Autowired
	private CandidateServices candidateservices;
	
	@GetMapping("/home")
	public String home() {
		return "This is home page";
	}
	
	
	// Get the Resume of all the Candidate
	@GetMapping("/resume")
	public List<Candidate> getresumes(){
		
		return this.candidateservices.getresumes();
		
	}
	
	
	// Facility for adding resumes of candidates
	
	
	@PostMapping("/resume")
	public Candidate postresumes(@RequestBody Candidate candidate) {
		return this.candidateservices.postresumes(candidate);
		
	}
	
	//  Facility for scheduling interviews 
	
	@GetMapping("/schedule")
	public List<Candidate> scheduleInterview(@RequestBody Map<String , String> input){
		candidateservices.scheduleInterview(Integer.parseInt(input.get("candidate_id")),Integer.parseInt(input.get("interview_id")));
		return this.candidateservices.getresumes();
	}

	
	//3. Facility for linking the resumes with interview results
	
	
	
	@RequestMapping("/result")
	public List<String> resultOut(@RequestBody Map<String,String > res ) {
		
		return this.candidateservices.resultOut(Integer.parseInt(res.get("candidate_id")), Integer.parseInt(res.get("interview_id")));

	}
	
	
	 
	
	
	// 4. search

	@RequestMapping("/candidateinterview/{cid}")
	public List<Interview> GetCandidateInterview(@PathVariable int cid){
		return candidateservices.GetCandidateInterview(cid);
	}
	 
	
	 
	
	
	
	 
	
	

	
}
