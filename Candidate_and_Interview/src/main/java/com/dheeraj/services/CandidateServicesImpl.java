package com.dheeraj.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.dheeraj.dao.CandidateRepo;
import com.dheeraj.dao.InterviewRepo;
import com.dheeraj.entities.Candidate;
import com.dheeraj.entities.Interview;


@Service
public class CandidateServicesImpl implements CandidateServices {

	@Autowired
	private CandidateRepo candidaterepo;
	
	
	@Autowired
	private InterviewRepo interviewrepo;
	
	
	

	public CandidateServicesImpl() {
 
		// TODO Auto-generated constructor stub
	}




	@Override
	public List<Candidate> getresumes() {
		// TODO Auto-generated method stub
		return (List<Candidate>) candidaterepo.findAll() ;
	}




	@Override
	public Candidate postresumes(Candidate candidate) {
		
		candidaterepo.save(candidate);
		return candidate;
	}
	
	
	

	@Override
	public List<Interview> GetCandidateInterview(int cid) {
		Candidate ce = candidaterepo.findById(cid).get();
		List<Interview> candidateinterview = new ArrayList<>(ce.getInterview());
		return candidateinterview;
	}




	@Override
	public List<Candidate> scheduleInterview(int candidate_id, int inteview_id) {
		List<Candidate> candidateRecords = new ArrayList<>(); 
		Candidate cd = candidaterepo.findById(candidate_id).get();
		Interview iv = interviewrepo.findById(inteview_id).get();
		cd.setInterviews(iv);
		iv.addCandidates(cd);
		candidaterepo.save(cd);
		interviewrepo.save(iv);
		candidaterepo.findAll().forEach(candidateRecords::add);
		return candidateRecords;
	}




	@Override
	public List<String> resultOut(int cid, int iid) {
		String cname;
		long c_mobileno;
		String c_address;
		
		String c_skills;
		
		String c_education;
		List<String> str = new ArrayList<>();
		str.add("Id : "+Integer.toString(cid));
		
		Candidate ce = candidaterepo.findById(cid).get();
		cname=ce.getName();
		str.add("Name : "+cname);
		
		c_mobileno = ce.getMobile_number();
		str.add("Mobile Number : "+Long.toString(c_mobileno));
		
		
		c_address = ce.getAddress();
		str.add("Address : "+c_address);
		
		c_skills = ce.getSkills();
		str.add("Skills : "+c_skills);
		
		c_education = ce.getEducation();
		str.add("Education : "+c_education);

		List<Interview> candidateinterview = new ArrayList<>(ce.getInterview());
		String outcome = "";
		for(int i=0; i<candidateinterview.size(); i++) {
			if(candidateinterview.get(i).getId() == iid) {
				
				if(candidateinterview.get(i).getName().equals(Integer.toString(cid))) {
					outcome = "Passed the Interview";
				}
				else {
					outcome = "Failed the Interview";
				}
			}
			else {
				outcome= "Candidate has not scheduled this interview";
			}
		}
		str.add(outcome);
		return str;
	}




	 



	 


	
	
	
	
	 
	
}
