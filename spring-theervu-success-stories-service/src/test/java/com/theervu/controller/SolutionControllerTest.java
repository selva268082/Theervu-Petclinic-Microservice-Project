package com.theervu.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.theervu.dto.AvailableFormat;
import com.theervu.dto.Person;
import com.theervu.dto.SuccessStory;
import com.theervu.service.SolutionService;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,classes={SolutionController.class})

public class SolutionControllerTest {
	
	private MockMvc mockMvc;
	
	@MockBean
	private SolutionService solutionService;
	
	@Autowired
	private SolutionController classUnderTest;
	
	private List<SuccessStory> successStoriesLst;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.mockMvc= MockMvcBuilders.standaloneSetup(classUnderTest).build();
		
		successStoriesLst=new ArrayList<SuccessStory>(); 
		
		SuccessStory successStory=new SuccessStory();
		successStory.setStoryId(1);
		successStory.setTypeofdisease("Fever");
		
		List<Person> personLst=new ArrayList<Person>();
		//First person
		Person person=new Person();
		person.setPersonId(1);
		person.setPersonName("Selva");
		person.setPersonPlace("Madurai");
		
		//Second person
		Person person1=new Person();
		person1.setPersonId(2);
		person1.setPersonName("Pandy");
		person1.setPersonPlace("Chennai");
		
			
		List<AvailableFormat> availableFormatLst=new ArrayList<AvailableFormat>();
		//AvailableFormat - 1
		AvailableFormat availableFormat1=new AvailableFormat();
		availableFormat1.setFormatType("PDF");
		availableFormat1.setLink("");
		availableFormat1.setStatus("Yes");
		availableFormat1.setFormatID(1);
		
		//Add AvailableFormat object in the List
		availableFormatLst.add(availableFormat1);
		
		//AvailableFormat - 2
		AvailableFormat availableFormat2=new AvailableFormat();
		availableFormat2.setFormatType("PDF");
		availableFormat2.setLink("");
		availableFormat2.setStatus("Yes");
		availableFormat2.setFormatID(1);
		
		//Add AvailableFormat object in the List
		availableFormatLst.add(availableFormat2);
		//Add AvailableFormat List of objects in the Person
		person.setAvailableFormat(availableFormatLst);
		//Add Person object in the List
		personLst.add(person);
		//Add Person List object in the Person
		successStory.setPerson(personLst);
		
		successStoriesLst.add(successStory);
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllSuccessStories() throws Exception {
		//successStoriesLst.remove(0); - Just to check for not found record
		when(this.solutionService.findAllSuccessStories()).thenReturn(successStoriesLst);
		
		this.mockMvc.perform(get("/allsuccessstories").accept(MediaType.APPLICATION_JSON))
		            .andExpect(status().isOk())
		            .andExpect(content().contentType("application/json;charset=UTF-8"))
		            .andExpect(jsonPath("$.[0].storyId").value(1))
		            .andExpect(jsonPath("$.[0].typeofdisease").value("Fever"));
	}
	@Test
	public void testNotFoundSuccessStories() throws Exception {
		successStoriesLst.clear();
		when(this.solutionService.findAllSuccessStories()).thenReturn(successStoriesLst);
		this.mockMvc.perform(get("/allsuccessstories").accept(MediaType.APPLICATION_JSON))
		            .andExpect(status().isNotFound());
		
	 
	}

   @Test
   public void testCreateNewStory() throws Exception{
	   	SuccessStory successStory=successStoriesLst.get(0);
	   	ObjectMapper mapper = new ObjectMapper();
   		String newOwnerAsJSON = mapper.writeValueAsString(successStory);
   		this.mockMvc.perform(post("/addsuccessstory")
   		.content(newOwnerAsJSON).accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
   		.andExpect(status().isCreated());
	   
   }
}
