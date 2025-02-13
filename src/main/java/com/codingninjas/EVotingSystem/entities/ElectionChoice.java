package com.codingninjas.EVotingSystem.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ElectionChoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "election_id")
//	@JsonBackReference
	private Election election;

//	@OneToMany(mappedBy = "electionChoice", cascade = { CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REMOVE})
//	private List<Vote> votes = new ArrayList<>();
//	
//
//	public List<Vote> getVotes() {
//		return votes;
//	}
//
//	public void setVotes(List<Vote> votes) {
//		this.votes = votes;
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

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}
	
}
