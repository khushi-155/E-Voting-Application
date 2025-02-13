package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;

@Service
public class ElectionChoiceService {
	
	@Autowired
	ElectionChoiceRepository electionChoiceRepository;
	
	@Autowired
	ElectionRepository electionRepository;
    
	public void addElectionChoice(ElectionChoice electionChoice) {
		Election election = electionRepository.findByName(electionChoice.getElection().getName());
		electionChoice.setElection(election);
		electionChoiceRepository.save(electionChoice);
	}

	public List<ElectionChoice> getAllElectionChoice() {
//		return electionChoiceRepository.findAll();
		  List<ElectionChoice> choices = electionChoiceRepository.findAll();
		    for (ElectionChoice choice : choices) {
		        if (choice.getElection() == null) {
		            // Handle the null case, e.g., log a warning or handle gracefully
		            System.out.println("Election is null for ElectionChoice with ID: " + choice.getId());
		        }
		    }
		    return choices;
	}

	public List<ElectionChoice> getAllChoiceByElection(Election election) {
		 if (election == null) {
		        throw new IllegalArgumentException("Election cannot be null");
		    }
		return electionChoiceRepository.findByElection(election);
	}

}
