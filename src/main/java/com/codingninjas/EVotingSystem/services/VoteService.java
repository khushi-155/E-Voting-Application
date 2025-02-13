package com.codingninjas.EVotingSystem.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;

@Service
public class VoteService {

	@Autowired
	VoteRepository voteRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ElectionRepository electionRepository;
	
	@Autowired
	ElectionChoiceRepository electionChoiceRepository;

	public List<Vote> getAllVotes() {
		return voteRepository.findAll();
	}

	public void addVote(Vote vote) {
		Election election = electionRepository.findByName(vote.getElection().getName());
		User user = userRepository.findByName(vote.getUser().getName());
		ElectionChoice electionChoice = electionChoiceRepository.findByNameAndElection(vote.getElectionChoice().getName(), election);

		// set the fetched entities to vote before saving
		vote.setUser(user);
		vote.setElectionChoice(electionChoice);
		vote.setElection(election);
	      voteRepository.save(vote);
	}

	public Long getCountOfVote() {
		return voteRepository.count();
	}

	public long getCountVotesByElection(Election election) {
		 Election persistedElection = electionRepository.findById(election.getId())
		            .orElseThrow(() -> new RuntimeException("Election not found"));
		return voteRepository.countByElection(persistedElection);
	}
}
