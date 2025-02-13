package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;

@Service
public class ResultService {

	@Autowired
	ElectionChoiceRepository electionChoiceRepository;
	
	@Autowired
	ElectionRepository electionRepository;

	public ElectionChoice getElectionChoiceForElection(Election election) {
//		return electionChoiceRepository.findTopByElectionOrderByVoteDesc(election);
//		 List<ElectionChoice> choices = electionChoiceRepository.findByName(election.getName());
//		    if (choices.isEmpty()) {
//		        return null; // or throw an exception
//		    }
//		    return choices.get(0);
		
		// fetch election with name first
				Election existingElection = electionRepository.findByName(election.getName());
				// and then pass the id of the fetched election
				return electionChoiceRepository.getWinner(existingElection.getId());
	}
	

}
