package com.dheeraj.dao;

import org.springframework.data.repository.CrudRepository;

import com.dheeraj.entities.Candidate;

public interface CandidateRepo extends CrudRepository<Candidate,Integer>{

}
