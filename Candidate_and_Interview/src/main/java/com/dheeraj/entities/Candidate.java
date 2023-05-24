package com.dheeraj.entities;

import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Candidate {
	
	@Id
	private int id;
	private String name;
	private long mobile_number;
	private String address;
	private String skills;
	private String education;
	
	public Candidate() {
 		// TODO Auto-generated constructor stub
	}
	
	public Candidate(int id, String name, long mobile_number, String address, String skills, String education) {
		super();
		this.id = id;
		this.name = name;
		this.mobile_number = mobile_number;
		this.address = address;
		this.skills = skills;
		this.education = education;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", mobile_number=" + mobile_number + ", address=" + address
				+ ", skills=" + skills + ", education=" + education + "]";
	}
	
	
	@ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
	@JoinTable(
			name="Candidate_Interview_Table",
			joinColumns = @JoinColumn(name = "candidate_id"),
			inverseJoinColumns = @JoinColumn(name = "interview_id"))
	
	private Set<Interview> interview ;

	public Set<Interview> getInterview() {
		return interview;
	}

	public void setInterview(Set<Interview> interview) {
		this.interview = interview;
	}

	public Candidate(Set<Interview> interview) {
		super();
		this.interview = interview;
	}

	public Set<Interview> setInterviews(Interview interviews) {
		interview.add(interviews);
		return interview;
		}
	
	
	
	
	
	
	
	
	

}
