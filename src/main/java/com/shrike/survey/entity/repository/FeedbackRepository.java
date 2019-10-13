package com.shrike.survey.entity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shrike.survey.entity.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

	@SuppressWarnings("unchecked")
	Feedback save(Feedback feedback);
	
	List<Feedback> findAllByAuthor(String author);
}
