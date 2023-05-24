package com.dheeraj.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

 
@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Interview {

	@Id
	private int Id;
	private String name;
	private String company;
	private String email;
	private String StartTime;
	private String endTime;
 	public Interview() {
 
		// TODO Auto-generated constructor stub
	}
	public Interview(int id, String name, String company, String email,String startTIme, String endTime ) {
		super();
		Id = id;
		this.name = name;
		this.company = company;
		this.email = email;
		this.StartTime = StartTime;
		this.endTime = endTime;
 	}
	
	 
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	 
	 
	
	@Override
	public String toString() {
		return "Interview [Id=" + Id + ", name=" + name + ", company=" + company + ", email=" + email + ", StartTime="
				+ StartTime + ", endTime=" + endTime + ", candidate=" + candidate + "]";
	}





	@ManyToMany(mappedBy="interview" , fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private Set<Candidate> candidate;
	public Set<Candidate> getCandidate() {
		return candidate;
	}
	public void setCandidate(Set<Candidate> candidate) {
		this.candidate = candidate;
	}
	public Interview(Set<Candidate> candidate) {
		super();
		this.candidate = candidate;
	}
	
	public Set<Candidate> addCandidates(Candidate candidates) {
		((Set<Candidate>) candidate).add(candidates);
		return  (Set<Candidate>) candidate;
		}
	
	
	
}
