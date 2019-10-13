package com.shrike.survey.entity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shrike.survey.entity.Survey;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Integer>{

	@SuppressWarnings("unchecked")
	Survey save(Survey survey);
}
