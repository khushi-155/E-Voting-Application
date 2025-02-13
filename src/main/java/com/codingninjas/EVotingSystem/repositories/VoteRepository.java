package com.codingninjas.EVotingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

	   Long countByElection(Election election);
}
