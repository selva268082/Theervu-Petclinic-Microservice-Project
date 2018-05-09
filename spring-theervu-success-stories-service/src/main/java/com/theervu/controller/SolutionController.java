package com.theervu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.theervu.dto.SuccessStory;
import com.theervu.error.BindingErrorResponse;
import com.theervu.service.SolutionService;


@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
public class SolutionController {
	@Autowired
	SolutionService solutionService;
	
	@RequestMapping(value="/allsuccessstories",method=RequestMethod.GET)
	public ResponseEntity< List<SuccessStory>> findAllStories(){
		  //Fetch all the success stories	
		  List<SuccessStory> successStoriesLst=solutionService.findAllSuccessStories();
		  //if story not found then throw the exception
		  if(successStoriesLst!=null && successStoriesLst.isEmpty()){
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
		  return new ResponseEntity<List<SuccessStory>>(successStoriesLst,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addsuccessstory", method=RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<SuccessStory> addSuccessStory(@Valid @RequestBody SuccessStory successStory, BindingResult bindingResult,
    		UriComponentsBuilder ucBuilder){
    	BindingErrorResponse errors=new BindingErrorResponse();
    	HttpHeaders httpHeaders=new HttpHeaders();
    	//validate the input data success stories
		if(bindingResult.hasErrors())
		{
			errors.addErrors(bindingResult);
			httpHeaders.add("errors",errors.toJSON());
			return new ResponseEntity<>(httpHeaders,HttpStatus.BAD_REQUEST);
		}
		SuccessStory savedStory=null;
		try{
			savedStory=this.solutionService.addSuccessStory(successStory);
		}catch(DataAccessException ex){
			System.out.println("DataException : : :  "+ex);
		}
		httpHeaders.setLocation(ucBuilder.path("/addsuccessstory/{id}").buildAndExpand(savedStory.getStoryId()).toUri());
    	return new ResponseEntity<SuccessStory>(savedStory,HttpStatus.OK);
    }
}
