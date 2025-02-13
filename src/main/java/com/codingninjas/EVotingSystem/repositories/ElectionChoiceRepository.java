package com.codingninjas.EVotingSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;

public interface ElectionChoiceRepository extends JpaRepository<ElectionChoice, Long>{

	List<ElectionChoice> findByElection(Election election);
	

//	@Query("SELECT ec FROM ElectionChoice ec WHERE ec.election = :election ORDER BY SIZE(ec.votes) DESC")
	@Query("SELECT ec FROM ElectionChoice ec")
	List<ElectionChoice> findTopByElectionOrderByVoteDesc(@Param("election") Election election);

	ElectionChoice findByNameAndElection(String name, Election election);

	@Query(value = "SELECT ec.* FROM election_choice ec "
			+ "JOIN vote v ON ec.id = v.election_choice_id "
			+ "WHERE ec.election_id = :electionId "
			+ "GROUP BY ec.id "
			+ "ORDER BY COUNT(v.id) DESC LIMIT 1", nativeQuery = true)
	ElectionChoice getWinner(@Param("electionId") Long electionId);
}
