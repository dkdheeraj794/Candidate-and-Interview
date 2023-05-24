package com.dheeraj.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dheeraj.dao.CandidateRepo;
import com.dheeraj.dao.InterviewRepo;
import com.dheeraj.entities.Candidate;
import com.dheeraj.entities.Interview;

@Service
public class InterviewServicesImpl implements InterviewServices {

	@Autowired
	private InterviewRepo interviewrepo;
	
	
	@Autowired
	private CandidateRepo candidaterepo;


@Override
public List<Interview> getinterview() {
 
	
	return (List<Interview>) interviewrepo.findAll();
}


@Override
public Interview addinterview(Interview interview) {
 
	interviewrepo.save(interview);
	return interview;
}


@Override
public List<Interview> outcomeInterview(int id, String outcome) {
	List<Interview> interviewRecords = new ArrayList<>();
	Interview ie = interviewrepo.findById(id).get();
	ie.setName(outcome);
	interviewrepo.save(ie);
	interviewrepo.findAll().forEach(interviewRecords::add);    
	return interviewRecords;
}


 
}
