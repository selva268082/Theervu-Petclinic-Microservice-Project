package com.theervu.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.theervu.dto.SuccessStory;
import com.theervu.repo.SuccessStoryRepo;
import com.theervu.service.SolutionService;

@Component
public class SolutionServiceImpl implements SolutionService {
    
	@Autowired
	SuccessStoryRepo successStoryRepo;
	
	@Override
	public List<SuccessStory> findAllSuccessStories() {
		
		  List<SuccessStory> successStoriesLst= successStoryRepo.findAll();
		  
		  return successStoriesLst;
		 
	}

	@Override
	@Transactional
	public SuccessStory addSuccessStory(SuccessStory successStory) throws DataAccessException {
		SuccessStory savedStory=successStoryRepo.save(successStory);
		return savedStory;
	}

}
