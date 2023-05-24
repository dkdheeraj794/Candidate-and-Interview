package com.dheeraj.dao;

import org.springframework.data.repository.CrudRepository;

import com.dheeraj.entities.Interview;

public interface InterviewRepo extends CrudRepository<Interview,Integer> {

}
