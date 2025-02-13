package com.codingninjas.EVotingSystem.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Election {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column(unique = true)
	private String name;

//	  @OneToMany(mappedBy = "election", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//	  @JsonManagedReference 
//	  private List<ElectionChoice> electionChoices = new ArrayList<>();
//	
//	  
//	  
//	  
//	public List<ElectionChoice> getElectionChoices() {
//		return electionChoices;
//	}
//
//	public void setElectionChoices(List<ElectionChoice> electionChoices) {
//		this.electionChoices = electionChoices;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
