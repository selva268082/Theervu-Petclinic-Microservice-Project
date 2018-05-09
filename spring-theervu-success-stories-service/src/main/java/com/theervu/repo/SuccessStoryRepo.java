package com.theervu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theervu.dto.SuccessStory;

public interface SuccessStoryRepo extends JpaRepository<SuccessStory, Integer> {

}
