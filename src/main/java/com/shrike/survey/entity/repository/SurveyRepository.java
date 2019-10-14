package com.shrike.survey.entity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shrike.survey.entity.Survey;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Integer>{

	@SuppressWarnings("unchecked")
	Survey save(Survey survey);
	
	List<Survey> findAll();
	
	Survey findAllBySurveyId(String surveyId);
}
