package com.micro.questionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.micro.questionservice.model.Question;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	List<Question> findByCategory(String category);

	@Query(value = "SELECT q.id FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ" ,nativeQuery = true)
	List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
