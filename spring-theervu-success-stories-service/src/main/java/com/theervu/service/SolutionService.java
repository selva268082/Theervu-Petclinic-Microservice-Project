package com.theervu.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.theervu.dto.SuccessStory;

public interface SolutionService {

	List<SuccessStory> findAllSuccessStories() throws DataAccessException;
	SuccessStory addSuccessStory(SuccessStory successStory) throws DataAccessException;

}
