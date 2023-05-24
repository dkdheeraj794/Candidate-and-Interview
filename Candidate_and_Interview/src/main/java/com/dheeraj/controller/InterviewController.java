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

 
import com.dheeraj.entities.Interview;
import com.dheeraj.services.InterviewServices;
 
@RestController
public class InterviewController {
	
	

	@Autowired
	private InterviewServices interviewservices;
	
	
	// Know the Interviewer
	@GetMapping("/interview")
	public List<Interview> getinterview(){
		return this.interviewservices.getinterview();
	}
	
	
	
	//Adding the detail of the Interview
	@PostMapping("/interview")
	public Interview addinterview(@RequestBody Interview interview) {
		return this.interviewservices.addinterview(interview);
	}
	

	@RequestMapping("/interviewoutcome")  
	public List<Interview> outcomeInterview(@RequestBody Map<String, String> input)   
	{  int d = Integer.parseInt(input.get("key"));
		interviewservices.outcomeInterview(d,input.get("value")); 
		return interviewservices.getinterview(); 
	}
	
	
	 
}
