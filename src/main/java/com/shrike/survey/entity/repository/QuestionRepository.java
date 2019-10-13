package com.shrike.survey.entity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shrike.survey.entity.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer>{

}
